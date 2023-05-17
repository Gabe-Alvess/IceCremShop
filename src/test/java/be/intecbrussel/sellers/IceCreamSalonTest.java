package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamSalonTest {

    private IceCreamSalon iceCreamSalon;

    @BeforeEach
    void setup() {
        iceCreamSalon = new IceCreamSalon(new PriceList());
    }

    @Test
    void shouldReturnEqualsTheSameObjectWhenOrderConeRuns() {

        Cone cone = iceCreamSalon.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE});

        Cone expectedCone = iceCreamSalon.orderCone(new Cone.Flavor[]{Cone.Flavor.CHOCOLATE});

        assertAll(
                () -> assertEquals(expectedCone, cone),
                () -> assertEquals(expectedCone.hashCode(), cone.hashCode())
        );
    }

    @Test
    void shouldReturnIceRocketWhenOrderIceRocketRuns() {

        IceRocket iceRocket = iceCreamSalon.orderIceRocket();

        assertNotNull(iceRocket);

    }

    @Test
    void shouldReturnEqualsMagnumWhenOrderMagnumRuns() {

        Magnum magnum = iceCreamSalon.orderMagnum(Magnum.MagnumType.BLACK_CHOCOLATE);

        Magnum expectedMagnum = iceCreamSalon.orderMagnum(Magnum.MagnumType.BLACK_CHOCOLATE);

        assertAll(
                () -> assertEquals(expectedMagnum, magnum),
                () -> assertEquals(expectedMagnum.hashCode(), magnum.hashCode())
        );
    }

    @Test
    void shouldReturnEqualsTheTotalProfitValueWhenGetTotalProfitRuns() {

        iceCreamSalon.orderIceRocket();
        iceCreamSalon.orderIceRocket();

        double actualProfit = iceCreamSalon.getTotalProfit();

        assertEquals(0.6, (double) Math.round(actualProfit * 100) / 100);

    }

    @Test
    void shouldReturnEqualsTheSameStringInTheToStringMethod() {

        String expectedString = "IceCreamSalon -> PriceList -> Ball Price: 0.5 -> Rocket Price: 1.5 -> Magnum Price: 2.5 -> Total Profit: 0.0";

        assertEquals(expectedString, iceCreamSalon.toString());
    }
}