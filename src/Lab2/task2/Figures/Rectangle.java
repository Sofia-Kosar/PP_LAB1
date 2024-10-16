package Lab2.task2.Figures;
import Lab2.task2.AreaCalculable;

public class Rectangle implements AreaCalculable {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}