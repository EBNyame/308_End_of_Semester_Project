package adomlogistics.service;

import adomlogistics.model.Vehicle;
import java.util.List;

public class ReportService {
    public double averageFuelUsage(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) return 0;
        double sum = 0;
        for (Vehicle v : vehicles) sum += v.getFuelUsage();
        return sum / vehicles.size();
    }
    public void sortByMileage(List<Vehicle> vehicles) {
        vehicles.sort((a, b) -> Integer.compare(a.getMileage(), b.getMileage()));
    }
    public void sortByDriverName(List<Vehicle> vehicles) {
        vehicles.sort((a, b) -> a.getDriverId().compareTo(b.getDriverId()));
    }
} 