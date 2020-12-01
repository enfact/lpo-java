package core;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationSetTest {
    @Test
    public void test1() {
        PermutationSet ps = PermutationSet.getFactory().setSize(4).addAvoidAll("3*1*2").build();
        assertEquals(14, ps.size());
    }

    @Test
    public void test2() {
        PermutationSet ps = PermutationSet.getFactory().setSize(4).addAvoidAll("3*2*1").build();
        assertEquals(14, ps.size());
    }
}