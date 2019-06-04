package topcoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadBalancingTest {

    LoadBalancing loadBalancing = new LoadBalancing();

    @Test
    void test0() {
        int[] in = {3072, 3072, 7168, 3072, 1024};
        assertEquals(9216, loadBalancing.minTime(in));
    }

    @Test
    void secretTest() {
        int[] in =  {3, 3, 7, 3, 1};
        assertEquals(9, loadBalancing.minTimeDP2(in));
    }

    @Test
    void test1() {
        int[] in = {2048};
        assertEquals(2048, loadBalancing.minTime(in));
    }

    @Test
    void test2() {
        int[] in = {2048, 1024, 1024, 2048};
        assertEquals(3072, loadBalancing.minTime(in));
    }

    @Test
    void test3() {
        int[] in = {4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304};
        assertEquals(104857600, loadBalancing.minTime(in));
    }

}