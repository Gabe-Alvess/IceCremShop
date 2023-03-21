package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {
    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        double ballPrice = priceList.getBallPrice() * flavors.length;
        this.totalProfit += ballPrice * 0.25;
        return new Cone(flavors);
    }

    @Override
    public IceRocket orderIceRocket() {
        this.totalProfit += priceList.getRocketPrice() * 0.20;
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        this.totalProfit += priceList.getMagnumPrice(type) * 0.01;
        return new Magnum(type);
    }

    @Override
    public double getTotalProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "Ice Cream Salon" +
                "\nList of prices and flavors:" +
                "\nIce cream ball -> " + priceList.getBallPrice() + " cents" +
                "\nIce cream flavors: " +
                "\n1." + Cone.Flavor.CHOCOLATE.name().toLowerCase() +
                "\n2." + Cone.Flavor.STRACIATELLA.name().toLowerCase() +
                "\n3." + Cone.Flavor.VANILLA.name().toLowerCase() +
                "\n4." + Cone.Flavor.MOKKA.name().toLowerCase() +
                "\n5." + Cone.Flavor.STRAWBERRY.name().toLowerCase() +
                "\n6." + Cone.Flavor.LEMON.name().toLowerCase() +
                "\n7." + Cone.Flavor.BANANA.name().toLowerCase() +
                "\n8." + Cone.Flavor.PISTACHE.name().toLowerCase() +
                "\n\nIce rocket -> " + "$" +priceList.getRocketPrice() +
                "\n\nMagnums flavors and price: " +
                "\nMilk chocolate -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.MILK_CHOCOLATE) +
                "\nWhite chocolate -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.WHITE_CHOCOLATE) +
                "\nBlack chocolate -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.BLACK_CHOCOLATE) +
                "\nAlpine nuts -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.ALPINE_NUTS) +
                "\nRomantic strawberries -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.ROMANTIC_STRAWBERRIES) +
                "\n\nToday's total profit: " + String.format("%.2f", totalProfit);
    }
}
