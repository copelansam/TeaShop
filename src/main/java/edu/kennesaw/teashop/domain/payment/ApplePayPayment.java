package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;

public class ApplePayPayment extends PaymentStrategyBase {

    private String walletOwnerName;
    private String deviceId;
    private String applePayToken;

    public ApplePayPayment(BigDecimal amount, int quantityToPurchase, String walletOwnerName, String deviceId, String applePayToken){
        super(amount, quantityToPurchase);
        this.walletOwnerName = walletOwnerName;
        this.deviceId = deviceId;
        this.applePayToken = applePayToken;
    }

    public void pay(QueriedInventoryItem item){
            System.out.println("*** Purchase complete. Your " +  quantityToPurchase + " " + item.getName() + " " +
                    "packages for $" + amount.toPlainString() + " with the wallet belonging to " + walletOwnerName + "is on the way ***");
    }
}
