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
       balance = initialBalance;
        return balance;
    }


public static BigDecimal withdraw(BigDecimal value){
    balance = balance.subtract(value);
    return balance;
}


public static BigDecimal deposit(BigDecimal value) {
    balance = balance.add(value);
    return  balance;
}

public static BigDecimal printBalance() {
    return balance;
}

public static BigDecimal GetSequential() {
    return sequential;
    }

}