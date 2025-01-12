package pattern;

// 1. 为何题目有的地方倾向于用Integer r; 而不是int r；我知道2者有区别但是不知道什么时候应该用Integer
// 2. 我修改了main里面输入文件的方式（使用input.txt），如果用原来题目给的main的方式（String inputPath = args[0];），要怎么做？
// 3. IPackage apple = fruitFactory.packFruits("apple"); 不明白为何等号左边可以是借口？
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ShapeFactory3344 {
    public static void main(String[] args) {

        try {
            // String inputPath = args[0];
            String inputPath = "input.txt";
            Scanner sc = new Scanner(new FileReader(inputPath));

            String shape = sc.nextLine();
            Integer[] params = new Integer[2];
            params[0] = sc.nextInt();
            if (sc.hasNextInt()) {
                params[1] = sc.nextInt();
            }
            ShapeFactory sf = new ShapeFactory();
            Shape s = sf.setShape(shape, params);
            System.out.println("Shape is: " + s.shapeType() + ".");
            System.out.println("Area is: " + s.shapeArea() + ".");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class ShapeFactory {

    public Shape setShape(String type, Integer[] params) {
        if (type.equals("Round")) {
            return new Round(params[0]);
        } else if (type.equals("Square")) {
            return new Square(params[0]);
        } else if (type.equals("Rectangle")) {
            return new Rectangle(params[0], params[1]);
        } else if (type.equals("Triangle")) {
            return new Triangle(params[0], params[1]);
        } else {
            return null;
        }

    }

}

interface Shape {
    int shapeArea();

    String shapeType();
}

class Round implements Shape {
    private static final int PI = 3;
    private int r;

    public Round(int r) {
        this.r = r;
    }

    @Override
    public int shapeArea() {
        return PI * r * r;
    }

    @Override
    public String shapeType() {
        return "Round";
    }

}

class Square implements Shape {
    private int width;

    public Square(int width) {
        this.width = width;
    }

    @Override
    public int shapeArea() {
        return width * width;

    }

    @Override
    public String shapeType() {
        return "Square";

    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int shapeArea() {
        return width * height;
    }

    @Override
    public String shapeType() {
        return "Rectangle";

    }
}

class Triangle implements Shape {
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public int shapeArea() {
        return (int) (base * height * 0.5);

    }

    @Override
    public String shapeType() {
        return "Triangle";
    }
}
