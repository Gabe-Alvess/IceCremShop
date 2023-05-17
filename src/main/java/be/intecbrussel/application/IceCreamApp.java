package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

import java.util.stream.Stream;

public class IceCreamApp {
    public static void main(String[] args) {
        PriceList priceList = new PriceList();
        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);

        Cone.Flavor[] myFlavors = new Cone.Flavor[] {Cone.Flavor.CHOCOLATE, Cone.Flavor.STRACIATELLA, Cone.Flavor.VANILLA};
        Magnum.MagnumType myMagnumType1 = Magnum.MagnumType.BLACK_CHOCOLATE;
        Magnum.MagnumType myMagnumType2 = Magnum.MagnumType.ALPINE_NUTS;

        Eatable[] iceCreamOrders = new Eatable[] {
                iceCreamSalon.orderIceRocket(),
                iceCreamSalon.orderMagnum(myMagnumType1),
                iceCreamSalon.orderMagnum(myMagnumType2),
                iceCreamSalon.orderCone(myFlavors)
        };

        Stream.of(iceCreamOrders).forEach(Eatable::eat);

        System.out.println("Ice cream salon profits: " + String.format("%.2f", iceCreamSalon.getTotalProfit()));
    }
}
