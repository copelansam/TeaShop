package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public class PaymentContext {
    private String paymentType;
    private PaymentStrategyBase strategy;
    private BigDecimal amount;

    public PaymentContext(String paymentType, BigDecimal amount){
        setPaymentType(paymentType);
        setAmount(amount);
    }

    public String getPaymentType(){
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {

        if(paymentType.isBlank()){
            throw new IllegalArgumentException("Payment type cannot be blank!");
        }
        else {
            this.paymentType = paymentType;
        }
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {

        if (amount.doubleValue() <= 0){
            throw  new IllegalArgumentException("The amount ot charge must be greater than 0");
        }
        else {
            this.amount = amount;
        }
    }
}
