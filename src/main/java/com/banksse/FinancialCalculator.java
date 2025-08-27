package com.banksse;
import java.math.BigDecimal;
import java.math.RoundingMode;

class FinancialCalculator {

    public BigDecimal simpleInterest(BigDecimal principal, BigDecimal rate, int years)
    {
        BigDecimal interest = principal.multiply(rate).multiply(BigDecimal.valueOf(years));
        interest = interest.setScale(2, RoundingMode.HALF_UP);
        return interest;
    }

    public BigDecimal simpleInterestTotal(BigDecimal principal, BigDecimal rate, int years){
        BigDecimal interest = simpleInterest(principal, rate, years);
        BigDecimal amount = principal.add(interest);
        return amount;
    }

    public BigDecimal compoundInterest(BigDecimal principal, BigDecimal rate, int years){
        BigDecimal onePlusRate = BigDecimal.ONE.add(rate);
        BigDecimal factor = onePlusRate.pow(years);
        BigDecimal amount = principal.multiply(factor);
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal interest = amount.subtract(principal);
        return interest;
    }

    public BigDecimal compoundInterestTotal(BigDecimal principal, BigDecimal rate, int years){
        BigDecimal interest = compoundInterest(principal, rate, years);
        BigDecimal amount = principal.add(interest);
        return amount;
    }

    public BigDecimal discount(BigDecimal futureValue, BigDecimal rate, int years) {
        BigDecimal discount = futureValue.multiply(rate).multiply(BigDecimal.valueOf(years));
        discount = discount.setScale(2, RoundingMode.HALF_UP);
        return discount;
    }

    public BigDecimal applyDiscount(BigDecimal futureValue, BigDecimal rate, int years) {
        BigDecimal discountValue = discount(futureValue, rate, years);
        BigDecimal discountApplied = futureValue.subtract(discountValue);
        discountApplied = discountApplied.setScale(2, RoundingMode.HALF_UP);
        return discountApplied;
    }
}