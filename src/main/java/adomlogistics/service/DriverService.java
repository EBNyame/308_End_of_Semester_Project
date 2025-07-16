package adomlogistics.service;

import adomlogistics.model.Driver;
import adomlogistics.data.DriverQueue;
import adomlogistics.storage.FileManager;
import java.util.List;

public class DriverService {
    private DriverQueue queue;
    private String filename;
    public DriverService(String filename, int capacity) {
        this.filename = filename;
        queue = new DriverQueue(capacity);
        List<Driver> drivers = FileManager.readDrivers(filename);
        for (Driver d : drivers) queue.enqueue(d);
    }
    public void addDriver(Driver d) {
        queue.enqueue(d);
        save();
    }
    public Driver assignDriver() {
        Driver d = queue.dequeue();
        save();
        return d;
    }
    private void save() {
        // Not optimal: flatten queue to list for saving
        // Implement as needed
    }
} 