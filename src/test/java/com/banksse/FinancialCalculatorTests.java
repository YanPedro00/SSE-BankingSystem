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
        BigDecimal amountExpected = new BigDecimal("1100.00");

        BigDecimal actualAmount = calculator.simpleInterestTotal(principal, rate, years);

        assertEquals(amountExpected, actualAmount);
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
    // Test Valid Input Method
    @Test
    void shouldThrowExceptionForNullPrincipal() {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal rate = new BigDecimal("0.05");
        int years = 2;

        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.simpleInterest(null, rate, years)
        );
        String expectedMessage = "Principal and rate cannot be null";
        
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullRate() throws InvalidFinancialParameterException {
        FinancialCalculator calculator = new FinancialCalculator();
        BigDecimal principal = new BigDecimal("1000.00");
        int years = 2;

        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.compoundInterest(principal, null, years)
        );
        String expectedMessage = "Principal and rate cannot be null";
        
        assertEquals(expectedMessage, exception.getMessage());
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
        String expectedMessage = "Future value and rate cannot be null";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativePrincipal() {
        FinancialCalculator calculator = new FinancialCalculator();
        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.simpleInterest(new BigDecimal("-1000"), new BigDecimal("0.05"), 1)
        );
        String expectedMessage = "Principal and rate must be positive";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForZeroRate() {
        FinancialCalculator calculator = new FinancialCalculator();
        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.compoundInterest(new BigDecimal("1000"), BigDecimal.ZERO, 1)
        );
        String expectedMessage = "Principal and rate must be positive";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeFutureValue() {
        FinancialCalculator calculator = new FinancialCalculator();
        InvalidFinancialParameterException exception = assertThrows(
            InvalidFinancialParameterException.class,
            () -> calculator.discount(new BigDecimal("-1000"), new BigDecimal("0.05"), 1)
        );
        String expectedMessage = "Future value and rate must be positive";

        assertEquals(expectedMessage, exception.getMessage());
    }
}