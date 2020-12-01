package statistic;

import core.PatternFinder;
import core.Permutation;
import pattern.VincularPattern;

import java.util.ArrayList;
import java.util.Collections;

public class MahonianStatistic implements IStatistic {
    public MahonianStatistic() {}

    public MahonianStatistic(VincularPattern... patterns) {
        Collections.addAll(this.patterns, patterns);
    }

    public MahonianStatistic(String... patterns) {
        for (String pattern : patterns) {
            this.patterns.add(new VincularPattern(pattern));
        }
    }

    public void addPattern(VincularPattern vp) {
        patterns.add(vp);
    }

    @Override
    public int get(Permutation p) {
        int ans = 0;
        for (VincularPattern vp : patterns) {
            PatternFinder pf = new PatternFinder(p, vp);
            while (pf.computeNextMatch() != null) ++ans;
        }
        return ans;
    }

    public static MahonianStatistic maj = new MahonianStatistic("1*32", "2*31", "3*21", "21");
    public static MahonianStatistic inv = new MahonianStatistic("23*1", "31*2", "32*1", "21");
    public static MahonianStatistic mak = new MahonianStatistic("1*32", "31*2", "32*1", "21");
    public static MahonianStatistic makl = new MahonianStatistic("1*32", "2*31", "32*1", "21");
    public static MahonianStatistic mad = new MahonianStatistic("2*31", "2*31", "31*2", "21");
    public static MahonianStatistic bast = new MahonianStatistic("13*2", "21*3", "32*1", "21");
    public static MahonianStatistic bast_ = new MahonianStatistic("13*2", "31*2", "32*1", "21");
    public static MahonianStatistic bast__ = new MahonianStatistic("1*32", "3*12", "3*21", "21");
    public static MahonianStatistic foze = new MahonianStatistic("21*3", "3*21", "13*2", "21");
    public static MahonianStatistic foze_ = new MahonianStatistic("1*32", "2*31", "2*31", "21");
    public static MahonianStatistic foze__ = new MahonianStatistic("23*1", "31*2", "31*2", "21");
    public static MahonianStatistic sist = new MahonianStatistic("13*2", "13*2", "2*13", "21");
    public static MahonianStatistic sist_ = new MahonianStatistic("13*2", "13*2", "2*31", "21");
    public static MahonianStatistic sist__ = new MahonianStatistic("13*2", "2*31", "2*31", "21");

    private ArrayList<VincularPattern> patterns = new ArrayList<>();


}
