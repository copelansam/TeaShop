package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public class ApplePayPayment extends PaymentStrategyBase {

    public ApplePayPayment(BigDecimal amount){
        super(amount);
    }

    public void pay(){
        // code to implement paying with apple pay
    }
}
