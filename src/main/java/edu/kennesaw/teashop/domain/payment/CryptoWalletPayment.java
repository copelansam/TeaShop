package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;

public class CryptoWalletPayment extends PaymentStrategyBase {

    private String walletOwnerName;
    private String walletAddress;
    private CryptoType cryptoType;

    public CryptoWalletPayment(BigDecimal amount, int quantityToPurchase, String walletOwnerName, String walletAddress, CryptoType cryptoType){
        super(amount, quantityToPurchase);
        this.cryptoType = cryptoType;
    }


    @Override
    public void pay(QueriedInventoryItem item) {
        System.out.println("*** Purchase complete. Your " +  quantityToPurchase + " " + item.getName() + " packages " +
                "for $" + amount.toPlainString() + " using crypto type " + cryptoType.getDisplayName() + " is on the way ***");
    }
}
