package com.banksse;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinancialCalculatorTest {

    // Simple Interest
    @Test
    void shouldCalculateSimpleInterest() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 2;
        BigDecimal interestExpected = new BigDecimal("100.00");
        BigDecimal actualInterest = calculator.simpleInterest(principal, rate, years);

        assertEquals(interestExpected, actualInterest);
    }

    @Test
    void shouldCalculateSimpleInterestTotal() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 2;
        BigDecimal interestExpected = new BigDecimal("1100.00");

        BigDecimal actualAmount = calculator.simpleInterestTotal(principal, rate, years);

        assertEquals(interestExpected, actualAmount);
    }

    //Compound interest
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

    @Test
    void shouldCalculateCompoundInterestTotal(){
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 12;
        BigDecimal amountExpected = new BigDecimal("1795.86");
        BigDecimal actualAmount = calculator.compoundInterestTotal(principal, rate, years);
        assertEquals(amountExpected, actualAmount);
    }

    //Discount
    @Test
    void shouldCalculateDiscount(){
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal futureValue = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 1;
        BigDecimal discountExpected = new BigDecimal("50.00");
        BigDecimal actualDiscount = calculator.discount(futureValue, rate, years);
        assertEquals(discountExpected, actualDiscount);
    }

    @Test
    void shouldCalculateApplyDiscount()
    {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal futureValue = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 1;
        BigDecimal valueExpected = new BigDecimal("950.00");
        BigDecimal actualValue = calculator.applyDiscount(futureValue, rate, years);
        assertEquals(valueExpected, actualValue);
    }
}