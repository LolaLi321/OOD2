// 什么时候使用static？

import java.util.ArrayList;
import java.util.List;

public class School3426 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(10000);
        Student student = new Student(90.0);
        System.out.println("Number of members: " + SchoolMember.getNumberOfMembers());

        // 模拟删除
        SchoolMember.decreaseNumberOfMembers();
        System.out.println("Number of members: " + SchoolMember.getNumberOfMembers());
    }
    
}
class SchoolMember {
    private String name;
    private List<String> nameList;
    private static int numberOfMembers = 0; // numberOfMembers 应该是静态变量，因为它需要跨对象共享
    // 静态变量可以被所有对象共享，适合用来记录总人数

    public SchoolMember() {
        // this.nameList = new ArrayList<String>();
        numberOfMembers++;
    }

    // get the number of members
    public static int getNumberOfMembers() {
        return numberOfMembers;
    }

    // decrease the number of members
    public static void decreaseNumberOfMembers() { // 将计数逻辑放在父类中，避免子类重复代码
        if (numberOfMembers > 0){
            numberOfMembers--;
        }
    }

}

class Teacher extends SchoolMember {
   private double salary;

   public Teacher(double salary) {
       super(); // 子类无法直接访问父类的私有成员变量，所以需要调用父类的构造函数
       this.salary = salary;
   }
}

class Student extends SchoolMember {
    private double score;
    public Student(double score) {
        super();
        this.score = score;
    }
}
    
    
