package adomlogistics.model;

public class Delivery {
    private String packageId;
    private String origin;
    private String destination;
    private String vehicleId;
    private String driverId;
    private String eta;
    private String status;

    public Delivery(String packageId, String origin, String destination, String vehicleId, String driverId, String eta) {
        this.packageId = packageId;
        this.origin = origin;
        this.destination = destination;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.eta = eta;
        this.status = "Pending";
    }

    public String getPackageId() { return packageId; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getVehicleId() { return vehicleId; }
    public String getDriverId() { return driverId; }
    public String getEta() { return eta; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 