package HomeWork1;

import java.util.Scanner;

public class RestaurantReservation {
    private static boolean[] tables;
    private static int numTables;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tables in the restaurant: ");
        numTables = scanner.nextInt();

        tables = new boolean[numTables];

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View available tables");
            System.out.println("2. Reserve a table");
            System.out.println("3. Release a table");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableTables();
                    break;
                case 2:
                    reserveTable(scanner);
                    break;
                case 3:
                    releaseTable(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }


    private static void displayAvailableTables() {
        System.out.println("Available tables:");
        for (int i = 0; i < numTables; i++) {
            if (!tables[i]) {
                System.out.println("Table " + (i + 1));
            }
        }
    }

    private static void reserveTable(Scanner scanner) {
        System.out.print("Enter the table number you want to reserve: ");
        int tableNumber = scanner.nextInt();

        if (tableNumber >= 1 && tableNumber <= numTables) {
            if (!tables[tableNumber - 1]) {
                tables[tableNumber - 1] = true;
                System.out.println("Table " + tableNumber + " successfully reserved.");
            } else {
                System.out.println("Table " + tableNumber + " is already reserved.");
            }
        } else {
            System.out.println("Invalid table number.");
        }
    }

    private static void releaseTable(Scanner scanner) {
        System.out.print("Enter the table number you want to release: ");
        int tableNumber = scanner.nextInt();

        if (tableNumber >= 1 && tableNumber <= numTables) {
            if (tables[tableNumber - 1]) {
                tables[tableNumber - 1] = false;
                System.out.println("Table " + tableNumber + " successfully released.");
            } else {
                System.out.println("Table " + tableNumber + " is not currently reserved.");
            }
        } else {
            System.out.println("Invalid table number.");
        }
    }
}
