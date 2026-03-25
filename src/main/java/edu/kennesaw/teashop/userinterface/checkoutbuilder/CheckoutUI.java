package edu.kennesaw.teashop.userinterface.checkoutbuilder;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.payment.PaymentOption;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CheckoutUI {

    Scanner scan = ScannerSingleton.getInstance();

    public int promptForItemToPurchase(List<QueriedInventoryItem> items){
        int userPurchase;

        while (true) {

            try {
                System.out.print("Purchase an item? Enter a number between  1 and " + items.size()
                        + " to select an item or press 0 to skip checkout and continue (default): ");
                userPurchase = scan.nextInt();
                scan.nextLine();

                if (userPurchase < 0 || userPurchase > items.size()){
                    // If the user inputs a number outside of the range of 0 - number of items returned, have them try again
                    System.out.println("Please enter a number between 0 and " + items.size() + ".");
                    continue;
                }
                else if (userPurchase == 0){ // If the user doesn't want to purchase anything,
                    // then skip the checkout process and return to the application flow
                    return -1;
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

    public int promptForQuantityToPurchase(QueriedInventoryItem item){

        while (true) {

            try {

                System.out.print("Quantity for \"" + item.getName() + "\" (1 - " + item.getAvailableQuantity() + "): ");
                int quantityToBuy = scan.nextInt();

                if (quantityToBuy < 1 || quantityToBuy > item.getAvailableQuantity()){
                    throw new Exception();
                }

                return quantityToBuy;
            }
            catch(Exception e){
                System.out.println("Enter a number between 1 and " + item.getAvailableQuantity());
            }
        }
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
                    scan.nextLine();
                    continue;
                }

                scan.nextLine();
                break;
            }
            catch(Exception e){ // Handle cases where the user does not put in a number
                System.out.println("Please enter a number between 1 and " + paymentOptions.size() + " to select a payment option");
                scan.nextLine();
            }
        }

        System.out.println("You chose: " + paymentOptions.get(paymentSelection - 1).getDisplayString());
        return paymentOptions.get(paymentSelection - 1); // Subtract 1 because lists are 0 indexed
    }
}
