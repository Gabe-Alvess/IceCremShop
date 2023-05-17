package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamCarTest {
    private IceCreamCar iceCreamCar;
    private IceCreamCar iceCreamCarNoStock;

    @BeforeEach
    void setup() {
        iceCreamCar = new IceCreamCar(new PriceList(), new Stock());
        iceCreamCarNoStock = new IceCreamCar(new PriceList(), new Stock(0, 0, 0, 0));
    }

    @Test
    void shouldReturnEqualsConeWhenOrderConeRuns() {

        Cone cone = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE});

        Cone expectedCone = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE});

        assertAll(
                () -> assertEquals(expectedCone, cone),
                () -> assertEquals(expectedCone.hashCode(), cone.hashCode())
        );
    }

    @Test
    void shouldReturnNullIfOutOfStockWhenOrderConeRuns() {

        Cone cone = iceCreamCarNoStock.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE});

        assertNull(cone);
    }

    @Test
    void shouldReturnIceRocketWhenOrderIceRocketRuns() {

        IceRocket iceRocket = iceCreamCar.orderIceRocket();

        assertNotNull(iceRocket);

    }

    @Test
    void shouldReturnNullIfOutOfStockWhenOrderIceRocketRuns() {


        IceRocket iceRocket = iceCreamCarNoStock.orderIceRocket();

        assertNull(iceRocket);

    }

    @Test
    void shouldReturnEqualsMagnumWhenOrderMagnumRuns() {

        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACK_CHOCOLATE);

        Magnum expectedMagnum = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACK_CHOCOLATE);

        assertAll(
                () -> assertEquals(expectedMagnum, magnum),
                () -> assertEquals(expectedMagnum.hashCode(), magnum.hashCode())
        );
    }

    @Test
    void shouldReturnNullIfOutOfStockWhenOrderMagnumRuns() {

        Magnum magnum = iceCreamCarNoStock.orderMagnum(Magnum.MagnumType.BLACK_CHOCOLATE);

        assertNull(magnum);
    }

    @Test
    void shouldReturnEqualsTheTotalProfitValueWhenGetTotalProfitRuns() {

        iceCreamCar.orderIceRocket();
        iceCreamCar.orderIceRocket();

        double actualProfit = iceCreamCar.getTotalProfit();

        assertEquals(0.6, (double) Math.round(actualProfit * 100) / 100);

    }

    @Test
    void shouldReturnEqualsTheSameStringInTheToStringMethod() {

        String expectedString =
                "IceCreamCar -> PriceList -> Ball Price: 0.5 -> Rocket Price: 1.5 -> Magnum Price: 2.5 -> " +
                        "Stock -> Ice Rockets: 5 -> Cones: 5 -> Balls: 5 -> Magnum: 5 -> Total Profit: 0.0";

        assertEquals(expectedString, iceCreamCar.toString());
    }
}