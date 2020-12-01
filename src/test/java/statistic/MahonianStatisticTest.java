package statistic;

import core.Permutation;
import org.junit.Test;

import static org.junit.Assert.*;

public class MahonianStatisticTest {
    @Test
    public void testInv() {
        Permutation p = new Permutation("456123");
        assertEquals(9, MahonianStatistic.inv.get(p));
    }

    @Test
    public void testMaj() {
        Permutation p = new Permutation("456123");
        assertEquals(3, MahonianStatistic.maj.get(p));
    }

    @Test
    public void testFoze__() {
        Permutation p = new Permutation("2143");
        assertEquals(2, MahonianStatistic.foze__.get(p));
    }
}