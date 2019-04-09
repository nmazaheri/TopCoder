package medaltable;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class MedalTableTest {

    MedalTable medalTable = new MedalTable();

    @Test
    void test0() {
        String[] input = {"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};
        String[] expected = {
                "KOR 3 1 0",
                "ITA 1 0 0",
                "TPE 0 1 1",
                "CHN 0 1 0",
                "JPN 0 1 0",
                "AUS 0 0 1",
                "GBR 0 0 1",
                "UKR 0 0 1"
        };
        assertArrayEquals(expected, medalTable.generate(input));
    }

    @Test
    void test1() {
        String[] input = {"USA AUT ROM"};
        String[] expected = {"USA 1 0 0", "AUT 0 1 0", "ROM 0 0 1"};
        assertArrayEquals(expected,  medalTable.generate(input));
    }

    @Test
    void test2() {
        String[] input = {"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"};
        String[] expected = {"AUT 1 1 1", "GER 1 1 1", "SUI 1 1 1"};
        assertArrayEquals(expected, medalTable.generate(input));
    }
}