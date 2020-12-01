package util;

import core.Permutation;
import core.PermutationSet;
import org.junit.Test;
import statistic.MahonianStatistic;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class StatisticUtilTest {

    @Test
    public void getDistributionTest_foze__() {
        System.out.println("DISTRIBUTION OF foze'' ON S_4(312)");
        PermutationSet ps = PermutationSet.getFactory().setSize(4).addAvoidAll("3*1*2").build();
        HashMap<Integer, ArrayList<Permutation>> dist = StatisticUtil.getDistribution(ps, MahonianStatistic.foze__, true);
        assertEquals(1, dist.get(0).size());
        assertEquals(3, dist.get(1).size());
        assertEquals(5, dist.get(2).size());
        assertEquals(4, dist.get(3).size());
        assertEquals(1, dist.get(4).size());
    }

    @Test
    public void getDistributionTest_inv() {
        System.out.println("DISTRIBUTION OF inv ON S_4(321)");
        PermutationSet ps = PermutationSet.getFactory().setSize(4).addAvoidAll("3*2*1").build();
        HashMap<Integer, ArrayList<Permutation>> dist = StatisticUtil.getDistribution(ps, MahonianStatistic.inv, true);
        assertEquals(1, dist.get(0).size());
        assertEquals(3, dist.get(1).size());
        assertEquals(5, dist.get(2).size());
        assertEquals(4, dist.get(3).size());
        assertEquals(1, dist.get(4).size());
    }

    @Test
    public void test() {
        System.out.println("DISTRIBUTION OF foze'' ON S_5(312)");
        PermutationSet ps = PermutationSet.getFactory().setSize(5).addAvoidAll("3*1*2").build();
        HashMap<Integer, ArrayList<Permutation>> dist = StatisticUtil.getDistribution(ps, MahonianStatistic.foze__, true);
        System.out.println("DISTRIBUTION OF inv ON S_5(321)");
        ps = PermutationSet.getFactory().setSize(5).addAvoidAll("3*2*1").build();
        StatisticUtil.getDistribution(ps, MahonianStatistic.inv, true);
    }
}