// lintcode 3436

public class Poker3436 {
    // main method -  程序的入口
    public static void main(String[] args) {
        Hand left = new Hand("Spades", "K");
        Hand right = new Hand("Hearts", "A");

        Person person = new Person(left, right);

        System.out.println(person.leftHand.color + "," + person.leftHand.number + " " + person.rightHand.color + "," + person.rightHand.number);
        person.swapHands();
        System.out.println(person.leftHand.color + "," + person.leftHand.number + " " + person.rightHand.color + "," + person.rightHand.number);
    }
}

class Hand {
    String color;
    String number;

    public Hand(String color, String number) {
        this.color = color;
        this.number = number;
    }
}

class Person {
    Hand leftHand;
    Hand rightHand;

    public Person(Hand left, Hand right) {
        leftHand = left;
        rightHand = right;
    }

    public void swapHands() {
        Hand temp = leftHand;
        leftHand = rightHand;
        rightHand = temp;
    }
}

