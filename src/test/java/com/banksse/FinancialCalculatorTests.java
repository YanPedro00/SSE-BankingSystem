package com.banksse;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FinancialCalculatorTest {

    // Simple Interest
    @Test
    void shouldCalculateSimpleInterest() throws InvalidFinancialParameterException {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 2;
        BigDecimal interestExpected = new BigDecimal("100.00");
        BigDecimal actualInterest = calculator.simpleInterest(principal, rate, years);

        assertEquals(interestExpected, actualInterest);
    }

    @Test
    void shouldCalculateSimpleInterestTotal() throws InvalidFinancialParameterException {
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
    void shouldCalculateCompoundInterest() throws InvalidFinancialParameterException {
       FinancialCalculator calculator = new FinancialCalculator();
       BigDecimal principal = new BigDecimal("1000");
       BigDecimal rate = new BigDecimal("0.05");
       int years = 12;
       BigDecimal interestExpected = new BigDecimal("795.86");
       BigDecimal actualInterest = calculator.compoundInterest(principal, rate, years);
       assertEquals(interestExpected, actualInterest);
    }

    @Test
    void shouldCalculateCompoundInterestTotal() throws InvalidFinancialParameterException {
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
    void shouldCalculateDiscount() throws InvalidFinancialParameterException {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal futureValue = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 1;
        BigDecimal discountExpected = new BigDecimal("50.00");
        BigDecimal actualDiscount = calculator.discount(futureValue, rate, years);
        assertEquals(discountExpected, actualDiscount);
    }

    @Test
    void shouldCalculateApplyDiscount() throws InvalidFinancialParameterException {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal futureValue = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05");
        int years = 1;
        BigDecimal valueExpected = new BigDecimal("950.00");
        BigDecimal actualValue = calculator.applyDiscount(futureValue, rate, years);
        assertEquals(valueExpected, actualValue);
    }

    // Exception Tests
    @Test
    void shouldThrowExceptionForNullPrincipal() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal rate = new BigDecimal("0.05");
        int years = 2;

        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.simpleInterest(null, rate, years)
        );
        
        assertEquals("Principal and rate cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullRate() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000.00");
        int years = 2;

        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.compoundInterest(principal, null, years)
        );
        
        assertEquals("Principal and rate cannot be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullFutureValue() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal rate = new BigDecimal("0.05");
        int years = 1;

        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.discount(null, rate, years)
        );
        
        assertEquals("Future value and rate cannot be null", exception.getMessage());
    }

    @Test
    void shouldValidateInputsInAllMethods() {
        FinancialCalculator calculator = new FinancialCalculator();
        
        assertThrows(InvalidFinancialParameterException.class,
            () -> calculator.simpleInterest(null, new BigDecimal("0.05"), 1));
        
        assertThrows(InvalidFinancialParameterException.class, 
            () -> calculator.simpleInterestTotal(new BigDecimal("1000"), null, 1));
        
        assertThrows(InvalidFinancialParameterException.class, 
            () -> calculator.compoundInterest(null, new BigDecimal("0.05"), 1));
        
        assertThrows(InvalidFinancialParameterException.class, 
            () -> calculator.compoundInterestTotal(new BigDecimal("1000"), null, 1));
        
        assertThrows(InvalidFinancialParameterException.class, 
            () -> calculator.discount(null, new BigDecimal("0.05"), 1));
        
        assertThrows(InvalidFinancialParameterException.class, 
            () -> calculator.applyDiscount(new BigDecimal("1000"), null, 1));
    }
}