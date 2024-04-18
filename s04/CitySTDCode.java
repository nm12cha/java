import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CitySTDCode {
    private static Map<String, String> cityCodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new city and its STD code");
            System.out.println("2. Remove a city from the collection");
            System.out.println("3. Search for a city name and display the code");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addCity(scanner);
                    break;
                case 2:
                    removeCity(scanner);
                    break;
                case 3:
                    searchCity(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addCity(Scanner scanner) {
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();
        System.out.print("Enter STD code: ");
        String stdCode = scanner.nextLine();

        if (!cityCodes.containsKey(cityName)) {
            cityCodes.put(cityName, stdCode);
            System.out.println("City added successfully!");
        } else {
            System.out.println("City already exists. Cannot add duplicate city.");
        }
    }

    private static void removeCity(Scanner scanner) {
        System.out.print("Enter city name to remove: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            cityCodes.remove(cityName);
            System.out.println("City removed successfully!");
        } else {
            System.out.println("City not found. Cannot remove.");
        }
    }

    private static void searchCity(Scanner scanner) {
        System.out.print("Enter city name to search: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            String stdCode = cityCodes.get(cityName);
            System.out.println("STD code for " + cityName + ": " + stdCode);
        } else {
            System.out.println("City not found.");
        }
    }
}

