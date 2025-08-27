package com.banksse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class BankOperationsTest {

    @Test
    void BankAccountOperations() {
        BigDecimal money = BigDecimal.valueOf(1000);
        BigDecimal banking = BankAccountOperations.account(money);

       assertEquals(BigDecimal.valueOf(1000), banking);
       banking = BankAccountOperations.withdraw(BigDecimal.valueOf(100));
       assertEquals(BigDecimal.valueOf(900), banking);
       banking = BankAccountOperations.deposit(BigDecimal.valueOf(300));
       assertEquals(BigDecimal.valueOf(1200), banking);

       assertEquals(BankAccountOperations.printBalance(), banking);
    }

    @Test
    void ClientInformation() {


        BankUserInformation newUser = new BankUserInformation("Paul Phoenix", "993.123.001-94", 87023230, "1990-01-01");

        assertInstanceOf(BankUserInformation.class, newUser);



    }
}