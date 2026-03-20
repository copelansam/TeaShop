package edu.kennesaw.teashop.userinterface;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryBuilder;
import edu.kennesaw.teashop.userinterface.querybuilder.InventorySearchSession;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryOutputWriter;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

public class Application{

    private final Scanner scan = ScannerSingleton.getInstance();
    private final InventoryQueryBuilder queryBuilder;
    private final InventoryQueryOutputWriter outputWriter;
    private final Checkout checkout;

    public Application(InventoryQueryBuilder queryBuilder, InventoryQueryOutputWriter outputWriter){
        this.queryBuilder = queryBuilder;
        this.outputWriter = outputWriter;
        checkout = new Checkout();
    }


    public void run(){

        System.out.println("Welcome to My Tea Shop!");

        char userChoice = 'Y';

        // Let users select and purchase tea until they say to stop
        while (userChoice == 'Y') {

            System.out.println("\nComplete the prompts to search our selection of fine teas\n");


            // Build the query. Uses decorator chain to wrap it based on user choices
            InventorySearchSession querySession = queryBuilder.build();

            // Execute the queries and store the results
            List<QueriedInventoryItem> items = querySession.getQuery().getItems();

            // Store the items in the querySession
            querySession.setQueriedItems(items);

            // Send querySession to writer to be printed out
            outputWriter.writeOutputToScreen(querySession);

            checkout.startPurchase(items);

            System.out.print("Go again? (Y/N): ");
            userChoice = scan.nextLine().charAt(0);

        }

        System.out.println("end of program");
    }
}