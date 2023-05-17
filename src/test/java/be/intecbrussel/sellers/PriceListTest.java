package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceListTest {

    private PriceList priceListDefault;

    private PriceList priceListCustom;

    @BeforeEach
    void setup() {
        priceListDefault = new PriceList();
        priceListCustom = new PriceList(1.0, 2.0, 4.0);
    }

    @Test
    void shouldReturnEqualsTheSameIceCreamPriceUsingGettersAndSetters() {

        priceListDefault.setBallPrice(2.0);
        priceListDefault.setRocketPrice(3.0);
        priceListDefault.setMagnumStandardPrice(5.0);

        assertAll(
                () -> assertEquals(2.0, priceListDefault.getBallPrice()),
                () -> assertEquals(3.0, priceListDefault.getRocketPrice()),
                () -> assertEquals(17.5, priceListDefault.getMagnumPrice(Magnum.MagnumType.BLACK_CHOCOLATE)),
                () -> assertEquals(11.0, priceListDefault.getMagnumPrice(Magnum.MagnumType.MILK_CHOCOLATE)),
                () -> assertEquals(7.5, priceListDefault.getMagnumPrice(Magnum.MagnumType.WHITE_CHOCOLATE)),
                () -> assertEquals(16.0, priceListDefault.getMagnumPrice(Magnum.MagnumType.ALPINE_NUTS)),
                () -> assertEquals(12.5, priceListDefault.getMagnumPrice(Magnum.MagnumType.ROMANTIC_STRAWBERRIES))
        );

    }

    @Test
    void shouldReturnEqualsTheSameIceCreamPriceUsingCustomPriceList() {

        assertAll(
                () -> assertEquals(1.0, priceListCustom.getBallPrice()),
                () -> assertEquals(2.0, priceListCustom.getRocketPrice()),
                () -> assertEquals(14.0, priceListCustom.getMagnumPrice(Magnum.MagnumType.BLACK_CHOCOLATE)),
                () -> assertEquals(8.8, priceListCustom.getMagnumPrice(Magnum.MagnumType.MILK_CHOCOLATE)),
                () -> assertEquals(6.0, priceListCustom.getMagnumPrice(Magnum.MagnumType.WHITE_CHOCOLATE)),
                () -> assertEquals(12.8, priceListCustom.getMagnumPrice(Magnum.MagnumType.ALPINE_NUTS)),
                () -> assertEquals(10.0, priceListCustom.getMagnumPrice(Magnum.MagnumType.ROMANTIC_STRAWBERRIES))
        );

    }

    @Test
    void shouldReturnEqualsTheSameStringInTheToStringMethod() {

        String expectedString = "PriceList -> Ball Price: 0.5 -> Rocket Price: 1.5 -> Magnum Price: 2.5";

        assertEquals(expectedString, priceListDefault.toString());
    }

}