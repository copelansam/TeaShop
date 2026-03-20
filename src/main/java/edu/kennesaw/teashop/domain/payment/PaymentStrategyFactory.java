package edu.kennesaw.teashop.domain.payment;

public class PaymentStrategyFactory {
    public IPaymentStrategy createStrategy(PaymentContext context){

        switch (context.getPaymentType()){

            case "Credit Card":
                //return new CreditCardPayment(context.getAmount());
            case "Apple Wallet":
                return new ApplePayPayment(context.getAmount());
            case "Crypto Wallet":
                return new CryptoWalletPayment(context.getAmount());
            default:
                throw new IllegalStateException("No payment type selected!");
        }
    }
}
