package Lab2.task1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GraphMethods {
    private final List<Top> tops;
    private final List<Edge> edges;

    public GraphMethods() {
        tops = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addTop(String name, int value) {
        for (Top top : tops) {
            if (top.getName().equals(name)) {
                System.out.println("Top with the name '" + name + "' already exists!");
                return; // Якщо така вершина вже є, не додаємо її
            }
        }
        final Top top = new Top(name, value);
        tops.add(top);
    }

    public void addEdge(String from, String to, boolean isDirected) {
        final Top topFrom = findTop(from);
        final Top topTo = findTop(to);

        if (topFrom != null && topTo != null) {
            for (Edge edge : edges) {
                if ((edge.getFrom().equals(topFrom) && edge.getTo().equals(topTo)) ||
                        (edge.getFrom().equals(topTo) && edge.getTo().equals(topFrom))) {
                    System.out.println("Edge between '" + from + "' and '" + to + "' already exists!");
                    return;
                }
            }
            final Edge edge = new Edge(topFrom, topTo, isDirected);
            edges.add(edge);
        } else {
            System.out.println("One or both tops not found!");
        }
    }

    private Top findTop(String name) {
        for (final Top top : tops) {
            if (top.getName().equals(name)) {
                return top;
            }
        }
        return null;
    }

    public void displayGraph() {
        System.out.println("Tops:");
        for (final Top top : tops) {
            System.out.println(top);
        }

        System.out.println("\nEdges:");
        for (final Edge edge : edges) {
            System.out.println(edge);
        }
    }

    public void displayGraphFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        int numberOfTops;
        // Перевірка, щоб кількість вершин була більше нуля
        do {
            System.out.println("Enter the number of tops (must be greater than 0):");
            numberOfTops = scanner.nextInt();
            if (numberOfTops <= 0) {
                System.out.println("Invalid number! The number of tops must be greater than 0.");
            }
        } while (numberOfTops <= 0);

        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfTops; i++) {
            System.out.println("Enter top name and value (e.g., Name 10):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String name = parts[0];
            int value = Integer.parseInt(parts[1]);
            addTop(name, value);
        }

        System.out.println("Enter the number of edges:");
        int numberOfEdges = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfEdges; i++) {
            System.out.println("Enter edge (e.g., From To Directed(1 or 0)):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String from = parts[0];
            String to = parts[1];
            boolean isDirected = parts[2].equals("1");
            addEdge(from, to, isDirected);
        }

        displayGraph();
    }
}