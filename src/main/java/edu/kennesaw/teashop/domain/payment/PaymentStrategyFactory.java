package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.userinterface.paymentbuilder.ApplePayPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.CreditCardPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.CryptoCurrencyPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.IPaymentBuilder;

public class PaymentStrategyFactory {

    private IPaymentBuilder paymentBuilder;

    public IPaymentStrategy createStrategy(PaymentContext context){

        switch (context.getPaymentType()){

            case PaymentOption.CREDITCARD:

                paymentBuilder = new CreditCardPaymentBuilder();
                paymentBuilder.collectInfo();
                return paymentBuilder.buildPayment(context.getAmount(), context.getQuantityToPurchase());

            case PaymentOption.APPLEPAY:

                paymentBuilder = new ApplePayPaymentBuilder();
                paymentBuilder.collectInfo();
                return paymentBuilder.buildPayment(context.getAmount(), context.getQuantityToPurchase());

            case PaymentOption.CRYPTOCURRENCY:

                paymentBuilder = new CryptoCurrencyPaymentBuilder();
                paymentBuilder.collectInfo();
                return paymentBuilder.buildPayment(context.getAmount(), context.getQuantityToPurchase());

            default:
                throw new IllegalStateException("No payment type selected!");
        }
    }
}
