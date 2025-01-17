// 单例子模式 - 懒汉式 or 饿汉式？
// getInstance() 方法需要确保：只创建一次实例，首次创建时初始化54张牌，后续调用时返回同一个实例

package pattern;

import java.util.HashSet;
import java.util.Set;

public class Poker3153 {
    public static void main(String[] args) {
        Poker deck1 = Poker.getInstance(); // 已经给出了这个结构所以不用enum做singleton了
        Poker deck2 = Poker.getInstance();
        System.out.println(isValid(deck1) && deck1 == deck2);
    }

    public static boolean isValid(Poker poker) { // 这个方法放在Main类里是为了测试目的， 放在Main类中可以方便测试代码的调用和验证
        if (poker == null) {
            return false;
        }
        PokerCard[] cards = poker.getCards();
        if (cards.length != 54) {
            return false;
        }
        String[] strArr = new String[] {
                "000", "111", "102", "113", "104", "211", "202", "213", "204", "311", "302", "313", "304", "411", "402",
                "413", "404", "511", "502", "513", "504", "611", "602", "613", "604", "711", "702", "713", "704", "811",
                "802", "813", "804", "911", "902", "913", "904", "1011", "1002", "1013", "1004", "1111", "1102", "1113",
                "1104", "1211", "1202", "1213", "1204", "1311", "1302", "1313", "1304", "1410"
        };
        Set<String> dataSet = new HashSet<>();
        for (String str : strArr) {
            dataSet.add(str);
        }
        for (PokerCard card : cards) {
            String s = card.toString();
            if (!dataSet.contains(s)) {
                return false;
            }
            dataSet.remove(s);
        }
        return dataSet.size() == 0;
    }
}

class Poker {
    // 1. 定义单例需要的 静态变量 和 私有构造函数
    private static Poker instance;
    private PokerCard[] cards;

    private Poker() {
    }

    private Poker(PokerCard[] cards) {
        this.cards = cards;
    }

    // 实现getInstanc（）的方法，确保是单例模式
    static Poker getInstance() { // 没有访问修饰符的时候，package-private
        // write your code here
        if (instance == null) {
            instance = new Poker(initCards()); // 不是callback，叫做“方法调用的返回值作为参数”
        }
        return instance;
    }

    // 实现获取卡片数组的方法
    public static PokerCard[] initCards() { // 因为被静态方法getInstance（）调用所以要用static
        PokerCard[] cards = new PokerCard[54];
        int index = 0;

        // create king and queen
        cards[index++] = new PokerCard(0, 0, 0);
        cards[index++] = new PokerCard(14, 1, 0);

        // create another 52 cards
        for (int val = 1; val <= 13; val++) {
            for (int type = 1; type <= 4; type++) {
                int color = (type == 1 || type == 3) ? 1 : 0;
                cards[index++] = new PokerCard(val, color, type);
            }
        }
        return cards;
    }

    public PokerCard[] getCards() {
        return this.cards;
    }

}

class PokerCard {
    private int cardVal;
    private int cardColor;
    private int cardType;

    public PokerCard(int cardVal, int cardColor, int cardType) {
        this.cardVal = cardVal;
        this.cardColor = cardColor;
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return String.format("%d%d%d", this.cardVal, this.cardColor, this.cardType);
    }
}
