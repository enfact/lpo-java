package core;

import org.junit.Test;

import java.util.ArrayList;

public class PermutationTest {
    @Test
    public void constructorTest() {
        Permutation p1 = new Permutation(5);
        Permutation p2 = new Permutation(1,2,4,3,5);
        Permutation p3 = new Permutation(new int[]{1,2,4,3,5});
        Permutation p4 = new Permutation(new Integer[]{1,2,3});
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1); al.add(3); al.add(2);
        Permutation p5 = new Permutation(al);
    }
}