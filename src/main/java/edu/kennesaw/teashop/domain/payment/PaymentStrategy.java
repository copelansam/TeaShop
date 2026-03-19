package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public interface PaymentStrategy {

    public void pay(BigDecimal amount);
}
