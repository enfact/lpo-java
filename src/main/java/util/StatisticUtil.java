package util;

import com.jakewharton.fliptables.FlipTableConverters;
import core.Permutation;
import core.PermutationSet;
import pattern.VincularPattern;
import statistic.IStatistic;

import java.util.ArrayList;
import java.util.HashMap;

public class StatisticUtil {
    public static HashMap<Integer, ArrayList<Permutation>> getDistribution(PermutationSet ps, IStatistic stat, boolean print) {
        HashMap<Integer, ArrayList<Permutation>> map = new HashMap<>();
        for (Permutation p : ps) {
            int x = stat.get(p);
            if (!map.containsKey(x)) map.put(x, new ArrayList<>());
            map.get(x).add(p);
        }
        if (!print) return map;
        Object[][] table = new Object[map.size()][3];
        int i = 0;
        for (int x : map.keySet()) {
            table[i][0] = x;
            table[i][1] = map.get(x).size();
            table[i][2] = map.get(x);
            ++i;
        }
        String[] headers = {"Value", "Freq", "Permutation"};
        System.out.println(FlipTableConverters.fromObjects(headers, table));
        return map;
    }
}
