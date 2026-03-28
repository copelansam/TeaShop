package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryQueryTests {



    @Test
    public void testAlLItemsQueryReturnsAllItems() {

        InventoryRepository testRepository = new InventoryRepository();
        AllInventoryQuery allItemsTest = new AllInventoryQuery(testRepository);

        assertEquals(testRepository.getAllItems().size(), allItemsTest.getItems().size());
    }
}
