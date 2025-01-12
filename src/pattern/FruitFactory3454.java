package pattern;
// 1. public static IPackage packFruits(String fruit) { 

// 2. 工厂方法？

public class FruitFactory3454 {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        IPackage apple = fruitFactory.packFruits("apple");
        apple.pack();
        IPackage banana = fruitFactory.packFruits("banana");
        banana.pack();

        // non-exist fruit
        fruitFactory.packFruits("orange");
    }

}

class FruitFactory {
    // 方法不一定要是静态方法，这是一种设计选择。静态方法可以直接通过类名调用，比如FruitFactory.packFruits("apple")
    public static IPackage packFruits(String fruit) {
        if (fruit.equals("apple")) {
            return new Apple();
        } else if (fruit.equals("banana")) {
            return new Banana();
        } else {
            System.out.println("No such fruit");
            return null;
        }
    }
}

interface IPackage {
    void pack();
}

class Apple implements IPackage {
    @Override
    public void pack() {
        System.out.println("Packaging apple");
    }
}

class Banana implements IPackage {
    @Override
    public void pack() {
        System.out.println("Packaging banana");
    }
}