package edu.kennesaw.teashop.domain.payment;

public class PaymentStrategyFactory {
    public PaymentStrategy createStrategy(PaymentContext context){

        switch (context.getPaymentType()){

            case "Credit Card":
                return new CreditCardPayment();
            case "Apple Wallet":
                return new ApplePayPayment();
            case "Crypto Wallet":
                return new CryptoWalletPayment();
            default:
                throw new IllegalStateException("No payment type selected!");
        }
    }
}
