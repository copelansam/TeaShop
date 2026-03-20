package edu.kennesaw.teashop.userinterface;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.payment.PaymentOption;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Checkout {

    private final Scanner scan = ScannerSingleton.getInstance();

    public void startPurchase(List<QueriedInventoryItem> items){

        // User selects item they want to buy
        int itemToPurchaseIndex = promptForItem(items);
        if (itemToPurchaseIndex == 0) return; // if the user doesn't want to purchase an item, skip the checkout process & return to application

        // User selects quantity they want to buy
        QueriedInventoryItem itemToPurchase = items.get(itemToPurchaseIndex);
        int quantityToPurchase = promptForQuantity(itemToPurchase);

        BigDecimal amount = new BigDecimal(itemToPurchase.getPrice().doubleValue() * quantityToPurchase).setScale(2, RoundingMode.HALF_UP);
        System.out.println("*** Total Price: $" + amount.toPlainString());

        PaymentOption paymentOption = promptForPaymentOption();

    }

    public int promptForItem(List<QueriedInventoryItem> items){

        int userPurchase;

        while (true) {

            try {
                System.out.print("Purchase an item? Enter item number 1-" + items.size()
                        + " to purchase an item or press 0 to skip checkout and continue (default): ");
                userPurchase = scan.nextInt();
                scan.nextLine();

                if (userPurchase < 0 || userPurchase > items.size()){
                    // If the user inputs a number outside of the range of 0 - number of items returned, have them try again
                    System.out.println("Please enter a number between 0 and " + items.size() + ".");
                    continue;
                }
                else if (userPurchase == 0){ // If the user doesn't want to purchase anything,
                    // then skip the checkout process and return to the application flow
                    return 0;
                }

                break;
            }
            catch (InputMismatchException e){ // If the user doesn't enter a number, handle it then have them try again
                System.out.println("Please enter a number between 1-" + items.size() +
                        " to purchase an item or press 0 to skip checkout and continue (default): ");
                scan.nextLine();
            }
        }

        return (userPurchase - 1); // subtract 1 to make it ready for accessing 0 indexed collections
    }

    public int promptForQuantity(QueriedInventoryItem item){

        System.out.print("Quantity for \"" + item.getName() + "\" (1- " + item.getAvailableQuantity() + "): ");
        int quantityToBuy = scan.nextInt();

        return quantityToBuy;
    }

    public PaymentOption promptForPaymentOption(){
        System.out.println("*** Please select a payment option:");

        List<PaymentOption> paymentOptions = List.of(PaymentOption.values());

        int counter = 1;
        for (PaymentOption option : paymentOptions){
            System.out.println(counter + ". " + option.getDisplayString());
            counter++;
        }

        int paymentSelection;

        while (true) {

            try {

                System.out.print("Selection: ");
                paymentSelection = scan.nextInt();

                if (paymentSelection < 0 || paymentSelection >=paymentOptions.size()){
                    // If the user doesn't put a value between the range of payment options, tell them to try again
                    System.out.println("Please enter a number between 1 and " + paymentOptions.size() + " to select a payment option");
                    continue;
                }

                scan.nextLine();
                break;
            }
            catch(Exception e){ // Handle cases where the user does not put in a number
                System.out.println("Please enter a number between 1 and " + paymentOptions.size() + " to select a payment option");
            }
        }

        System.out.println("You chose: " + paymentOptions.get(paymentSelection - 1).getDisplayString());
        return paymentOptions.get(paymentSelection - 1); // Subtract 1 because lists are 0 indexed
    }



}
