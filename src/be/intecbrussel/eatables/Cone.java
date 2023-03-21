package be.intecbrussel.eatables;

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
        System.out.print("HUUUUM, I'M EATING AN ICE CREAM WITH THE FLAVORS ");
        Stream.of(balls).forEach(flavor ->  System.out.print(flavor + ", "));
        System.out.println();
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
