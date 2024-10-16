package Lab2.task1;
import java.util.Scanner;

public class Work {
    public static void main(String[] args) {
        final GraphMethods graph = new GraphMethods();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Choose the input type:");
            System.out.println("1. Predefined values");
            System.out.println("2. User input");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Очистка некоректного вводу
            }

            if (choice == 1) {
                graph.addTop("A", 1);
                graph.addTop("B", 2);
                graph.addTop("C", 3);

                graph.addEdge("A", "B", true);
                graph.addEdge("B", "C", false);

                graph.displayGraph();
            } else if (choice == 2) {
                // Введення користувача
                graph.displayGraphFromUserInput();
            } else {
                System.out.println("Invalid option!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Закриття сканера
        }
    }
}
