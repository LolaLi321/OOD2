//  1. 接口里的方法不用public吗？
// 2. 这里也是多态？

public class DrinkSolution3332 {
    public static void main(String[] args) {
        PersonWhoDrink p = new PersonWhoDrink("Tom");
        Drinks water = new Water();
        Drinks milk = new Milk();
        p.drink(water);
        p.drink(milk);
    }

}

interface Drinks {
    // public void taste();
    String drinkFeeling();

    String getName();
}

class Water implements Drinks {
    @Override
    public String drinkFeeling() {
        return "nothing special";
    }

    @Override
    public String getName() {
        return "water";
    }
}

class Milk implements Drinks {
    @Override
    public String drinkFeeling() {
        return "very sweet";
    }

    @Override
    public String getName() {
        return "milk";
    }
}

class PersonWhoDrink {
    private String name;

    public PersonWhoDrink(String name) {
        this.name = name;
    }

    public void drink(Drinks drink) {
        System.out.println(name + " is drinking " + drink.getName());
        System.out.println(name + " feels " + drink.drinkFeeling());
    }

}