// abstract的处理？
public class Curtain3392 {
    public static void main(String[] args) {
        Curtain curtain = new Curtain();
        Command curtainCommand = new CurtainCommand(curtain);
        Remote remote = new Remote(curtainCommand);
        remote.action("open");
        remote.action("close");
    }
}

abstract class Command {
    abstract public  void execute(String action); // 这里不需要实现？抽象方法确实不需要实现，它只是一个声明
}

class CurtainCommand extends Command {
    private Curtain curtain;

    public CurtainCommand(Curtain curtain){
        this.curtain = curtain;
    } 
    
    @Override
    public void execute(String action) {
        if ("open".equals(action)) {
            curtain.open();
        } else if ("close".equals(action)) {
            curtain.close();
        }
    }

   
}

class Curtain {
    public Curtain() {
    }

    public void open() {
        System.out.println("Action 1: Opening Curtains");
    }

    public void close() {
        System.out.println("Action 2: Closing Curtains");
    }
}

class Remote {
    private Command command;

    public Remote(Command command) {
        this.command = command;
    }

    public void action(String cmd) {
        command.execute(cmd);
    }
}

    

// // Command.java
// package command;

// public abstract class Command {
//     // 定义抽象方法
//     abstract public void execute(String action);
// }

// // CurtainCommand.java
// package command;

// public class CurtainCommand extends Command {
//     private Curtain curtain;
    
//     public CurtainCommand(Curtain curtain) {
//         this.curtain = curtain;
//     }
    
//     @Override
//     public void execute(String action) {
//         if ("open".equals(action)) {
//             curtain.open();
//         } else if ("close".equals(action)) {
//             curtain.close();
//         }
//     }
// }

// // Remote.java (在controller文件夹下)
// package controller;

// import command.Command;

// public class Remote {
//     private Command command;
    
//     public Remote(Command command) {
//         this.command = command;
//     }
    
//     public void action(String cmd) {
//         command.execute(cmd);
//     }
// }

// // Curtain.java (在entity文件夹下)
// package entity;

// public class Curtain {
//     public void open() {
//         System.out.println("The curtain is open");
//     }
    
//     public void close() {
//         System.out.println("The curtain is closed");
//     }
// }