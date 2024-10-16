package Lab2.Task2;

import java.util.Scanner;
import Lab2.Task2.Figures.Circle;
import Lab2.Task2.Figures.Cube;
import Lab2.Task2.Figures.Pyramid;
import Lab2.Task2.Figures.Sphere;
import Lab2.Task2.Figures.Rectangle;
import Lab2.Task2.Figures.Square;
import Lab2.Task2.Figures.Triangle;

public class Work {
    private final Scanner scanner = new Scanner(System.in);

    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Work work = new Work();

        System.out.println("Choose input method:");
        System.out.println("1. Predefined values");
        System.out.println("2. User input");

        final int choice = work.getIntInput("");

        if (choice == 1) {
            // Using predefined values
            Triangle triangle = new Triangle(10, 5);
            Cube cube = new Cube(4);
            Circle circle = new Circle(3);

            System.out.println("Triangle area: " + triangle.calculateArea());
            System.out.println("Cube area: " + cube.calculateArea());
            System.out.println("Cube capacity: " + cube.calculateCapacity());
            System.out.println("Circle area: " + circle.calculateArea());
        } else if (choice == 2) {
            System.out.println("Choose a figure:");
            System.out.println("1. Triangle");
            System.out.println("2. Cube");
            System.out.println("3. Circle");
            System.out.println("4. Square");
            System.out.println("5. Rectangle");
            System.out.println("6. Pyramid");
            System.out.println("7. Sphere");

            final int figureChoice = work.getIntInput("Select a figure (1-7): ");

            switch (figureChoice) {
                case 1: // Triangle
                    final double base = work.getDoubleInput("Enter base of the triangle: ");
                    final double height = work.getDoubleInput("Enter height of the triangle: ");
                    Triangle triangle = new Triangle(base, height);
                    System.out.println("Triangle area: " + triangle.calculateArea());
                    break;

                case 2: // Cube
                    final double sideCube = work.getDoubleInput("Enter side of the cube: ");
                    Cube cube = new Cube(sideCube);
                    System.out.println("Cube area: " + cube.calculateArea());
                    System.out.println("Cube capacity: " + cube.calculateCapacity());
                    break;

                case 3: // Circle
                    final double radius = work.getDoubleInput("Enter radius of the circle: ");
                    Circle circle = new Circle(radius);
                    System.out.println("Circle area: " + circle.calculateArea());
                    break;

                case 4: // Square
                    final double sideSquare = work.getDoubleInput("Enter side of the square: ");
                    Square square = new Square(sideSquare);
                    System.out.println("Square area: " + square.calculateArea());
                    break;

                case 5: // Rectangle
                    final double length = work.getDoubleInput("Enter length of the rectangle: ");
                    final double width = work.getDoubleInput("Enter width of the rectangle: ");
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.println("Rectangle area: " + rectangle.calculateArea());
                    break;

                case 6: // Pyramid
                    final double basePyramid = work.getDoubleInput("Enter base area of the pyramid: ");
                    final double heightPyramid = work.getDoubleInput("Enter height of the pyramid: ");
                    Pyramid pyramid = new Pyramid(basePyramid, heightPyramid);
                    System.out.println("Pyramid area: " + pyramid.calculateArea());
                    System.out.println("Pyramid capacity: " + pyramid.calculateCapacity());
                    break;

                case 7: // Sphere
                    final double radiusSphere = work.getDoubleInput("Enter radius of the sphere: ");
                    Sphere sphere = new Sphere(radiusSphere);
                    System.out.println("Sphere area: " + sphere.calculateArea());
                    System.out.println("Sphere capacity: " + sphere.calculateCapacity());
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid figure.");
                    break;
            }
        } else {
            System.out.println("Invalid choice.");
        }

        work.scanner.close();
    }
}
