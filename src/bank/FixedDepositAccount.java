package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FixedDepositAccount {
    private String accountName;
    private String accountNumber = String.valueOf((ThreadLocalRandom.current().nextLong(999999999)));
    
    public String getAccountName() {return accountName;}

    public String getAccountNumber() {return accountNumber;}

    protected float accountBalance;
    protected boolean accountClosed = true;
    protected List<String> accountTransactions = new ArrayList<>();

    protected float interest = 3;
    protected int durationMonths = 6;

    public float getInterest() {return interest;}

    int timesInterestChanged = 0;
    public void setInterest(float interest) {
        this.interest = interest;
        timesInterestChanged++;
        if (timesInterestChanged > 1){
            throw new IllegalArgumentException();
        }
    }

    public int getDurationMonths() {return durationMonths;}

    int timesDurationChanged = 0;
    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
        timesDurationChanged++;
        if (timesDurationChanged > 1) {
            throw new IllegalArgumentException();
        }

    }

    protected LocalDate accountOpenDate = LocalDate.now();
    protected LocalDate accountCloseDate = LocalDate.now();

    public FixedDepositAccount(String name, float balance){
        this.accountName = name;
        this.accountBalance = balance;
        System.out.printf("Hello %s! Your current account balance is: %.2f\n", accountName, accountBalance);
    }

    public FixedDepositAccount(String name, float balance, float interest){
        this.accountName = name;
        this.accountBalance = balance;
        this.interest = interest;
        System.out.printf("Hello %s! Your current account balance is: %.2f\n", accountName, accountBalance);
    }

    public FixedDepositAccount(String name, float balance, float interest, int duration){
        this.accountName = name;
        this.accountBalance = balance;
        this.interest = interest;
        this.durationMonths = duration;
        System.out.printf("Hello %s! Your current account balance is: %.2f\n", accountName, accountBalance);
    }

    public void deposit(float amtDeposit){}
    public void withdraw(float amtWithdraw){}

    public void getBalance(){
        this.accountBalance = accountBalance + interest;
        System.out.printf("Your balance after adding $%.2f of interest is: $%.2f\n", interest, accountBalance);
    }
}
