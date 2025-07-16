package adomlogistics.model;

public class Driver {
    private String id;
    private String name;
    private int experience;
    private String location;
    private String[] assignedRoutes;
    private int recentDelays;
    private int infractions;

    public Driver(String id, String name, int experience, String location) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.location = location;
        this.assignedRoutes = new String[10];
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public String getLocation() { return location; }
    public String[] getAssignedRoutes() { return assignedRoutes; }
    public int getRecentDelays() { return recentDelays; }
    public int getInfractions() { return infractions; }
    public void addRoute(String route) {
        for (int i = 0; i < assignedRoutes.length; i++) {
            if (assignedRoutes[i] == null) {
                assignedRoutes[i] = route;
                break;
            }
        }
    }
    public void addDelay() { recentDelays++; }
    public void addInfraction() { infractions++; }
} 