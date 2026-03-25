package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.userinterface.paymentbuilder.CreditCardPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.IPaymentBuilder;

public class PaymentStrategyFactory {

    private IPaymentBuilder paymentBuilder;

    public IPaymentStrategy createStrategy(PaymentContext context){

        switch (context.getPaymentType()){

            case PaymentOption.CREDITCARD:
                //return new CreditCardPayment(context.getAmount());
                paymentBuilder = new CreditCardPaymentBuilder();
                paymentBuilder.buildPayment(context.getAmount(), context.getQuantityToPurchase());
                System.out.println("You selected credit card");
            case PaymentOption.APPLEPAY:
                //return new ApplePayPayment(context.getAmount());
                System.out.println("You selected apple pay");
            case PaymentOption.CRYPTOCURRENCY:
                //return new CryptoWalletPayment(context.getAmount());
                System.out.println("You selected crypto currency");
            default:
                throw new IllegalStateException("No payment type selected!");
        }
    }
}
