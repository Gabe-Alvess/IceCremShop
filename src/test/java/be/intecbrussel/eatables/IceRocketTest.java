package be.intecbrussel.eatables;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IceRocketTest {

    @Test
    void shouldReturnEqualsWhenEatMethodRuns() {

        IceRocket iceRocket = new IceRocket();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        //before
        System.setOut(new PrintStream(outContent));

        //during
        iceRocket.eat();
        assertEquals("I'M EATING AN ICE ROCKET.",outContent.toString());

        //after
        System.setOut(originalOut);
    }

}