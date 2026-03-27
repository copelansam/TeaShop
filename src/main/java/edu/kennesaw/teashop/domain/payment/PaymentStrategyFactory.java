package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.userinterface.paymentbuilder.ApplePayPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.CreditCardPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.CryptoCurrencyPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.IPaymentBuilder;

public class PaymentStrategyFactory {

    public IPaymentBuilder createPaymentBuilder(PaymentOption option){

        switch (option){

            case CREDITCARD:
                return new CreditCardPaymentBuilder();

            case APPLEPAY:
                return new ApplePayPaymentBuilder();

            case CRYPTOCURRENCY:
                return new CryptoCurrencyPaymentBuilder();

            default:
                throw new IllegalStateException("No payment type selected!");
        }
    }
}
