package edu.kennesaw.teashop.domain.checkout;

import edu.kennesaw.teashop.domain.inventory.InventoryService;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.payment.IPaymentStrategy;
import edu.kennesaw.teashop.domain.payment.PaymentContext;
import edu.kennesaw.teashop.domain.payment.PaymentOption;
import edu.kennesaw.teashop.domain.payment.PaymentStrategyFactory;
import edu.kennesaw.teashop.userinterface.checkoutbuilder.CheckoutUI;
import edu.kennesaw.teashop.userinterface.paymentbuilder.IPaymentBuilder;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {

    private InventoryService inventoryService;
    private CheckoutUI checkoutUi;
    private TotalPriceCalculator totalPriceCalculator;
    private PaymentStrategyFactory paymentStrategyFactory;

    public CheckoutService(InventoryService inventoryService){
        this.inventoryService = inventoryService;
        checkoutUi = new CheckoutUI();
        totalPriceCalculator = new TotalPriceCalculator();
        paymentStrategyFactory = new PaymentStrategyFactory();
    }

    // Orchestrates the checkout process by asking user what item, quantity, and payment option they want, then executes the payment process
    public void startPurchase(List<QueriedInventoryItem> items){

        if (items.size() == 0){ // If the query did not return any items, return early, user cannot purchase anything
            System.out.println("Unfortunately, your query did not return any items. There are no items for you to purchase");
            return;
        }
        else if (items.getFirst().getAvailableQuantity() == 0){
            // If the user selected to display only out of stock items, then return early and don't let them purchase anything

            System.out.println("Unfortunately none of the items that you have queried are in stock.");
            return;
        }

        // User selects item they want to buy
        int itemToPurchaseIndex = checkoutUi.promptForItemToPurchase(items);
        if (itemToPurchaseIndex == - 1) return; // if the user doesn't want to purchase an item, skip the checkout process & return to application

        // User selects quantity they want to buy
        QueriedInventoryItem itemToPurchase = items.get(itemToPurchaseIndex);
        int quantityToPurchase = checkoutUi.promptForQuantityToPurchase(itemToPurchase);

        // Calculates the total price
        BigDecimal amount = totalPriceCalculator.getOrderTotal(itemToPurchase,quantityToPurchase);
        System.out.println("*** Total Price: $" + amount.toPlainString());

        // Prompts the user for a payment option
        PaymentOption paymentOption = checkoutUi.promptForPaymentOption();

        // Store user's choices to determine which payment type to use when paying
        PaymentContext paymentContext = new PaymentContext(paymentOption, amount, quantityToPurchase);

        // Create a payment builder based on the users input and relevant context (total, quantity)
        // then execute its pay method and update the quantity of the purchased item.
        IPaymentBuilder paymentBuilder = paymentStrategyFactory.createPaymentBuilder(paymentContext.getPaymentType());
        paymentBuilder.collectInfo();

        // Build a payment strategy based on the builder returned by the factory
        IPaymentStrategy paymentStrategy = paymentBuilder.buildPayment(amount, quantityToPurchase);

        // Execute the payment
        paymentStrategy.pay(itemToPurchase);

        // Update the purchased item's available quantity
        updateInventoryAfterPurchase(itemToPurchase, quantityToPurchase);

    }

    // Update the purchased item's available quantity
    public void updateInventoryAfterPurchase(QueriedInventoryItem item, int quantity){
        inventoryService.updateQuantity(item.getUuid(), quantity * -1); // Multiply by negative 1 to subtract inventory

    }

}
