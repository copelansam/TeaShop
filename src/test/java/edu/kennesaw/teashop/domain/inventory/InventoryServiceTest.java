package edu.kennesaw.teashop.domain.inventory;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private InventoryRepository testRepository = new InventoryRepository();
    private InventoryService testService = new InventoryService(testRepository);
    private InventoryItem testItem = new InventoryItem(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), "testItem", new BigDecimal(14.75), 15, new StarRating(4));


    // Tests that the addNewItem method works and adds the new item
    @Test
    public void testAddNewItem(){

        // Test that if the item has not been added, then searching for it returns null
        assertNull(testRepository.getItemById(UUID.fromString("550e8400-e29b-41d4-a716-446655440000")));

        // Test that the item was added by checking that the search method does not return null
        testService.addNewItem(testItem);
        assertNotNull(testRepository.getItemById(UUID.fromString("550e8400-e29b-41d4-a716-446655440000")));

    }

    // Tests that the updateQuantity method works
    @Test
    public void testUpdateQuantity(){

        testService.addNewItem(testItem);

        // Tests the update quantity method when subtracting inventory
        testService.updateQuantity(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), -5);
        assertEquals(10,testRepository.getItemById(UUID.fromString("550e8400-e29b-41d4-a716-446655440000")).getAvailableQuantity());

        // Tests the update quantity method when adding inventory
        testService.updateQuantity(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), 15);
        assertEquals(25, testRepository.getItemById(UUID.fromString("550e8400-e29b-41d4-a716-446655440000")).getAvailableQuantity());

    }

}