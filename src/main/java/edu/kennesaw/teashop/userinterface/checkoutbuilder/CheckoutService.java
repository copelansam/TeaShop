package edu.kennesaw.teashop.userinterface.checkoutbuilder;

import edu.kennesaw.teashop.domain.checkout.PricingService;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.payment.PaymentContext;
import edu.kennesaw.teashop.domain.payment.PaymentOption;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CheckoutService {

    private CheckoutUI checkoutUi;
    private PricingService pricingService;

    public CheckoutService(){
        checkoutUi = new CheckoutUI();
        pricingService = new PricingService();
    }

    private final Scanner scan = ScannerSingleton.getInstance();

    // Orchestrates the checkout process by asking user what item, quantity, and payment option they want, then executes the payment process
    public void startPurchase(List<QueriedInventoryItem> items){

        // User selects item they want to buy
        int itemToPurchaseIndex = checkoutUi.promptForItemToPurchase(items);
        if (itemToPurchaseIndex == 0) return; // if the user doesn't want to purchase an item, skip the checkout process & return to application

        // User selects quantity they want to buy
        QueriedInventoryItem itemToPurchase = items.get(itemToPurchaseIndex);
        int quantityToPurchase = checkoutUi.promptForQuantityToPurchase(itemToPurchase);

        // Calculates the total price
        BigDecimal amount = pricingService.getOrderTotal(itemToPurchase,quantityToPurchase);
        System.out.println("*** Total Price: $" + amount.toPlainString());

        // Prompts the user for a payment option
        PaymentOption paymentOption = checkoutUi.promptForPaymentOption();

        // Store user's choices to determine which payment type to use when paying
        PaymentContext paymentContext = new PaymentContext(paymentOption, amount);



    }

}
