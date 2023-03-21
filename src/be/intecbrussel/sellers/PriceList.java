package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
        this.ballPrice = 0.5;
        this.rocketPrice = 1.5;
        this.magnumStandardPrice = 2.5;
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType type) {
        double magnumPrice = 0;

        switch (type) {
            case WHITE_CHOCOLATE -> magnumPrice = magnumStandardPrice * 1.5;
            case MILK_CHOCOLATE -> magnumPrice = magnumStandardPrice * 2.2;
            case ROMANTIC_STRAWBERRIES -> magnumPrice = magnumStandardPrice * 2.5;
            case ALPINE_NUTS -> magnumPrice = magnumStandardPrice * 3.2;
            case BLACK_CHOCOLATE -> magnumPrice = magnumStandardPrice * 3.5;
        }
        return magnumPrice;
    }
}
