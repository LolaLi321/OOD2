package pattern;

// 1. 用interface 还是 abstract class? 是为了包含字段和默认实现吗，比如abstract class Food？
// 我的理解是：（老师还有其他理解吗？）
// 对于 Food：使用 abstract class 因为需要共享字段(name, price)和实现(getter/setter)
// 对于 FoodFactory：使用 interface 更合适，因为它只定义行为（createFood方法），不需要共享任何状态或实现
// 2. 为何有时候抽象类，不需要写构造函数？比如Food里面
// 3. FoodFactory beverageFactory = new BeverageFactory();左边到底写BurgerFactory不可以吗？
public class FoodFactory3327 {
    public static void main(String[] args) {
        FoodFactory burgerFactory = new BurgerFactory();
        // FoodFactory snackFactory = new SnackFactory();
        FoodFactory beverageFactory = new BeverageFactory();

        Food CheeseBurger = burgerFactory.createFood("cheese");
        Food coke = beverageFactory.createFood("coke");
    }
}

interface FoodFactory {
    Food createFood(String type);

}

class BurgerFactory implements FoodFactory {
    @Override
    public Food createFood(String type) {
        if (type.equals("cheese")) {
            System.out.println("Burger factory is creating a  cheese burger...");
            return new CheeseBurger();
        }
        return null;
    }
}

// class SnackFactory implements FoodFactory {

// }

class BeverageFactory implements FoodFactory {
    @Override
    public Food createFood(String type) {
        if (type.equals("coke")) {
            System.out.println("Beverage factory is creating a coke...");
            return new Coke();
        }
        return null;
    }
}

abstract class Food {
    protected String name;
    protected double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { // 改为double类型
        this.price = price;
    }
}

// 让三个分类都继承Food，避免重复代码
abstract class Burger extends Food {
}

abstract class Snack extends Food {
}

abstract class Beverage extends Food {
}

// 具体产品（先只写两个）
class CheeseBurger extends Burger {
    public CheeseBurger() {
        this.name = "cheese burger";
        this.price = 10.0;
    }
}

class Coke extends Beverage {
    public Coke() {
        this.name = "coke";
        this.price = 4.0;
    }
}
