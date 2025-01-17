// 代理模式：使用proxy来控制队server的访问

package pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Proxy3405 {
    public static void main(String[] args) {
        Map<String, Object> info_struct = new HashMap<>();
        info_struct.put("addr", 10010);
        info_struct.put("content", "Hello World!");

        InfoServer info_server = new InfoServer();
        WhiteInfoServerProxy info_server_proxy = new WhiteInfoServerProxy(info_server);

        System.out.println(info_server_proxy.receive(info_struct));
        info_server_proxy.show();

        info_server_proxy.addWhite(10010);
        System.out.println(info_server_proxy.receive(info_struct));
        info_server_proxy.show();
    }

}

// 2. 基础服务器类
class Server {
    // 可以是空的基类
    // 它提供了一个类型标识，表明所有继承它的类都是"服务器"
    // 在面向对象设计中，这种基类可以用来统一管理不同类型的服务器
    // 将来如果需要添加所有服务器都需要的功能，可以直接添加到这个基类中
    // 这是一种"标记"作用，类似于 Java 中的 Serializable 接口
}

// 3. 信息服务器类
class InfoServer extends Server {
    private String receivedContent = "";

    public void receive(Map<String, Object> info) {
        this.receivedContent = (String) info.get("content");
        System.out.println("recv OK!");
    }

    public void show() {
        System.out.println("SHOW:" + receivedContent);
    }
}

// 4. 基础代理类
class InfoServerProxy { // private 只允许当前类访问
    protected Server server; // protected 允许当前类和子类访问， 这里用 protected 是因为子类 WhiteInfoServerProxy 需要访问这个字段

    public InfoServerProxy(Server server) {
        this.server = server;
    }

    public String receive(Map<String, Object> info) {
        if (server instanceof InfoServer) { // instanceof 检查 server 对象是否是 InfoServer 类型--如果是，则进行类型转换并调用特定方法
            ((InfoServer) server).receive(info); // Server 类中没有 receive 方法--虽然通过 instanceof 确认了它是 InfoServer
                                                 // 类型--但编译器只看声明类型，所以我们必须显式转换才能调用 receive 方法
        }
        return "recv OK!"; // 返回默认成功消息
    }

    public void show() {
        if (server instanceof InfoServer) {
            ((InfoServer) server).show();
        }
    }
}

// 5. 白名单代理类
class WhiteInfoServerProxy extends InfoServerProxy {
    private Set<Integer> whiteList = new HashSet<>();

    public WhiteInfoServerProxy(Server server) {
        super(server); // 调用父类构造函数 // 等价于this.server = server;
    }

    public void addWhite(int addr) {
        whiteList.add(addr);
    }

    @Override
    public String receive(Map<String, Object> info) {
        int addr = (int) info.get("addr");
        if (!whiteList.contains(addr)) {
            return "Your address is not in the white list.";
        }
        super.receive(info);
        return "recv OK!";
    }
}