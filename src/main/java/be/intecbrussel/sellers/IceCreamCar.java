package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;


public class IceCreamCar implements IceCreamSeller {
    private PriceList priceList;
    private Stock stock;
    private double totalProfit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone cone = prepareCone(flavors);

        double ballPrice = priceList.getBallPrice() * flavors.length;

        if (cone != null) {
            this.totalProfit += ballPrice * 0.25;
        }
        return cone;
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {
        int cones = stock.getCones();
        int balls = stock.getBalls();

        if (cones > 0 && balls >= flavors.length) {
            stock.setCones(cones - 1);
            stock.setBalls(balls - flavors.length);
            return new Cone(flavors);
        } else {
            System.out.println("NO MORE CONES OR ICE CREAM!");
            return null;
        }
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = prepareIceRocket();

        if (iceRocket != null) {
            this.totalProfit += priceList.getRocketPrice() * 0.20;
        }
        return iceRocket;
    }

    private IceRocket prepareIceRocket() {
        int iceRockets = stock.getIceRockets();

        if (iceRockets > 0) {
            stock.setIceRockets(iceRockets - 1);
            return new IceRocket();
        } else {
            System.out.println("NO MORE ICE ROCKETS!");
            return null;
        }
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = prepareMagnum(type);

        if (magnum != null) {
            this.totalProfit += priceList.getMagnumPrice(type) * 0.01;
        }
        return magnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        int magnums = stock.getMagni();

        if (magnums > 0) {
            stock.setMagni(magnums - 1);
            return new Magnum(type);
        } else {
            System.out.println("NO MORE MAGNUMS!");
            return null;
        }
    }

    @Override
    public double getTotalProfit() {
        return totalProfit;
    }

//    @Override
//    public String toString() {
//        return "Ice Cream Car" +
//                "\nList of prices, flavors and stock:" +
//                "\n\nIce cream ball -> " + priceList.getBallPrice() + " cents" +
//                "\nStock -> " + stock.getBalls() + " ice cream balls and " + stock.getCones() + " cones" +
//                "\nIce cream flavors: " +
//                "\n1." + Cone.Flavor.CHOCOLATE.name().toLowerCase() +
//                "\n2." + Cone.Flavor.STRACIATELLA.name().toLowerCase() +
//                "\n3." + Cone.Flavor.VANILLA.name().toLowerCase() +
//                "\n4." + Cone.Flavor.MOKKA.name().toLowerCase() +
//                "\n5." + Cone.Flavor.STRAWBERRY.name().toLowerCase() +
//                "\n6." + Cone.Flavor.LEMON.name().toLowerCase() +
//                "\n7." + Cone.Flavor.BANANA.name().toLowerCase() +
//                "\n8." + Cone.Flavor.PISTACHE.name().toLowerCase() +
//                "\n\nIce rocket -> " + "$" +priceList.getRocketPrice() +
//                "\nStock: " + stock.getIceRockets() + " ice rockets" +
//                "\n\nMagnums flavors and price: " +
//                "\nStock: " + stock.getMagni() + " magnums (1 of each)" +
//                "\nMilk chocolate -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.MILK_CHOCOLATE) +
//                "\nWhite chocolate -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.WHITE_CHOCOLATE) +
//                "\nBlack chocolate -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.BLACK_CHOCOLATE) +
//                "\nAlpine nuts -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.ALPINE_NUTS) +
//                "\nRomantic strawberries -> " + "$" + priceList.getMagnumPrice(Magnum.MagnumType.ROMANTIC_STRAWBERRIES) +
//                "\n\nToday's total profit: " + String.format("%.2f", totalProfit);
//    } Te Complex om te gaan testen hahahaha


    @Override
    public String toString() {
        return "IceCreamCar -> " +
                priceList +
                " -> " + stock +
                " -> Total Profit: " + totalProfit;
    }
}
