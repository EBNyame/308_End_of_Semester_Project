package adomlogistics.data;

import adomlogistics.model.Delivery;

public class DeliveryQueue {
    private class Node {
        Delivery delivery;
        Node next;
        Node(Delivery d) { delivery = d; }
    }
    private Node front, rear;
    public void enqueue(Delivery d) {
        Node n = new Node(d);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }
    public Delivery dequeue() {
        if (front == null) return null;
        Delivery d = front.delivery;
        front = front.next;
        if (front == null) rear = null;
        return d;
    }
    public Delivery peek() {
        return front == null ? null : front.delivery;
    }
} 