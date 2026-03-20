package edu.kennesaw.teashop.domain.payment;

public class PaymentStrategyFactory {
    public IPaymentStrategy createStrategy(PaymentContext context){

        switch (context.getPaymentType()){

            case PaymentOption.CREDITCARD:
                //return new CreditCardPayment(context.getAmount());
            case PaymentOption.APPLEPAY:
                return new ApplePayPayment(context.getAmount());
            case PaymentOption.CRYPTOCURRENCY:
                return new CryptoWalletPayment(context.getAmount());
            default:
                throw new IllegalStateException("No payment type selected!");
        }
    }
}
