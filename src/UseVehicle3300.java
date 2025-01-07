// 如何处理acceralation和time?

public class UseVehicle3300 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(100, 10);
        vehicle.move();
        vehicle.setSpeed(100);
        vehicle.speedUp();
        vehicle.speedDown();
    }
}

class Vehicle {
    private int speed;
    private int size;
    private int accceleration;
    private int time;

    // constructor
    public Vehicle(int speed, int size) {
        this.speed = speed;
        this.size = size;
        this.accceleration = 2; // 根据输出设置默认加速度
        this.time = 1; // 
    }

    public void move() {
        System.out.println(speed + size + accceleration);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("The initial velocity of the setting is " + speed);
    }

    public void speedUp() {
        speed = speed + accceleration * time;
        System.out.println("The speed after the acceleration is " + speed);
    }   

    public void speedDown() {
        speed = speed - accceleration * time;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("The speed after the deceleration is 
        " + speed);
    }

}