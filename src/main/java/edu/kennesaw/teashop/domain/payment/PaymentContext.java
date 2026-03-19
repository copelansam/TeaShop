package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public class PaymentContext {
    private String paymentType;
    private BigDecimal ammount;

    public PaymentContext(String paymentType, BigDecimal amount){
        this.paymentType = paymentType;
        this.ammount = amount;
    }

    public String getPaymentType(){
        return this.paymentType;
    }

    public BigDecimal getAmmount(){
        return this.ammount;
    }
}
