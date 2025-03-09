package Triangle;
import Shape.Shape;
public class Triangle implements Shape {
    private final double a;
    private final double b;
    private final double c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public void displayInfo() {
        System.out.println("Треугольник -> Периметр: " + calculatePerimeter() +
                ", Площадь: " + calculateArea() +
                ", Цвет заливки: " + fillColor +
                ", Цвет границы: " + borderColor);
    }
}
