// 构造函数包含哪些？

import java.util.ArrayList;
import java.util.List;

class Home {
    private String type; // house_style
    private double zarea; // total area
    private double farea; // reamaining area
    // private String[] furniture_list;
    private List<String> furniture_list;

    public Home(String type, double zarea) {
        this.type = type;
        this.zarea = zarea;
        this.farea = zarea;
        this.furniture_list = new ArrayList<String>();
        // this.farea = farea; // 这些不是构造之初会有的
        // this.furniture_list = furniture_list; // 这些不是构造之初会有的
    }

    public void addFurniture(Furniture furniture) {
        // check whether the area of the furniture is less than the free area
        double furniture_area = furniture.getArea();
        if (furniture_area > farea) {
            System.out.println(furniture.getName() + "foot print is too large to place this furniture...");
            return;
        } else {
            // add the furniture to the list
            System.out.println("Adding " + furniture.getName() + " to the house...");
            furniture_list.add(furniture.getName());
            farea -= furniture_area;
            printHouse();
        }
    }

    public void printHouse(){
        System.out.printf("Household type:%s Total area:%.2f Remaining area:%.2f Furniture:%s%n", type, zarea,farea, furniture_list.toString());
    }
}

class Furniture {
    private String name;
    private double area; // 1.5

    public Furniture(String name, double area) {
        this.name = name;
        this.area = area;
    } 

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

}

public class FurnitureDesign3427 {
    public static void main (String[] args) {
        Home home = new Home("Apartment", 5.0);
        home.printHouse();

        Furniture bed = new Furniture("Bed", 4);
        Furniture table = new Furniture("Table", 1.5);
        Furniture wardrobe = new Furniture("Chair", 2);

        
        home.addFurniture(bed);
        home.addFurniture(table);
        home.addFurniture(wardrobe);
    }
}

