package Lab2.Task3;
import java.util.Scanner;

public class Work {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an action: 1 - Load test data, 2 - Enter your own data");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> loadTestData();
                case 2 -> loadUserData(scanner);
                default -> System.err.println("Invalid option.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected issue occurred: " + e.getMessage());
        }
    }

    private static void loadUserData(Scanner scanner) {
        Warehouse warehouse = new Warehouse();

        System.out.println("Enter the number of cells:");
        int cellCount = scanner.nextInt();
        if (cellCount <= 0) {
            throw new IllegalArgumentException("Number of cells must be positive.");
        }

        for (int i = 0; i < cellCount; i++) {
            System.out.println("Enter the length of cell " + (i + 1) + ":");
            double length = scanner.nextDouble();
            System.out.println("Enter the width of cell " + (i + 1) + ":");
            double width = scanner.nextDouble();
            System.out.println("Enter the height of cell " + (i + 1) + ":");
            double height = scanner.nextDouble();

            Cell cell = new Cell(length, width, height);
            warehouse.addCell(cell);

            System.out.println("Enter the number of goods for cell " + (i + 1) + ":");
            int goodCount = scanner.nextInt();
            if (goodCount <= 0) {
                throw new IllegalArgumentException("Number of goods must be positive.");
            }

            for (int j = 0; j < goodCount; j++) {
                System.out.println("Enter the length of good " + (j + 1) + ":");
                double goodLength = scanner.nextDouble();
                System.out.println("Enter the width of good " + (j + 1) + ":");
                double goodWidth = scanner.nextDouble();
                System.out.println("Enter the height of good " + (j + 1) + ":");
                double goodHeight = scanner.nextDouble();

                Good good = new Good(goodLength, goodWidth, goodHeight);
                try {
                    warehouse.addGoodToCell(cell, good);
                    System.out.println("Good successfully added.");
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        warehouse.printAllGoods();
    }

    private static void loadTestData() {
        final Warehouse warehouse = new Warehouse();

        // Створюємо дві комірки
        final Cell cell1 = new Cell(5, 5, 5); // Об'єм: 5*5*5 = 125
        final Cell cell2 = new Cell(10, 10, 10); // Об'єм: 10*10*10 = 1000

        // Створюємо товари
        final Good good1 = new Good(1, 1, 1); // Об'єм: 1*1*1 = 1
        final Good good2 = new Good(2, 2, 2); // Об'єм: 2*2*2 = 8
        final Good good3 = new Good(3, 3, 3); // Об'єм: 3*3*3 = 27
        final Good good4 = new Good(4, 4, 4); // Об'єм: 4*4*4 = 64

        // Додаємо комірки на склад
        warehouse.addCell(cell1);
        warehouse.addCell(cell2);

        // Додаємо товари до першої комірки
        try {
            warehouse.addGoodToCell(cell1, good1); // Успішно
            warehouse.addGoodToCell(cell1, good2); // Успішно
            warehouse.addGoodToCell(cell1, good3); // Успішно
            warehouse.addGoodToCell(cell1, good4); // Успішно

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Виводимо всю інформацію про товари на складі
        warehouse.printAllGoods();
    }

}
