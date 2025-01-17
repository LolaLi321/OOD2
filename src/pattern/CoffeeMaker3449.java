// import java.util.Scanner;
package pattern;

public class CoffeeMaker3449 {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);

        // // Get coffee inputs
        // System.out.println("Enter number of milk portions:");
        // int milk = scanner.nextInt();
        // System.out.println("Enter number of sugar portions:");
        // int sugar = scanner.nextInt();
        // scanner.nextLine(); // consume newline

        int milk = 2;
        int sugar = 3;

        // Make coffee
        CaffeineBase coffeePack = new CoffeePack(Caffeine.Full_Caff, milk, sugar);
        CaffeineBeverageMaker coffeeMaker = new CoffeeMakerImpl();
        coffeeMaker.serveBeverage(coffeePack);

        System.out.println("--------------------");

        // Get tea inputs
        System.out.println("Enter tea type (e.g. Pu'er Tea):");
        String base = "Pu'er Tea";
        // String base = scanner.nextLine();
        System.out.println("Add cream? (true/false):");
        // boolean cream = scanner.nextBoolean();
        boolean cream = true;

        // Make tea
        CaffeineBase teaBag = new TeaBag(Caffeine.Half_Caff, base, cream);
        CaffeineBeverageMaker teaMaker = new TeaMakerImpl();
        teaMaker.serveBeverage(teaBag);

        // scanner.close();
    }
}

// Caffeine enum
enum Caffeine {
    Full_Caff,
    Half_Caff,
    De_Caff
}

// Base class for beverages
abstract class CaffeineBeverage {
    protected String base;
    protected Caffeine caffeine;
    protected double cost;

    protected CaffeineBeverage(String base) {
        this.base = base;
    }

    public abstract String getIngredients();

    public abstract double getCost();

    public void setCaffeine(Caffeine caffeine) {
        this.caffeine = caffeine;
    }

    public Caffeine getCaffeine() {
        return caffeine;
    }
}

// Simple beverage implementations
class SimpleCoffee extends CaffeineBeverage {
    public SimpleCoffee(String base) {
        super(base);
    }

    @Override
    public String getIngredients() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 5;
    }
}

class SimpleTea extends CaffeineBeverage {
    public SimpleTea(String base) {
        super(base);
    }

    @Override
    public String getIngredients() {
        return base;
    }

    @Override
    public double getCost() {
        return 3;
    }
}

// Decorator base class
// 装饰器模式
abstract class BeverageDecorator extends CaffeineBeverage {
    private final CaffeineBeverage decoratedBeverage; //

    protected BeverageDecorator(String base, CaffeineBeverage decoratedBeverage) { // // 持有被装饰的饮料
        super(base);
        this.decoratedBeverage = decoratedBeverage;
    }

    @Override
    public String getIngredients() {
        return decoratedBeverage.getIngredients();
    }

    @Override
    public double getCost() {
        return decoratedBeverage.getCost();
    }
}

// Concrete decorators
class WithCream extends BeverageDecorator {
    public WithCream(String base, CaffeineBeverage decoratedBeverage) {
        super(base, decoratedBeverage);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Covered Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.5;
    }
}

class WithMilk extends BeverageDecorator {
    public WithMilk(String base, CaffeineBeverage decoratedBeverage) {
        super(base, decoratedBeverage);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class WithSugar extends BeverageDecorator {
    public WithSugar(String base, CaffeineBeverage decoratedBeverage) {
        super(base, decoratedBeverage);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}

// Base class for beverage makers
// 模板方法模式 - 定义了做一个饮料的步骤
abstract class CaffeineBeverageMaker {
    protected void boilWater() {
        System.out.println("Boil Water.");
    }

    protected abstract CaffeineBeverage brew(CaffeineBase base); // 具体方法是可以由子类具体定义的

    protected abstract void pourIntoCup(CaffeineBeverage beverage); // 具体方法是可以由子类具体定义的

    public final void serveBeverage(CaffeineBase base) { // final说明方法不可改，顺序固定，但是里面引用的具体方法是可以由子类具体定义的
        boilWater(); // step1
        CaffeineBeverage beverage = brew(base); // step2
        pourIntoCup(beverage); // step3
    }
}

// Base class for beverage ingredients
abstract class CaffeineBase {
    protected Caffeine caffeine;

    protected CaffeineBase(Caffeine caffeine) {
        this.caffeine = caffeine;
    }

    public Caffeine getCaffeine() {
        return caffeine;
    }
}

// Concrete ingredient classes
class CoffeePack extends CaffeineBase {
    private int needMilk;
    private int needSugar;

    public CoffeePack(Caffeine caffeine, int milk, int sugar) {
        super(caffeine);
        this.needMilk = milk;
        this.needSugar = sugar;
    }

    public int getNeedMilk() {
        return needMilk;
    }

    public int getNeedSugar() {
        return needSugar;
    }
}

class TeaBag extends CaffeineBase {
    private String base;
    private boolean needCream;

    public TeaBag(Caffeine caffeine, String base, boolean cream) {
        super(caffeine);
        this.base = base;
        this.needCream = cream;
    }

    public String getBase() {
        return base;
    }

    public boolean isNeedCream() {
        return needCream;
    }
}

// Concrete maker implementations
class CoffeeMakerImpl extends CaffeineBeverageMaker {
    @Override
    protected CaffeineBeverage brew(CaffeineBase base) {
        CoffeePack pack = (CoffeePack) base;

        CaffeineBeverage beverage = new SimpleCoffee("Coffee");
        beverage.setCaffeine(pack.getCaffeine());

        for (int i = 0; i < pack.getNeedMilk(); i++) {
            beverage = new WithMilk("Coffee", beverage);
        }

        for (int i = 0; i < pack.getNeedSugar(); i++) {
            beverage = new WithSugar("Coffee", beverage);
        }

        return beverage;
    }

    @Override
    protected void pourIntoCup(CaffeineBeverage beverage) {
        System.out.println("Serve " + beverage.getCaffeine() + " Coffee:");
        System.out.println("Cost for this coffee is: " + beverage.getCost());
        System.out.println("Ingredients for this coffee is: " + beverage.getIngredients());
    }
}

class TeaMakerImpl extends CaffeineBeverageMaker {
    @Override
    protected CaffeineBeverage brew(CaffeineBase base) {
        TeaBag teaBag = (TeaBag) base;

        CaffeineBeverage beverage = new SimpleTea(teaBag.getBase());
        beverage.setCaffeine(teaBag.getCaffeine());

        if (teaBag.isNeedCream()) {
            beverage = new WithCream(teaBag.getBase(), beverage);
        }

        return beverage;
    }

    @Override
    protected void pourIntoCup(CaffeineBeverage beverage) {
        System.out.println("Serve " + beverage.getCaffeine() + " Tea:");
        System.out.println("Cost for this tea is: " + beverage.getCost());
        System.out.println("Ingredients for this tea is: " + beverage.getIngredients());
    }
}