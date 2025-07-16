package adomlogistics.model;

public class MaintenanceRecord {
    private String date;
    private int mileage;
    private java.util.HashMap<String, Double> partsAndCosts;

    public MaintenanceRecord(String date, int mileage) {
        this.date = date;
        this.mileage = mileage;
        this.partsAndCosts = new java.util.HashMap<>();
    }

    public String getDate() { return date; }
    public int getMileage() { return mileage; }
    public java.util.HashMap<String, Double> getPartsAndCosts() { return partsAndCosts; }
    public void addPart(String part, double cost) { partsAndCosts.put(part, cost); }
} 