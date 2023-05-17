package be.intecbrussel.sellers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    private Stock defaultStock;
    private Stock customStock;
    @BeforeEach
    void setup() {
        defaultStock = new Stock();
        customStock = new Stock(2,2,2,2);
    }

    @Test
    void shouldReturnEqualsTheSameStockUsingGettersAndSetters() {

        defaultStock.setBalls(3);
        defaultStock.setCones(7);
        defaultStock.setIceRockets(5);
        defaultStock.setMagni(1);

        assertAll(
                () -> assertEquals(3, defaultStock.getBalls()),
                () -> assertEquals(7, defaultStock.getCones()),
                () -> assertEquals(5, defaultStock.getIceRockets()),
                () -> assertEquals(1, defaultStock.getMagni())
        );

    }

    @Test
    void shouldReturnEqualsTheSameStockUsingCustomStock() {

        assertAll(
                () -> assertEquals(2, customStock.getBalls()),
                () -> assertEquals(2, customStock.getCones()),
                () -> assertEquals(2, customStock.getIceRockets()),
                () -> assertEquals(2, customStock.getMagni())
        );

    }

    @Test
    void shouldReturnEqualsTheSameStringInTheToStringMethod() {

        String expectedString = "Stock -> Ice Rockets: 5 -> Cones: 5 -> Balls: 5 -> Magnum: 5";

        assertEquals(expectedString, defaultStock.toString());
    }

}