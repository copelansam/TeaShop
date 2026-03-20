package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public class PaymentContext {
    private PaymentOption paymentType;
    private PaymentStrategyBase strategy;
    private BigDecimal amount;

    public PaymentContext(PaymentOption paymentType, BigDecimal amount){
        setPaymentType(paymentType);
        setAmount(amount);
    }

    public PaymentOption getPaymentType(){
        return this.paymentType;
    }

    public void setPaymentType(PaymentOption paymentType) {
            this.paymentType = paymentType;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {

        if (amount.doubleValue() <= 0){
            throw  new IllegalArgumentException("The amount to charge must be greater than 0");
        }
        else {
            this.amount = amount;
        }
    }
}
