package bank;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.*;

public class BankAccount {
    // members of the class
    private String accountName;
    private String accountNumber = String.valueOf((ThreadLocalRandom.current().nextLong(999999999)));
    
    public String getAccountName() {return accountName;}

    public String getAccountNumber() {return accountNumber;}

    protected float accountBalance;
    protected boolean accountClosed = true;
    protected List<String> accountTransactions = new ArrayList<>();

    protected LocalDate accountOpenDate = LocalDate.now();
    protected LocalDate accountCloseDate = LocalDate.now();


    // constructors
    public BankAccount(String name){
        this.accountName = name;
        accountBalance = 0;
        System.out.printf("Hello %s! Your current account balance is: $%.2f\n", name, accountBalance);
    }

    public BankAccount(String name, float initBalance){
        this.accountName = name;
        this.accountBalance = initBalance;
        System.out.printf("Hello %s! Your current account balance is: $%.2f\n", name, accountBalance);
    }

    // methods
    public void deposit(float amtDeposit){
        if (amtDeposit > 0){
        this.accountBalance = accountBalance + amtDeposit;
        LocalDateTime depositDate = LocalDateTime.now();
        accountTransactions.add("deposit $" + String.valueOf(amtDeposit) + " to account at " + depositDate.toString());
        System.out.printf("$%.2f has been deposited to your account %s\n", amtDeposit, accountNumber);
        System.out.printf("Yout total balance now is: %.2f\n", accountBalance);
        } else {throw new IllegalArgumentException();}
    }

    public void withdraw(float amtWithdraw){
        if (amtWithdraw > 0){
            this.accountBalance = accountBalance - amtWithdraw;
            LocalDateTime withdrawDate = LocalDateTime.now();
            accountTransactions.add("withdraw $" + String.valueOf(amtWithdraw) + " to account at " + withdrawDate.toString());
            System.out.printf("$%.2f has been withdrawn from your account %s\n", amtWithdraw, accountNumber);
            System.out.printf("Your total balance now is: $%.2f\n", accountBalance);
        } else {throw new IllegalArgumentException();}
    }
}