package edu.kennesaw.teashop.domain.inventory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarRatingTest {

    @Test
    public void testStarRatingConstructorInvariants(){

        // Check that the constructor throws an IllegalArgumentException when a new rating is created that isn't between 1 and 5
        assertThrows(IllegalArgumentException.class, () -> new StarRating(7));
        assertThrows(IllegalArgumentException.class, () -> new StarRating(0));

        // Check that the constructor does not throw an exception when a rating is created with a valid input
        assertDoesNotThrow(() -> new StarRating(3));
    }

}