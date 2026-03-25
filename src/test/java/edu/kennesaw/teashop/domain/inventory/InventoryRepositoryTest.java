package edu.kennesaw.teashop.domain.inventory;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    InventoryRepository repository = new InventoryRepository();

    // Tests when the repository is seeded, the correct amount of objects are added to the repository
    @Test
    public void testInventorySeederSeedsDataCorrectly() {
        assertEquals(12, repository.getAllItems().size());
    }

    // Tests the update inventory function by testing how it handles addition, subtraction, and nothing (0)
    @Test
    public void testInventoryAvailabilityUpdate(){

        InventoryItem testItem = repository.getAllItems().getFirst();
        UUID testId = testItem.getUuid();

        // Test subtraction
        repository.updateQuantity(testId, -6);
        assertEquals(44,testItem.getAvailableQuantity());

        // Test no action
        repository.updateQuantity(testId, 0);
        assertEquals(44, testItem.getAvailableQuantity());

        // Test addition
        repository.updateQuantity(testId, 10);
        assertEquals(54,testItem.getAvailableQuantity());
    }

    // Tests the getItemById method, make sure it passes when passing an ID in the repository and fails when you pass one that isn't
    @Test
    public void testGetItemById(){

        InventoryItem testItem = repository.getAllItems().getFirst();
        UUID testId = testItem.getUuid();

        // Tests by looking for an item that is in the repository
        assertEquals(testItem, repository.getItemById(testId));

        // Tests by looking for a random ID that is extremely likely to not be in the repository
        assertNotEquals(testItem, repository.getItemById(UUID.randomUUID()));
    }
}