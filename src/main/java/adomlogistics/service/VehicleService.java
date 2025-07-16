package adomlogistics.service;

import adomlogistics.model.Vehicle;
import adomlogistics.data.VehicleTree;
import adomlogistics.storage.FileManager;
import java.util.List;

public class VehicleService {
    private VehicleTree tree;
    private String filename;
    public VehicleService(String filename) {
        this.filename = filename;
        tree = new VehicleTree();
        List<Vehicle> vehicles = FileManager.readVehicles(filename);
        for (Vehicle v : vehicles) tree.insert(v);
    }
    public void addVehicle(Vehicle v) {
        tree.insert(v);
        save();
    }
    public void removeVehicle(String reg) {
        tree.delete(reg);
        save();
    }
    public Vehicle searchVehicle(String reg) {
        return tree.search(reg);
    }
    private void save() {
        // Not optimal: flatten tree to list for saving
        // For now, just reload from file for demo
        // Implement in-order traversal to list
    }
} 