package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public abstract class PaymentStrategyBase implements IPaymentStrategy {

    protected final BigDecimal amount;

    public PaymentStrategyBase(BigDecimal amount){
        if (amount.doubleValue() <= 0){
            throw  new IllegalArgumentException("The amount ot charge must be greater than 0");
        }
        else if (amount == null){
            throw new NullPointerException("Amount cannot be null");
        }
        else {
            this.amount = amount;
        }
    }


}
