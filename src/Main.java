import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // =========================
    // CUSTOMER DATA
    // =========================
    static String customerName = "";
    static String contactNumber = "";
    static String vehicleName = "";
    static String vehiclePlate = "";
    static String vehicleType = "";

    static boolean registered = false;
    static boolean regularCustomer = false;

    // =========================
    // SERVICE DATA
    // =========================
    static String selectedService = "";
    static double serviceCost = 0;

    static int jobNumber = 428;

    static String jobStatus = "BOOKED";

    static ArrayList<String> serviceHistory = new ArrayList<>();


    // =========================
    // MAIN
    // =========================
    public static void main(String[] args) {

        int choice;

        System.out.println("==========================================");
        System.out.println("          4Ds AUTO CARE SYSTEM");
        System.out.println("==========================================");
        System.out.println("Digital Automotive Service & Maintenance");
        System.out.println();

        do {

            System.out.println("\n--------------- MAIN MENU ---------------");
            System.out.println("[1] Login");
            System.out.println("[2] Sign Up");
            System.out.println("[3] Exit");
            System.out.print("Choose: ");

            choice = getInt();

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    signUp();
                    break;

                case 3:
                    System.out.println("\nThank you for using 4Ds Auto Care!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }


    // =========================
    // SIGN UP
    // =========================
    static void signUp() {

        System.out.println("\n==========================================");
        System.out.println("              CUSTOMER SIGN UP");
        System.out.println("==========================================");

        System.out.print("Enter full name: ");
        customerName = sc.nextLine();

        System.out.print("Enter contact number: ");
        contactNumber = sc.nextLine();

        System.out.println("\n--- VEHICLE INFORMATION ---");

        System.out.print("Vehicle type (Car/Motorcycle): ");
        vehicleType = sc.nextLine();

        System.out.print("Vehicle model/name: ");
        vehicleName = sc.nextLine();

        System.out.print("Plate number: ");
        vehiclePlate = sc.nextLine();

        registered = true;

        System.out.println("\nAccount successfully created!");
        System.out.println("Welcome to 4Ds Auto Care, " + customerName + "!");

        customerMenu();
    }


    // =========================
    // LOGIN
    // =========================
    static void login() {

        System.out.println("\n==========================================");
        System.out.println("                 LOGIN");
        System.out.println("==========================================");

        if (!registered) {

            System.out.println("No customer account found.");
            System.out.println("Please sign up first.");

            return;
        }

        System.out.print("Enter customer name: ");
        String loginName = sc.nextLine();

        if (loginName.equalsIgnoreCase(customerName)) {

            System.out.println("\nLogin successful!");
            System.out.println("Welcome back, " + customerName + "!");

            customerMenu();

        } else {

            System.out.println("Customer not found.");
        }
    }


    // =========================
    // CUSTOMER MENU
    // =========================
    static void customerMenu() {

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("             CUSTOMER PANEL");
            System.out.println("==========================================");

            System.out.println("[1] Digital Passport");
            System.out.println("[2] Book a Service");
            System.out.println("[3] Service Order Ticket");
            System.out.println("[4] Job Tracker");
            System.out.println("[5] Service History");
            System.out.println("[6] View 4Ds Services");
            System.out.println("[7] Logout");

            System.out.print("Choose: ");

            choice = getInt();

            switch (choice) {

                case 1:
                    digitalPassport();
                    break;

                case 2:
                    bookService();
                    break;

                case 3:
                    serviceOrderTicket();
                    break;

                case 4:
                    jobTracker();
                    break;

                case 5:
                    showServiceHistory();
                    break;

                case 6:
                    showServices();
                    break;

                case 7:
                    System.out.println("\nLogging out...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }


    // =========================
    // 4Ds SERVICES
    // =========================
    static void showServices() {

        System.out.println("\n==========================================");
        System.out.println("             4Ds AUTO CARE");
        System.out.println("                SERVICES");
        System.out.println("==========================================");

        System.out.println("D - DEEP CLEAN");
        System.out.println("    Interior & exterior vehicle cleaning");
        System.out.println("    Starting Price: PHP 500");

        System.out.println();

        System.out.println("I - INSPECTION");
        System.out.println("    Complete vehicle condition inspection");
        System.out.println("    Starting Price: PHP 300");

        System.out.println();

        System.out.println("A - AUTO MAINTENANCE");
        System.out.println("    Oil change, brake check and basic maintenance");
        System.out.println("    Starting Price: PHP 1,000");

        System.out.println();

        System.out.println("G - GENERAL REPAIR");
        System.out.println("    Repair and replacement of vehicle components");
        System.out.println("    Starting Price: PHP 1,500");

        System.out.println();

        System.out.println("4Ds Auto Care provides a complete");
        System.out.println("vehicle care experience from inspection");
        System.out.println("to maintenance, repair and detailing.");
    }


    // =========================
    // DIGITAL PASSPORT
    // =========================
    static void digitalPassport() {

        System.out.println("\n==========================================");
        System.out.println("             DIGITAL PASSPORT");
        System.out.println("==========================================");

        System.out.println("Customer Name : " + customerName);
        System.out.println("Contact       : " + contactNumber);
        System.out.println("------------------------------------------");
        System.out.println("Vehicle Type  : " + vehicleType);
        System.out.println("Vehicle Model : " + vehicleName);
        System.out.println("Plate Number  : " + vehiclePlate);
        System.out.println("------------------------------------------");

        if (regularCustomer) {
            System.out.println("Customer Type: REGULAR CUSTOMER");
            System.out.println("Promo: 10% SERVICE DISCOUNT");
        } else {
            System.out.println("Customer Type: NEW CUSTOMER");
        }

        System.out.println("------------------------------------------");

        if (serviceHistory.isEmpty()) {

            System.out.println("Service Records: No service records yet.");

        } else {

            System.out.println("Service Records:");

            for (String record : serviceHistory) {
                System.out.println("- " + record);
            }
        }

        System.out.println("------------------------------------------");
        System.out.println("Your Digital Passport stores your");
        System.out.println("vehicle's service and maintenance history.");
    }


    // =========================
    // BOOK SERVICE
    // =========================
    static void bookService() {

        System.out.println("\n==========================================");
        System.out.println("               BOOK SERVICE");
        System.out.println("==========================================");

        System.out.println("[1] Deep Clean       - PHP 500");
        System.out.println("[2] Inspection       - PHP 300");
        System.out.println("[3] Auto Maintenance - PHP 1,000");
        System.out.println("[4] General Repair   - PHP 1,500");

        System.out.print("\nChoose service: ");

        int choice = getInt();

        switch (choice) {

            case 1:
                selectedService = "Deep Clean";
                serviceCost = 500;
                break;

            case 2:
                selectedService = "Inspection";
                serviceCost = 300;
                break;

            case 3:
                selectedService = "Auto Maintenance";
                serviceCost = 1000;
                break;

            case 4:
                selectedService = "General Repair";
                serviceCost = 1500;
                break;

            default:
                System.out.println("Invalid service.");
                return;
        }

        System.out.println("\nService selected: " + selectedService);

        System.out.print("Confirm booking? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {

            jobStatus = "BOOKED";

            System.out.println("\n==========================================");
            System.out.println("             BOOKING CONFIRMED");
            System.out.println("==========================================");

            System.out.println("Job Number: JOB #" + jobNumber);
            System.out.println("Vehicle: " + vehicleName);
            System.out.println("Service: " + selectedService);
            System.out.println("Status: " + jobStatus);

            System.out.println("\nYour service order has been created.");

        } else {

            System.out.println("Booking cancelled.");
        }
    }


    // =========================
    // SERVICE ORDER TICKET
    // =========================
    static void serviceOrderTicket() {

        System.out.println("\n==========================================");
        System.out.println("          SERVICE ORDER TICKET");
        System.out.println("==========================================");

        if (selectedService.isEmpty()) {

            System.out.println("No service order found.");
            System.out.println("Please book a service first.");

            return;
        }

        System.out.println("JOB NUMBER   : JOB #" + jobNumber);
        System.out.println("CUSTOMER     : " + customerName);
        System.out.println("VEHICLE      : " + vehicleName);
        System.out.println("PLATE NUMBER : " + vehiclePlate);
        System.out.println("------------------------------------------");
        System.out.println("SERVICE      : " + selectedService);
        System.out.println("TECHNICIAN   : 4Ds Service Team");
        System.out.println("STATUS       : " + jobStatus);
        System.out.println("EST. COST    : PHP " + serviceCost);
        System.out.println("------------------------------------------");

        System.out.println("This ticket follows your vehicle");
        System.out.println("throughout the service process.");
    }


    // =========================
    // JOB TRACKER
    // =========================
    static void jobTracker() {

        if (selectedService.isEmpty()) {

            System.out.println("\nNo active service job.");
            System.out.println("Please book a service first.");

            return;
        }

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("               JOB TRACKER");
            System.out.println("==========================================");

            System.out.println("JOB #" + jobNumber);
            System.out.println("Vehicle: " + vehicleName);
            System.out.println("Service: " + selectedService);

            System.out.println("\nCURRENT STATUS:");
            System.out.println(">>> " + jobStatus);

            System.out.println("\nSERVICE FLOW:");
            System.out.println("[1] BOOKED");
            System.out.println("[2] RECEIVED");
            System.out.println("[3] INSPECTION");
            System.out.println("[4] WAITING FOR APPROVAL");
            System.out.println("[5] REPAIRING");
            System.out.println("[6] QUALITY CHECK");
            System.out.println("[7] READY FOR PICKUP");
            System.out.println("[8] COMPLETED");
            System.out.println("[9] Return");

            System.out.print("\nUpdate status: ");

            choice = getInt();

            switch (choice) {

                case 1:
                    jobStatus = "BOOKED";
                    break;

                case 2:
                    jobStatus = "RECEIVED";
                    break;

                case 3:
                    jobStatus = "INSPECTION";
                    break;

                case 4:
                    jobStatus = "WAITING FOR APPROVAL";
                    break;

                case 5:
                    jobStatus = "REPAIRING";
                    break;

                case 6:
                    jobStatus = "QUALITY CHECK";
                    break;

                case 7:
                    jobStatus = "READY FOR PICKUP";
                    break;

                case 8:
                    jobStatus = "COMPLETED";

                    payment();

                    break;

                case 9:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            if (choice >= 1 && choice <= 8) {

                System.out.println("\nJob status updated!");
                System.out.println("Current Status: " + jobStatus);
            }

        } while (choice != 9);
    }


    // =========================
    // PAYMENT
    // =========================
    static void payment() {

        double originalCost = serviceCost;
        double discount = 0;
        double finalCost;

        System.out.println("\n==========================================");
        System.out.println("                 PAYMENT");
        System.out.println("==========================================");

        System.out.println("Customer: " + customerName);
        System.out.println("Service : " + selectedService);

        System.out.println("------------------------------------------");

        System.out.printf("Original Cost : PHP %.2f%n", originalCost);

        if (regularCustomer) {

            discount = originalCost * 0.10;

            System.out.printf("10%% Discount  : PHP %.2f%n", discount);

        } else {

            System.out.println("Discount      : PHP 0.00");
        }

        finalCost = originalCost - discount;

        System.out.printf("Final Amount  : PHP %.2f%n", finalCost);

        System.out.println("------------------------------------------");

        System.out.print("Confirm payment? (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {

            System.out.println("\nPayment successful!");

            String record =
                    selectedService +
                            " - PHP " +
                            String.format("%.2f", finalCost) +
                            " - COMPLETED";

            serviceHistory.add(record);

            regularCustomer = true;

            System.out.println("Service has been added to your");
            System.out.println("Digital Passport.");

        } else {

            System.out.println("Payment cancelled.");
        }
    }


    // =========================
    // SERVICE HISTORY
    // =========================
    static void showServiceHistory() {

        System.out.println("\n==========================================");
        System.out.println("             SERVICE HISTORY");
        System.out.println("==========================================");

        if (serviceHistory.isEmpty()) {

            System.out.println("No previous service records.");

            return;
        }

        for (int i = 0; i < serviceHistory.size(); i++) {

            System.out.println(
                    (i + 1) + ". " +
                            serviceHistory.get(i)
            );
        }

        System.out.println("------------------------------------------");
        System.out.println("Records are automatically connected");
        System.out.println("to the vehicle's Digital Passport.");
    }


    // =========================
    // INTEGER INPUT
    // =========================
    static int getInt() {

        while (!sc.hasNextInt()) {

            System.out.println("Please enter a number.");
            sc.next();

        }

        int number = sc.nextInt();
        sc.nextLine();

        return number;
    }
}