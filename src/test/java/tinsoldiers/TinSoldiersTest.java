package tinsoldiers;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class TinSoldiersTest {

    private TinSoldiers tinSoldiers = new TinSoldiers();

    @Test
    void testReverse() {
        assertEquals("cba",  tinSoldiers.reverse("abc"));
        assertEquals("arg", tinSoldiers.reverse("gra"));
        assertEquals("aee", tinSoldiers.reverse("eea"));
    }

    @Test
    void test0() {
        int[] in = {2, 2, 1};
        assertEquals(16, tinSoldiers.lineUps(in));
    }

    @Test
    void test5() {
        int[] in = {4, 2, 2, 5, 4};
        assertEquals(643245120, tinSoldiers.lineUps(in));
    }
}