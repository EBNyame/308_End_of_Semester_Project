package adomlogistics.service;

import adomlogistics.model.MaintenanceRecord;
import adomlogistics.model.Vehicle;
import adomlogistics.data.MaintenanceMinHeap;
import adomlogistics.storage.FileManager;
import java.util.List;

public class MaintenanceService {
    private MaintenanceMinHeap heap;
    private String filename;
    public MaintenanceService(String filename, int capacity) {
        this.filename = filename;
        heap = new MaintenanceMinHeap(capacity);
        List<Vehicle> vehicles = FileManager.readVehicles(filename);
        for (Vehicle v : vehicles) heap.insert(v);
    }
    public Vehicle nextForService() {
        return heap.extractMin();
    }
    public void addMaintenanceRecord(MaintenanceRecord record) {
        // Implement as needed
    }
} 