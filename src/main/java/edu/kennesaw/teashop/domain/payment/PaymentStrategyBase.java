package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public abstract class PaymentStrategyBase implements IPaymentStrategy {

    protected final BigDecimal amount;
    protected final int quantityToPurchase;

    public PaymentStrategyBase(BigDecimal amount, int quantityToPurchase){
        this.amount = amount;
        this.quantityToPurchase = quantityToPurchase;
    }
}
