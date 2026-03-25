package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.PaymentStrategyBase;

import java.math.BigDecimal;

public interface IPaymentBuilder {

    // This method will be responsible for collecting relevant info dependent on the concrete implementation
    public void collectInfo();

    public PaymentStrategyBase buildPayment(BigDecimal amount, int quantityToPurchase);

}
