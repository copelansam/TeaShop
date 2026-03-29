package edu.kennesaw.teashop.userinterface;

import edu.kennesaw.teashop.domain.inventory.InventoryService;
import edu.kennesaw.teashop.domain.inventoryquery.InventoryQueryService;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.checkout.CheckoutService;
import edu.kennesaw.teashop.domain.inventoryquery.InventorySearchSession;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryOutputWriter;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

public class Application{

    private final Scanner scan = ScannerSingleton.getInstance();
    private final InventoryQueryOutputWriter outputWriter;
    private final CheckoutService checkout;
    private final InventoryService inventoryService;
    private final InventoryQueryService queryService;

    public Application(InventoryQueryOutputWriter outputWriter, InventoryService inventoryService, InventoryQueryService queryService){
        this.inventoryService =inventoryService;
        this.outputWriter = outputWriter;
        this.queryService = queryService;
        checkout = new CheckoutService(inventoryService);
    }


    public void run(){

        System.out.println("Welcome to My Tea Shop!");

        char userChoice = 'Y';

        // Let users select and purchase tea until they say to stop
        while (userChoice == 'Y') {

            System.out.println("\nComplete the prompts to search our selection of fine teas\n");


            // Builds the query and stores what choices the user makes
            InventorySearchSession querySession = queryService.buildQuery();

            // Execute the queries and store the results
            List<QueriedInventoryItem> items = queryService.executeQuery(querySession);

            // Send querySession to writer to print out the filters and sorts applied and what items were found
            outputWriter.writeOutputToScreen(querySession);

            // Begin the checkout process
            checkout.startPurchase(items);

            System.out.print("Go again? (Y/N): ");
            userChoice = scan.nextLine().charAt(0);

        }

        System.out.println("End of Program. Thanks for Playing");
    }
}