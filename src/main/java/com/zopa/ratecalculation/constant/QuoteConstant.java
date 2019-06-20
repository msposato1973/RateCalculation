package com.zopa.ratecalculation.constant;

import java.math.BigDecimal;

/**
 * 
 * @author maxp
 *
 */
public class QuoteConstant {

	// This could be made configurable
    public static BigDecimal INCREMENT_AMOUNT = BigDecimal.valueOf(100);
    public static BigDecimal LOWER_RANGE = BigDecimal.valueOf(1000);
    public static BigDecimal UPPER_RANGE = BigDecimal.valueOf(15000);
    public static int LOAN_LENGTH_MONTHS = 36;
    public static final String DOUBLE_DIGIT_PATTERN = ".##";
    public static final String SINGLE_DIGIT_PATTERN = ".#";
    public static final double round = 1000.0;

    public static final String ERR = "Pass Market data file path and specify the loan amount !!!"; 
    public static final String ERR_QUOTE = "No quote can be provided at this time due to insufficient amount";
    public static final String ERR_AMOUNT_RANGE = "The requested amount is out of range 1000 and 15000";
    public static final String ERR_AMOUNT_REQUEST = "The requested amount is not incremental of 100";
    
    public final static String MSG_Amount = "Requested amount: £";
    public final static String MSG_RATE = "Rate: in % : ";
    public final static String MSG_MonthlyRepayment = "Monthly repayment: £";
    public final static String MSG_TotalRepayment   = "Total repayment: £";
}
