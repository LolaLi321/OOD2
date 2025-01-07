public class PrintStudent3298 {
    public static void main(String[] args) {
        Student student = new Student("John", 18, "male", "MIT", "6");
        student.personInfo();
    }
}

class Person2 {
    private final String name;
    private final int age;
    private final String gender;

    public Person2(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void personInfo() {
        // 方式1：String.format
        System.out.println(String.format("Name: %s, Age: %d, Gender: %s", 
            name, age, gender));
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
}

class Student extends Person2 {
    private final String college;
    private final String group;

    public Student(String name, int age, String gender, String college, String group) {
        super(name, age, gender);
        this.college = college;
        this.group = group;
    }

    @Override
    public void personInfo() {
        super.personInfo();
        System.out.println(String.format("College: %s, Group: %s", 
            college, group));
    }
}