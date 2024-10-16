package bank;

public class FDMain {
    public static void main(String[] args) {
        FixedDepositAccount first = new FixedDepositAccount("John", 1000);
        first.deposit(100);
        first.setInterest(4);
        first.getBalance();
        first.setInterest(2);
        first.getBalance();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        FixedDepositAccount second = new FixedDepositAccount("Jamie", 1200, 5);
        second.getBalance();

    }
}
