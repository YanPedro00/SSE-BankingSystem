package com.banksse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinancialCalculatorTest {

    @Test
    void shouldCalculateSimpleInterest() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal amount = new BigDecimal("1000");
        BigDecimal rate = new BigDecimal(0.05);
        int time = 2;
        BigDecimal interestExpected = new BigDecimal("100");
        BigDecimal interest = FinancialCalculator.simpleInterest(amount, rate, time);

        assertEquals(interestExpected, interest);
    }

    @Test
    void shouldCalculateSimpleInterestTotal() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal amount = new BigDecimal("1000");
        BigDecimal rate = new BigDecimal(0.05);
        int time = 2;
        BigDecimal interestExpected = new BigDecimal("1100");

        BigDecimal interest = FinancialCalculator.simpleInterestTotal(amount, rate, time);

        assertEquals(interestExpected, interest);
    }

    @Test
    void shouldCalculateCompoundInterest() {
       FinancialCalculator calculator = new FinancialCalculator();
       BigDecimal principal = new BigDecimal("1000");
       BigDecimal rate = new BigDecimal("0.05");
       int years = 12;
       BigDecimal interestExpected = new BigDecimal("795.86");
       BigDecimal actualInterest = calculator.compoundInterest(principal, rate, years);
       assertEquals(interestExpected, actualInterest);
    }

    void shouldCalculateCompoundInterestTotal(){
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 12;
        BigDecimal amountExpected = new BigDecimal("1795.86");
        BigDecimal actualAmount = calculator.compoundInterestTotal(principal, rate, years);
        assertEquals(amountExpected, actualAmount);
    }
}