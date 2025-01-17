// 模版方式方法 template method
// public final void template() { --- 这里要使用final，因为不希望子类改变顺序固定（template method核心体现）

package pattern;

public class ITemplate3390 {
    public static void main(String[] args) {
        // drive
        System.out.println("Drive");
        ITemplate drive = new Drive();
        drive.template();

        // wash hands
        System.out.println("\nWash");
        ITemplate wash = new Wash();
        wash.template();

    }
}

abstract class ITemplate {

    protected abstract void doFirst();

    // protected abstract void doSecond();

    // 可以考虑使用hook方法而不是空实现
    protected void doSecond() {
        // 默认空实现，子类可以选择性重写
    }

    public final void template() {
        doFirst();
        doSecond();
    }

}

class Drive extends ITemplate {

    @Override
    protected void doFirst() {
        System.out.println("Start the engine.");

    }

    @Override
    protected void doSecond() {
        System.out.println("Put into gear and drive.");

    }

}

class Wash extends ITemplate {

    @Override
    protected void doFirst() {
        System.out.println("Wash my hands.");

    }

    // @Override // 不需要重写doSecond()，使用父类默认实现 -- 这只是一个优化方式，原来空实现的方法也ok
    // protected void doSecond() {
    // // nothing

    // }

}
