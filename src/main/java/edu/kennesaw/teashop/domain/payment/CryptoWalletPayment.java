package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;

public class CryptoWalletPayment extends PaymentStrategyBase {

    public CryptoWalletPayment(BigDecimal amount){
        super(amount);
    }


    @Override
    public void pay() {
        // code to implement paying with crypto wallet
    }
}
