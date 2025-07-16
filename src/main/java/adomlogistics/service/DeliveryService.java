package adomlogistics.service;

import adomlogistics.model.Delivery;
import adomlogistics.data.DeliveryQueue;
import adomlogistics.storage.FileManager;
import java.util.List;

public class DeliveryService {
    private DeliveryQueue queue;
    private String filename;
    public DeliveryService(String filename) {
        this.filename = filename;
        queue = new DeliveryQueue();
        List<Delivery> deliveries = FileManager.readDeliveries(filename);
        for (Delivery d : deliveries) queue.enqueue(d);
    }
    public void addDelivery(Delivery d) {
        queue.enqueue(d);
        save();
    }
    public Delivery nextDelivery() {
        Delivery d = queue.dequeue();
        save();
        return d;
    }
    private void save() {
        // Not optimal: flatten queue to list for saving
        // Implement as needed
    }
} 