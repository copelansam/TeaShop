package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public class CreditCardPayment extends PaymentStrategyBase {

    public CreditCardPayment(BigDecimal amount){
        super(amount);
    }

    @Override
    public void pay() {
        // code to implement paying with a credit card
    }
}
