// 多态不是很熟悉
public class Instrument3437 {
    public static void main(String[] args) {
        // Piano piano = new Piano();
        // Violin violin = new Violin();
        // Erhu erhu = new Erhu();
        // piano.makeSound();
        // violin.makeSound();
        // erhu.makeSound();

        // 体现多态 - 这里的多态是指父类的引用指向子类的对象
        Instrument instrument1 = new Piano();
        Instrument instrument2 = new Violin();
        Instrument instrument3 = new Erhu();

        instrument1.makeSound();
        instrument2.makeSound();
        instrument3.makeSound();

        // Instruments[] instruments = {piano, volin, erhu};
        // for (instrument : instruments) {
        //     instrument.makeSound();
        // } // ？？

    }
    
}

class Instrument {
    // public Instrument() {
    // }

    public void makeSound() {
        System.out.println("Instrument is making good sound!");
    }
}

class Piano extends Instrument {
    public Piano() { // 这个构造函数可以不写
    }

    @Override
    public void makeSound() {
        System.out.println("Piano is pleasing to the ear");
    }
}

class Violin extends Instrument {
    public Violin() {
    }
    @Override
    public void makeSound() {
        System.out.println("Violin is Shocking");
    }
}

class Erhu extends Instrument {
    public Erhu() {
    }
    @Override
    public void makeSound() {
        System.out.println("Erhu is Good to hear");
    }
}
