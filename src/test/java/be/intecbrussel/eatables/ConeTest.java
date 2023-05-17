package be.intecbrussel.eatables;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ConeTest {
    @Test
    void shouldReturnEqualsWhenEatMethodRuns() {

        Cone cone = new Cone(new Cone.Flavor[]{Cone.Flavor.MOKKA, Cone.Flavor.CHOCOLATE});

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        //before
        System.setOut(new PrintStream(outContent));

        //during
        cone.eat();
        assertEquals("I'M EATING AN ICE CREAM WITH THE FLAVORS MOKKA, CHOCOLATE, ",outContent.toString());

        //after
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnNotEqualsNullWhenUsingNoArgsConstructor() {

        Cone cone = new Cone();


        assertNotEquals(null, cone );
    }
}