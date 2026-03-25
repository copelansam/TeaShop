package edu.kennesaw.teashop.userinterface.checkoutbuilder;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.payment.PaymentContext;
import edu.kennesaw.teashop.domain.payment.PaymentOption;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class CheckoutService {

    CheckoutUI checkoutUi;

    public CheckoutService(){
        checkoutUi = new CheckoutUI();
    }

    private final Scanner scan = ScannerSingleton.getInstance();

    // Will ask users what item and quantity they want to purchase, then executes the payment process
    public void startPurchase(List<QueriedInventoryItem> items){

        // User selects item they want to buy
        int itemToPurchaseIndex = checkoutUi.promptForItemToPurchase(items);
        if (itemToPurchaseIndex == 0) return; // if the user doesn't want to purchase an item, skip the checkout process & return to application

        // User selects quantity they want to buy
        QueriedInventoryItem itemToPurchase = items.get(itemToPurchaseIndex);
        int quantityToPurchase = checkoutUi.promptForQuantityToPurchase(itemToPurchase);

        BigDecimal amount = new BigDecimal(itemToPurchase.getPrice().doubleValue() * quantityToPurchase).setScale(2, RoundingMode.HALF_UP);
        System.out.println("*** Total Price: $" + amount.toPlainString());

        PaymentOption paymentOption = checkoutUi.promptForPaymentOption();

        // Store user's choices to determine which payment type to use when paying
        PaymentContext paymentContext = new PaymentContext(paymentOption, amount);

    }

}
