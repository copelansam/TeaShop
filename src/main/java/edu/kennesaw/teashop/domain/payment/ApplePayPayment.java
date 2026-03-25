package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;

public class ApplePayPayment extends PaymentStrategyBase {

    public ApplePayPayment(BigDecimal amount, int quantityToPurchase){
        super(amount, quantityToPurchase);
    }

    public void pay(QueriedInventoryItem item){
            System.out.println("*** Purchase complete. Your" +  quantityToPurchase + " " + item.getName() + " packages for $" + amount.toPlainString() + "is on the way ***");    }
}
