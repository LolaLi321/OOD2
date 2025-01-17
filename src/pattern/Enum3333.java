// 对于枚举类Singleton，只需要定义一个枚举常量INSTANCE即可
// 饿汉式： 私有静态实例/私有构造函数/公有静态获取实例方法
// static：类级别的共享
// enum Singleton（更简单，有很多自带的简化设定）和class Solution两个就是单例的两个实现形式
// 这道题有助于理解static

package pattern;

public class Enum3333 {

    public static void main(String[] args) {
        Solution1 s1 = Solution1.getInstance(); // 通过类名来调用静态方法。
        Solution1 s2 = Solution1.getInstance();

        if (s1.toString().equals(s2.toString())) {
            System.out.println("Create Singleton Success.");
        } else {
            System.out.println("Create Singleton Fail.");
        }

        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;

        if (singleton1.toString().equals(singleton2.toString())) {
            System.out.println("Enum create Singleton Success.");
        } else {
            System.out.println("Enum create Singleton Fail.");
        }
    }
}

// enum实现singleton
enum Singleton {

    INSTANCE; // 大写是Java中常量的命名约定 / 枚举常量默认是public static final的，所以不需要显式修饰符

}

class Solution1 {

    // 饿汉式
    // 1. 在类加载时就创建实例 - static确保在类加载时创建实例，而不是对象创建时, if没有static则在new对象时创建实例
    private static final Solution1 instance = new Solution1(); // static final

    // 2. 私有构造函数防止外部创建实例
    private Solution1() { // private
    }

    // 3. 提供公共的获取实例方法
    public static Solution1 getInstance() { // static 允许在不创建类实例的情况下访问这个方法。
        return instance;
    }

}
