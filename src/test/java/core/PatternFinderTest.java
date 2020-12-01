package core;

import org.junit.Test;
import pattern.VincularPattern;

import static org.junit.Assert.*;

public class PatternFinderTest {

    @Test
    public void computeNextMatchTest1() {
        Permutation p = new Permutation("945716283");
        VincularPattern vp = new VincularPattern("3*1*2");
        PatternFinder pf = new PatternFinder(p, vp);
        int cnt = 0;
        Subsequence<Permutation> subsequence;
        while ((subsequence = pf.computeNextMatch()) != null) {
//            System.out.println(subsequence.getValues());
            ++cnt;
        }
//        System.out.println(cnt);
        assertEquals(26, cnt);
    }

    @Test
    public void computeNextMatchTest2() {
        Permutation p = new Permutation("945716283");
        VincularPattern vp = new VincularPattern("2*1*34");
        PatternFinder pf = new PatternFinder(p, vp);
        int cnt = 0;
        Subsequence<Permutation> subsequence;
        while ((subsequence = pf.computeNextMatch()) != null) {
//            System.out.println(subsequence.getValues());
            ++cnt;
        }
//        System.out.println(cnt);
        assertEquals(0, cnt);
    }

    @Test
    public void computeNextMatchTest3() {
        Permutation p = new Permutation("945716283");
        VincularPattern vp = new VincularPattern("^2*1");
        PatternFinder pf = new PatternFinder(p, vp);
        int cnt = 0;
        Subsequence<Permutation> subsequence;
        while ((subsequence = pf.computeNextMatch()) != null) {
//            System.out.println(subsequence.getValues());
            ++cnt;
        }
//        System.out.println(cnt);
        assertEquals(8, cnt);
    }
}