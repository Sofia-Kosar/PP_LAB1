package Lab2.task2.Figures;
import Lab2.task2.AreaCalculable;
import Lab2.task2.CapacityCalculable;

public class Cube implements AreaCalculable, CapacityCalculable {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return 6 * side * side;
    }

    @Override
    public double calculateCapacity() {
        return side * side * side;
    }
}