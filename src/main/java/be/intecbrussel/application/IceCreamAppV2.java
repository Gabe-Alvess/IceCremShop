package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

import java.util.Objects;
import java.util.stream.Stream;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        PriceList priceList = new PriceList();
        Stock stock = new Stock();
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);

        Cone.Flavor[] myFlavors = new Cone.Flavor[] {Cone.Flavor.CHOCOLATE, Cone.Flavor.STRACIATELLA, Cone.Flavor.VANILLA};
        Magnum.MagnumType myMagnumType1 = Magnum.MagnumType.BLACK_CHOCOLATE;
        Magnum.MagnumType myMagnumType2 = Magnum.MagnumType.ALPINE_NUTS;

        Eatable[] iceCreamOrders = new Eatable[] {
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderMagnum(myMagnumType2),
                iceCreamCar.orderMagnum(myMagnumType1),
                iceCreamCar.orderCone(myFlavors),
        };

        Stream.of(iceCreamOrders)
                .filter(Objects::nonNull)
                .forEach(Eatable::eat);

        System.out.println("Ice cream salon profits: " + String.format("%.2f", iceCreamCar.getTotalProfit()));
    }
}
