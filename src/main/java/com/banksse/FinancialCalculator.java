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
}