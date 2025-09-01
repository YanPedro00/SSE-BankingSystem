package com.banksse;

/**
 * Simple exception for invalid financial parameters
 */
public class InvalidFinancialParameterException extends Exception {

    public InvalidFinancialParameterException(String message) {
        super(message);
    }
}
