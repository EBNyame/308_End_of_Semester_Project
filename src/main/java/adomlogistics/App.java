package adomlogistics;

import adomlogistics.model.*;
import adomlogistics.service.*;
import java.util.Scanner;

public class App {
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleService vehicleService = new VehicleService("vehicles.txt");
        DriverService driverService = new DriverService("drivers.txt", 100);
        DeliveryService deliveryService = new DeliveryService("deliveries.txt");
        MaintenanceService maintenanceService = new MaintenanceService("vehicles.txt", 100);
        ReportService reportService = new ReportService();
        while (true) {
            try {
                System.out.println();
                System.out.println(BLUE + "==================== Adom Logistics Fleet Management ====================" + RESET);
                System.out.println(CYAN + "1. Add Vehicle" + RESET);
                System.out.println(CYAN + "2. Search Vehicle" + RESET);
                System.out.println(CYAN + "3. Add Driver" + RESET);
                System.out.println(CYAN + "4. Assign Driver" + RESET);
                System.out.println(CYAN + "5. Add Delivery" + RESET);
                System.out.println(CYAN + "6. Next Delivery" + RESET);
                System.out.println(CYAN + "7. Next for Maintenance" + RESET);
                System.out.println(RED + "8. Exit" + RESET);
                System.out.println(BLUE + "=======================================================================" + RESET);
                int c = getIntInput(sc, YELLOW + "\nEnter your choice: " + RESET);
                System.out.println();
                if (c == 1) {
                    System.out.println(MAGENTA + "--- Add Vehicle ---" + RESET);
                    System.out.print("Reg No: "); String reg = sc.nextLine();
                    System.out.print("Type: "); String type = sc.nextLine();
                    int mil = getIntInput(sc, "Mileage: ");
                    double fuel = getDoubleInput(sc, "Fuel Usage: ");
                    System.out.print("Driver ID: "); String did = sc.nextLine();
                    vehicleService.addVehicle(new Vehicle(reg, type, mil, fuel, did));
                    System.out.println(GREEN + "Vehicle added." + RESET);
                } else if (c == 2) {
                    System.out.println(MAGENTA + "--- Search Vehicle ---" + RESET);
                    System.out.print("Reg No: "); String reg = sc.nextLine();
                    Vehicle v = vehicleService.searchVehicle(reg);
                    if (v != null) System.out.println(GREEN + "Found: " + v.getType() + ", " + v.getMileage() + RESET);
                    else System.out.println(RED + "Not found" + RESET);
                } else if (c == 3) {
                    System.out.println(MAGENTA + "--- Add Driver ---" + RESET);
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    int exp = getIntInput(sc, "Exp: ");
                    System.out.print("Loc: "); String loc = sc.nextLine();
                    driverService.addDriver(new Driver(id, name, exp, loc));
                    System.out.println(GREEN + "Driver added." + RESET);
                } else if (c == 4) {
                    System.out.println(MAGENTA + "--- Assign Driver ---" + RESET);
                    Driver d = driverService.assignDriver();
                    if (d != null) System.out.println(GREEN + "Assigned: " + d.getName() + RESET);
                    else System.out.println(RED + "No driver" + RESET);
                } else if (c == 5) {
                    System.out.println(MAGENTA + "--- Add Delivery ---" + RESET);
                    System.out.print("Pkg ID: "); String pid = sc.nextLine();
                    System.out.print("Origin: "); String o = sc.nextLine();
                    System.out.print("Dest: "); String d = sc.nextLine();
                    System.out.print("Vehicle: "); String vid = sc.nextLine();
                    System.out.print("Driver: "); String drid = sc.nextLine();
                    System.out.print("ETA: "); String eta = sc.nextLine();
                    deliveryService.addDelivery(new Delivery(pid, o, d, vid, drid, eta));
                    System.out.println(GREEN + "Delivery added." + RESET);
                } else if (c == 6) {
                    System.out.println(MAGENTA + "--- Next Delivery ---" + RESET);
                    Delivery del = deliveryService.nextDelivery();
                    if (del != null) System.out.println(GREEN + "Next: " + del.getPackageId() + " to " + del.getDestination() + RESET);
                    else System.out.println(RED + "No delivery" + RESET);
                } else if (c == 7) {
                    System.out.println(MAGENTA + "--- Next for Maintenance ---" + RESET);
                    Vehicle v = maintenanceService.nextForService();
                    if (v != null) System.out.println(GREEN + "Service: " + v.getRegistrationNumber() + RESET);
                    else System.out.println(RED + "No vehicle" + RESET);
                } else if (c == 8) {
                    System.out.println(RED + "Exiting..." + RESET);
                    break;
                } else {
                    System.out.println(RED + "Invalid choice." + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Error: " + e.getMessage() + RESET);
                sc.nextLine(); // clear buffer
            }
        }
        sc.close();
    }
    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(RED + "Invalid number. Try again." + RESET);
            }
        }
    }
    private static double getDoubleInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println(RED + "Invalid number. Try again." + RESET);
            }
        }
    }
} 