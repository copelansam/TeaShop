package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;

public class CryptoWalletPayment extends PaymentStrategyBase {

    private String walletOwnerName;
    private String walletAddress;
    private String cryptoType;

    public CryptoWalletPayment(BigDecimal amount, int quantityToPurchase, String walletOwnerName, String walletAddress, String cryptoType){
        super(amount, quantityToPurchase);
    }


    @Override
    public void pay(QueriedInventoryItem item) {
        System.out.println("*** Purchase complete. Your" +  quantityToPurchase + " " + item.getName() + " packages " +
                "for $" + amount.toPlainString() + " using the card with number " + getCardNumber() + "is on the way ***");
    }
}
