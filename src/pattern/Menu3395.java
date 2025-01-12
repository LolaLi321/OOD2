// 不同角色，不同策略
package pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu3395 {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();

        User admin = new User("Bob", "Admin");
        admin.setMenuList(menuController.getMenuByRole(admin.getRole()));

        User staff = new User("Candy", "Staff");
        staff.setMenuList(menuController.getMenuByRole(staff.getRole()));

        System.out.println("Menu List of Admin: " + admin.getMenuList().toString());
        System.out.println("Menu List of Staff: " + staff.getMenuList().toString());

    }

}

// constants
interface MenuConstants { // define all available menus

    Menu MENU_INDEX = new Menu("Index", "/index", Arrays.asList("Admin", "Staff"));

    Menu MENU_HOME = new Menu("Home", "/home", Arrays.asList("Admin", "Staff"));

    Menu MENU_FILE = new Menu("File", "/file", Arrays.asList("Admin", "Staff"));

    Menu MENU_ROLE = new Menu("Role", "/manage/role", Arrays.asList("Admin"));

    List<Menu> MENU_LIST = Arrays.asList(MENU_INDEX, MENU_HOME, MENU_FILE, MENU_ROLE);

}

// controller
class MenuController {
    private AdminStrategyImpl adminStrategy;
    private StaffStrategyImpl staffStrategy;

    public MenuController() {
        this.adminStrategy = new AdminStrategyImpl(MenuConstants.MENU_LIST);
        this.staffStrategy = new StaffStrategyImpl(MenuConstants.MENU_LIST);
    }

    public List<Menu> getMenuByRole(String role) {
        if ("Admin".equals(role)) {
            return adminStrategy.getMenuListByRole();
        } else if ("Staff".equals(role)) {
            return staffStrategy.getMenuListByRole();
        }
        return new ArrayList<>();
    }
}

// strategy interface
interface RoleStrategy { // define the behavior to get the menulist
    List<Menu> getMenuListByRole();

}

class AdminStrategyImpl implements RoleStrategy {
    private List<Menu> menuList; // 需要菜单列表来过滤

    // 构造函数接收菜单列表
    public AdminStrategyImpl(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override // 实现获取菜单的方法：过滤出Admin角色可访问的菜单
    public List<Menu> getMenuListByRole() {
        return menuList.stream()
                .filter(menu -> menu.getRoles().contains("Admin"))
                .collect(Collectors.toList());
    }
}

class StaffStrategyImpl implements RoleStrategy {
    private List<Menu> menuList;

    public StaffStrategyImpl(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public List<Menu> getMenuListByRole() {
        return menuList.stream()
                .filter(menu -> menu.getRoles().contains("Staff"))
                .collect(Collectors.toList());
    }
}

// entity
class User {
    String name;
    String role;
    List<Menu> menuList;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}

class Menu {
    String name;
    String path;
    List<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Menu(String name, String path, List<String> roles) {
        this.name = name;
        this.path = path;
        this.roles = roles;

    }

    @Override
    public String toString() {
        return "\t{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

}
