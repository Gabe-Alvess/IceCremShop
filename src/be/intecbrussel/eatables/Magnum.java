package be.intecbrussel.eatables;

public class Magnum implements Eatable {
    private MagnumType type;

    public Magnum() {
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {
        System.out.println("HUUUUM, I'M EATING A MAGNUM FLAVOR " + type + ".");
    }

    public enum MagnumType {
        MILK_CHOCOLATE,
        WHITE_CHOCOLATE,
        BLACK_CHOCOLATE,
        ALPINE_NUTS,
        ROMANTIC_STRAWBERRIES;
    }
}
