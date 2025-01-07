// private double centrePosition; // (x,y)不知道怎么表示？

class Circle {
    private double centrePosition; // (x,y)不知道怎么表示？
    private int r;
    private String color;

    public Circle(double centrePosition, int r, String color) {
        this.centrePosition = centrePosition;
        this.r = r;
        this.color = color;
    }

    public double getCentrePosition() {
        return centrePosition;
    }

    public int getRadius() {
        return r;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return (int)(2 * Math.PI * r);
    }

    public int getArea() {
        return (int)(Math.PI * r * r);
    }
}

public class CircleDesign3267 {
    public static void main(String[] args) {
        Circle circle = new Circle(1, 3, "red");
        System.out.println("Circle's center position: " + circle.getCentrePosition());
        System.out.println("Circle's radius: " + circle.getRadius());
        System.out.println("Circle's perimeter: " + circle.getPerimeter());
        System.out.println("Circle's area: " + circle.getArea());
    }
}
