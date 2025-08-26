package com.banksse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class BankOperationsTest {

    @Test
    void UserDetailsIsCompleted() {
        BigDecimal money = BigDecimal.valueOf(1000);
        BigDecimal banking = BankAccount.account(money);

       assertEquals(BigDecimal.valueOf(1000), banking);
       banking = BankAccount.withdraw(BigDecimal.valueOf(100));
       assertEquals(BigDecimal.valueOf(900), banking);
       banking = BankAccount.deposit(BigDecimal.valueOf(300));
       assertEquals(BigDecimal.valueOf(1200), banking);

       assertEquals(BankAccount.printBalance(), banking);
    }
}