package Rectangle;
import Shape.Shape;

public class Rectangle implements Shape {
    private double width, height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void displayInfo() {
        System.out.println("Прямоугольник -> Периметр: " + calculatePerimeter() +
                ", Площадь: " + calculateArea() +
                ", Цвет заливки: " + fillColor +
                ", Цвет границы: " + borderColor);
    }
}
