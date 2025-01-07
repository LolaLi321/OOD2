/** */ 
// 3338
public class UseWallet3413 {
    public static void main(String[] args) {
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();

        
        wallet1.recharge(10000);
        wallet1.transfer(wallet2, 5000);
        System.out.println("Wallet1 balance: " + wallet1.getBalance() + " Wallet2 balance: " + wallet2.getBalance());
    }
}

class Wallet {
    private double balance;
    // private double limit;
    private static final double DefaultLimit = 20000;

    public Wallet() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void recharge(double amount){
        if (amount >  DefaultLimit || amount < 0) {
            System.out.println("The amount exceeds the limit");
        } else {
            balance += amount;
        }
    }

    public void transfer(Wallet wallet, double amount) {
        if (amount < 0 || amount > DefaultLimit) {
            System.out.println("The transfer amount is not within the transfer limit");
        } else if (wallet == null) {
            System.out.println("The target account has not registered a digital wallet");
        } else if (balance < amount) {
            System.out.println("Your balance is insufficient to complete this transfer");
        } else {
            balance -= amount;
            wallet.recharge(amount);
            System.out.println("Transfer success");
        }
    }
}

// 改进后
// public class UseWallet3413 {
//     public static void main(String[] args) {
//         Wallet wallet1 = new Wallet();
//         Wallet wallet2 = new Wallet();
        
//         try {
//             wallet1.recharge(10000);
//             wallet1.transfer(wallet2, 5000);
//             System.out.println("Wallet1 balance: " + wallet1.getBalance() + 
//                              " Wallet2 balance: " + wallet2.getBalance());
//         } catch (IllegalArgumentException e) {
//             System.out.println("Operation failed: " + e.getMessage());
//         }
//     }
// }

// class Wallet {
//     private static final double TRANSFER_LIMIT = 20000;
//     private double balance;
    
//     public Wallet() {
//         this.balance = 0;
//     }
    
//     public double getBalance() {
//         return balance;
//     }
    
//     public void recharge(double amount) {
//         if (amount <= 0) {
//             throw new IllegalArgumentException("Amount must be positive");
//         }
//         if (amount > TRANSFER_LIMIT) {
//             throw new IllegalArgumentException("Amount exceeds the limit");
//         }
//         balance += amount;
//     }
    
//     public void transfer(Wallet targetWallet, double amount) {
//         if (targetWallet == null) {
//             throw new IllegalArgumentException("Target wallet cannot be null");
//         }
//         if (amount <= 0) {
//             throw new IllegalArgumentException("Transfer amount must be positive");
//         }
//         if (amount > TRANSFER_LIMIT) {
//             throw new IllegalArgumentException("Transfer amount exceeds the limit");
//         }
//         if (balance < amount) {
//             throw new IllegalArgumentException("Insufficient balance");
//         }
        
//         balance -= amount;
//         targetWallet.recharge(amount);
//         System.out.println("Transfer successful");
//     }
// }

