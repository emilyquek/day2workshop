package bank;

public class Main {
    public static void main(String[] args) {
        
        BankAccount first = new BankAccount("John");
        first.deposit(100);
        first.withdraw(50);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");

        BankAccount second = new BankAccount("Jamie", 2000);
        second.withdraw(300);
        second.deposit(468);
        second.withdraw(1120);
    }
}
