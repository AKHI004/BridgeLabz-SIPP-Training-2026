package Main.Java.core_java_practice.core_java.org.example.scenario_based;

class BankAccount {
    String accNo;
    String holder;
    double balance;
    static int totalAccounts = 0;

    BankAccount(String accNo, String holder, double balance) {
        this.accNo = accNo;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void getStatement() {
        System.out.println("Account No: " + accNo);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {

        BankAccount a1 = new BankAccount("01", "Akhi", 90000);
        BankAccount a2 = new BankAccount("02", "Jett", 15000);
        BankAccount a3 = new BankAccount("03", "Yoru", 20000);

        a1.deposit(1000);
        a1.withdraw(500);
        a1.deposit(2000);
        a1.withdraw(3000);
        a1.withdraw(15000);

        a2.deposit(500);
        a2.withdraw(1000);
        a2.deposit(2500);
        a2.withdraw(4000);
        a2.withdraw(20000);

        a3.deposit(3000);
        a3.withdraw(2000);
        a3.deposit(1000);
        a3.withdraw(5000);
        a3.withdraw(25000);

        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("Total Accounts = " + BankAccount.totalAccounts);
    }
}