package adomlogistics.storage;

import adomlogistics.model.*;
import java.io.*;
import java.util.*;

public class FileManager {
    public static List<Vehicle> readVehicles(String filename) {
        List<Vehicle> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                Vehicle v = new Vehicle(p[0], p[1], Integer.parseInt(p[2]), Double.parseDouble(p[3]), p[4]);
                list.add(v);
            }
        } catch (Exception e) {}
        return list;
    }
    public static void writeVehicles(String filename, List<Vehicle> vehicles) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Vehicle v : vehicles) {
                pw.println(v.getRegistrationNumber()+","+v.getType()+","+v.getMileage()+","+v.getFuelUsage()+","+v.getDriverId());
            }
        } catch (Exception e) {}
    }
    public static List<Driver> readDrivers(String filename) {
        List<Driver> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                Driver d = new Driver(p[0], p[1], Integer.parseInt(p[2]), p[3]);
                list.add(d);
            }
        } catch (Exception e) {}
        return list;
    }
    public static void writeDrivers(String filename, List<Driver> drivers) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Driver d : drivers) {
                pw.println(d.getId()+","+d.getName()+","+d.getExperience()+","+d.getLocation());
            }
        } catch (Exception e) {}
    }
    public static List<Delivery> readDeliveries(String filename) {
        List<Delivery> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                Delivery d = new Delivery(p[0], p[1], p[2], p[3], p[4], p[5]);
                d.setStatus(p.length > 6 ? p[6] : "Pending");
                list.add(d);
            }
        } catch (Exception e) {}
        return list;
    }
    public static void writeDeliveries(String filename, List<Delivery> deliveries) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Delivery d : deliveries) {
                pw.println(d.getPackageId()+","+d.getOrigin()+","+d.getDestination()+","+d.getVehicleId()+","+d.getDriverId()+","+d.getEta()+","+d.getStatus());
            }
        } catch (Exception e) {}
    }
    public static List<MaintenanceRecord> readMaintenance(String filename) {
        List<MaintenanceRecord> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                MaintenanceRecord m = new MaintenanceRecord(p[0], Integer.parseInt(p[1]));
                for (int i = 2; i < p.length; i += 2) {
                    m.addPart(p[i], Double.parseDouble(p[i+1]));
                }
                list.add(m);
            }
        } catch (Exception e) {}
        return list;
    }
    public static void writeMaintenance(String filename, List<MaintenanceRecord> records) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (MaintenanceRecord m : records) {
                StringBuilder sb = new StringBuilder();
                sb.append(m.getDate()).append(",").append(m.getMileage());
                for (Map.Entry<String, Double> e : m.getPartsAndCosts().entrySet()) {
                    sb.append(",").append(e.getKey()).append(",").append(e.getValue());
                }
                pw.println(sb.toString());
            }
        } catch (Exception e) {}
    }
} 