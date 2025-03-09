package Shape;

public interface Shape {
    double calculateArea();

    default double calculatePerimeter() {
        return 0.0;
    }

    void displayInfo();
}

