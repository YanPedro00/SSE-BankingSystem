package com.banksse;

import java.math.BigDecimal;

//public class Cliente {
//    public BankAccount bankAccount;
//    public string address;
//    public String email;
//    public String telefone;
//}


public class BankAccountOperations {
    private String agency;
    private static BigDecimal balance;
    private static BigDecimal sequential = BigDecimal.valueOf(1);
    private static final Integer standardAgency = 1;

    public static BigDecimal account(BigDecimal initialBalance) {
        try {
            balance = initialBalance;
        } catch (Exception e) {
            System.out.println("Error while processing account function");
        }
        return initialBalance;
    }



public static BigDecimal withdraw(BigDecimal value){
        try {
            balance = balance.subtract(value);
        } catch (Exception e) {
            System.out.println("Error while processing withdraw action");
        }
    return balance;
}


public static BigDecimal deposit(BigDecimal value) {
        try {
            balance = balance.add(value);
        } catch (Exception e) {
            System.out.println("Error while processing deposit action");
        }
    return  balance;
}

public static BigDecimal printBalance() {
    return balance;
}

public static BigDecimal GetSequential() {
    return sequential;
    }

}