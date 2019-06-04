package topcoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModEncoderTest {

    ModEncoder modEncoder = new ModEncoder();

    @Test
    void test0() {
        String actual = modEncoder.encoder("THIS CODED MESSAGE");
        assertEquals("THIS~\n" +
                "CODED\n" +
                "~MESS\n" +
                "AGE~~", actual);
    }

}