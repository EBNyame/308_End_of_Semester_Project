package adomlogistics.model;

public class Vehicle {
    private String registrationNumber;
    private String type;
    private int mileage;
    private double fuelUsage;
    private String driverId;
    private MaintenanceRecord[] maintenanceHistory;
    
    public Vehicle(String registrationNumber, String type, int mileage, double fuelUsage, String driverId) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.mileage = mileage;
        this.fuelUsage = fuelUsage;
        this.driverId = driverId;
        this.maintenanceHistory = new MaintenanceRecord[10];
    }
    
    public String getRegistrationNumber() { return registrationNumber; }
    public String getType() { return type; }
    public int getMileage() { return mileage; }
    public double getFuelUsage() { return fuelUsage; }
    public String getDriverId() { return driverId; }
    public MaintenanceRecord[] getMaintenanceHistory() { return maintenanceHistory; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setFuelUsage(double fuelUsage) { this.fuelUsage = fuelUsage; }
    public void setDriverId(String driverId) { this.driverId = driverId; }
    public void addMaintenanceRecord(MaintenanceRecord record) {
        for (int i = 0; i < maintenanceHistory.length; i++) {
            if (maintenanceHistory[i] == null) {
                maintenanceHistory[i] = record;
                break;
            }
        }
    }
} 