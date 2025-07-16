package adomlogistics.data;

import adomlogistics.model.Vehicle;

public class VehicleTree {
    private class Node {
        Vehicle vehicle;
        Node left, right;
        Node(Vehicle v) { vehicle = v; }
    }
    private Node root;

    public void insert(Vehicle v) {
        root = insertRec(root, v);
    }
    private Node insertRec(Node root, Vehicle v) {
        if (root == null) return new Node(v);
        if (v.getRegistrationNumber().compareTo(root.vehicle.getRegistrationNumber()) < 0)
            root.left = insertRec(root.left, v);
        else
            root.right = insertRec(root.right, v);
        return root;
    }
    public Vehicle search(String reg) {
        Node n = root;
        while (n != null) {
            int cmp = reg.compareTo(n.vehicle.getRegistrationNumber());
            if (cmp == 0) return n.vehicle;
            n = cmp < 0 ? n.left : n.right;
        }
        return null;
    }
    public void delete(String reg) {
        root = deleteRec(root, reg);
    }
    private Node deleteRec(Node root, String reg) {
        if (root == null) return null;
        int cmp = reg.compareTo(root.vehicle.getRegistrationNumber());
        if (cmp < 0) root.left = deleteRec(root.left, reg);
        else if (cmp > 0) root.right = deleteRec(root.right, reg);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node min = root.right;
            while (min.left != null) min = min.left;
            root.vehicle = min.vehicle;
            root.right = deleteRec(root.right, min.vehicle.getRegistrationNumber());
        }
        return root;
    }
} 