package com.banksse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

class FinancialCalculator {

    public static BigDecimal simpleInterest(BigDecimal amount, BigDecimal rate, int time)
    {
        BigDecimal bigTime = new BigDecimal(time);
        BigDecimal interest = amount.multiply(rate);
        MathContext m = new MathContext(2);
        interest = interest.round(m);
        interest = interest.multiply(bigTime);
        return interest;
    }

    public static BigDecimal simpleInterestTotal(BigDecimal amount, BigDecimal rate, int time){
        BigDecimal interest = simpleInterest(amount, rate, time);
        BigDecimal completeInterest = amount.add(interest);
        return completeInterest;
    }

    public BigDecimal compoundInterest(BigDecimal principal, BigDecimal rate, int years){
        BigDecimal onePlusRate = BigDecimal.ONE.add(rate);
        BigDecimal factor = onePlusRate.pow(years);
        BigDecimal amount = principal.multiply(factor);


        amount = amount.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal interest = amount.subtract(principal);
        return interest;
    }

    public BigDecimal compoundInterestTotal(BigDecimal principal, BigDecimal rate, int years){
        BigDecimal interest = compoundInterest(principal, rate, years);
        BigDecimal amount = principal.add(interest);
        return amount;
    }
}