package Main.Java.core_java_practice.core_java.org.example.scenario_based;

abstract class Shape {
    abstract double area();
    abstract double perimeter();
}
class Square extends Shape {
    private final double side;

    Square (double side) {
        this.side=side;
    }
    public double getSide() {
        return side;
    }
    double area() {
        return side*side;
    }
    double perimeter() {
        return 4*side;
    }
}
class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    private double a, b, c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double perimeter() {
        return a + b + c;
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(6),
                new Circle(10),
                new Rectangle(5, 10),
                new Triangle(3, 4, 5)
        };

        System.out.println("Shape Report");

        for (Shape s : shapes) {
            System.out.printf(
                    "%-16s Area: %.2f Perimeter: %.2f%n",
                    s.getClass().getSimpleName(),
                    s.area(),
                    s.perimeter()
            );
        }
    }
}