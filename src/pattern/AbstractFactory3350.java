package pattern;

// 1. 不知道如何处理scanner的输入？ 必须comment掉然后硬编码"coconut", 3进行test
// 2. 这道题看了参考才写出来，自己没有思路，没法自发写出来
// line55的 abstract Sugar setSugar(int sugar);这里的abstract可否省略？ 不可省略 // 通过abstract强制子类实现这些方法
import java.io.FileReader;
import java.util.Scanner;

public class AbstractFactory3350 {
    public static void main(String[] args) {
        try {
            // String inputPath = args[0];

            // String m = "";
            // int s = 0;
            // Scanner sc = new Scanner(new FileReader(inputPath));
            // if (sc.hasNextLine()) {
            // m = sc.nextLine();
            // }
            // if (sc.hasNextInt()) {
            // s = sc.nextInt();
            // }

            AbstractFactory materialFactory = Solution.setFactory("MaterialFactory");
            AbstractFactory sugarFactory = Solution.setFactory("SugarFactory");
            assert materialFactory != null;
            Material material = materialFactory.setMaterial("coconut"); // m
            assert sugarFactory != null;
            Sugar sugar = sugarFactory.setSugar(3); // s

            System.out.println("Ordered A " + material.getMaterial() + " with " + sugar.getSugar() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Solution {
    public static AbstractFactory setFactory(String factory) {
        if (factory.equals(AbstractFactory._MATERIAL_FACTORY)) {
            return new MaterialFactory();
        } else if (factory.equals(AbstractFactory._SUGAR_FACTORY)) {
            return new SugarFactory();
        }
        return null;
    }
}

abstract class AbstractFactory {

    public final static String _MATERIAL_FACTORY = "MaterialFactory";
    public final static String _SUGAR_FACTORY = "SugarFactory";

    abstract Material setMaterial(String material); // // 通过abstract强制子类实现这些方法 // 子类必须实现这些方法，否则编译错误

    abstract Sugar setSugar(int sugar);

}

class MaterialFactory extends AbstractFactory {

    private final String _PEARL = "Pearl";
    private final static String _COCONUT = "Coconut";
    private final static String _HONEY_BEAN = "HoneyBean";

    @Override
    Material setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            return new MilkTea();
        }
        switch (material) {
            case _PEARL:
                return new Pearl();
            case _COCONUT:
                return new Coconut();
            case _HONEY_BEAN:
                return new HoneyBean();
            default:
                return new MilkTea();
        }
    }

    @Override
    Sugar setSugar(int sugar) {
        return null; // 原料工厂不处理糖分?
    }
}

class SugarFactory extends AbstractFactory {

    private final static int _THREE = 3;
    private final static int _FIVE = 5;
    private final static int _TEN = 10;

    @Override
    Material setMaterial(String material) {
        return null; // 糖分工厂不处理原料
    }

    @Override
    Sugar setSugar(int sugar) {
        // 根据输入返回对应的糖分，0返回默认TenPoint
        switch (sugar) {
            case _THREE:
                return new ThreePoint();
            case _FIVE:
                return new FivePoint();
            case _TEN:
            default:
                return new TenPoint();
        }
    }

}

interface Material {
    public String getMaterial();

}

class Coconut implements Material {

    @Override
    public String getMaterial() {
        return "coconut";

    }

}

class HoneyBean implements Material {

    @Override
    public String getMaterial() {
        return "honeybean";

    }

}

class MilkTea implements Material {

    @Override
    public String getMaterial() {
        return "milktea";

    }

}

class Pearl implements Material {

    @Override
    public String getMaterial() {
        return "pearl";
    }

}

interface Sugar {

    public String getSugar();

}

class FivePoint implements Sugar {

    @Override
    public String getSugar() {
        return "five-point";

    }

}

class TenPoint implements Sugar {

    @Override
    public String getSugar() {
        return "ten-point";

    }

}

class ThreePoint implements Sugar {

    @Override
    public String getSugar() {
        return "three-point";
    }

}
