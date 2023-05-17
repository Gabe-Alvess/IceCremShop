package be.intecbrussel.eatables;

import java.util.Objects;

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
        System.out.print("I'M EATING A MAGNUM FLAVOR " + type + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magnum magnum)) return false;
        return type == magnum.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public enum MagnumType {
        MILK_CHOCOLATE,
        WHITE_CHOCOLATE,
        BLACK_CHOCOLATE,
        ALPINE_NUTS,
        ROMANTIC_STRAWBERRIES;
    }
}
