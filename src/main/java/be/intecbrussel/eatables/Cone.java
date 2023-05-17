package be.intecbrussel.eatables;

import java.util.Arrays;
import java.util.stream.Stream;

public class Cone implements Eatable {
    private Flavor[] balls;

    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        System.out.print("I'M EATING AN ICE CREAM WITH THE FLAVORS ");
        Stream.of(balls).forEach(flavor ->  System.out.print(flavor + ", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cone cone)) return false;
        return Arrays.equals(balls, cone.balls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(balls);
    }

    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;
    }
}
