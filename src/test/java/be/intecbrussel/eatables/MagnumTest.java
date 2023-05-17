package be.intecbrussel.eatables;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MagnumTest {

    @Test
    void shouldReturnEqualsWhenEatMethodRuns() {

        Magnum magnum = new Magnum(Magnum.MagnumType.BLACK_CHOCOLATE);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        //before
        System.setOut(new PrintStream(outContent));

        //during
        magnum.eat();
        assertEquals("I'M EATING A MAGNUM FLAVOR BLACK_CHOCOLATE.",outContent.toString());

        //after
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnNotEqualsNullWhenUsingNoArgsConstructor() {

        Magnum magnum = new Magnum();


        assertNotEquals(null, magnum);
    }

    @Test
    void shouldReturnEqualsWhenMagnumTypesAreTheSame() {

        Magnum.MagnumType expectedType = Magnum.MagnumType.BLACK_CHOCOLATE;

        Magnum magnum = new Magnum(expectedType);

        Magnum.MagnumType actualType = magnum.getType();

        assertEquals(expectedType, actualType);

    }

}