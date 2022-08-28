package com.kk.structural.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    public abstract float getBalance();
}

class DepositeAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public DepositeAccount(String accountNo, float accountBalance) {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class SavingAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public SavingAccount(String accountNo, float accountBalance) {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<>();

    @Override
    public float getBalance() {
        totalBalance = 0;
        for (Account account : accountList) {
            totalBalance = totalBalance + account.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account cc) {
        accountList.add(cc);
    }
}

public class Client {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(new DepositeAccount("DA1", 1000));
        compositeAccount.addAccount(new DepositeAccount("DA2", 2000));
        compositeAccount.addAccount(new SavingAccount("SA1", 1000));

        System.out.println(compositeAccount.getBalance());
    }
}
