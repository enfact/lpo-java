package pattern;

import core.Permutation;
import org.junit.Test;
import pattern.VincularPattern;

import static org.junit.Assert.*;

public class VincularPatternTest {
    @Test
    public void constructorTest1_prefix_nonSuffix() {
        VincularPattern.setCurrentStyle(VincularPattern.IMPLICIT_START_END_OF_STRING);
        VincularPattern vp = new VincularPattern("*1*23");
        for (int i = 0; i < 2; ++i) {
            assertEquals(vp.getBlockSizes().size(), 2);
            assertFalse(vp.isFirstBlockPrefix());
            assertTrue(vp.isLastBlockSuffix());
            assert vp.getBlockSizes().get(0) == 1;
            assert vp.getBlockSizes().get(1) == 2;
            Permutation p = new Permutation("123");
            assertEquals(vp.getPermutation(), p);
            VincularPattern.setCurrentStyle(VincularPattern.EXPLICIT_START_END_OF_STRING);
            vp = new VincularPattern("1*23$");
        }
    }

    @Test
    public void constructorTest2_prefix_suffix() {
        VincularPattern.setCurrentStyle(VincularPattern.IMPLICIT_START_END_OF_STRING);
        VincularPattern vp = new VincularPattern("456*3*12");
        for (int i = 0; i < 2; ++i) {
            assertEquals(3, vp.getBlockSizes().size());
            assertTrue(vp.isFirstBlockPrefix());
            assertTrue(vp.isLastBlockSuffix());
            assert vp.getBlockSizes().get(0) == 3;
            assert vp.getBlockSizes().get(1) == 1;
            assert vp.getBlockSizes().get(2) == 2;
            Permutation p = new Permutation("456312");
            assertEquals(p, vp.getPermutation());
            VincularPattern.setCurrentStyle(VincularPattern.EXPLICIT_START_END_OF_STRING);
            vp = new VincularPattern("^456*3*12$");
        }
    }

    @Test
    public void constructorTest3_consecutiveAsterisks() {
        VincularPattern vp = new VincularPattern("^456***3*12$");
        assertEquals(3, vp.getBlockSizes().size());
        assertTrue(vp.isFirstBlockPrefix());
        assertTrue(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 3;
        assert vp.getBlockSizes().get(1) == 1;
        assert vp.getBlockSizes().get(2) == 2;
        Permutation p = new Permutation("456312");
        assertEquals(p, vp.getPermutation());
    }

    @Test
    public void constructorTest4_consecutiveAsterisks() {
        VincularPattern vp = new VincularPattern("^456*3***12$");
        assertEquals(3, vp.getBlockSizes().size());
        assertTrue(vp.isFirstBlockPrefix());
        assertTrue(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 3;
        assert vp.getBlockSizes().get(1) == 1;
        assert vp.getBlockSizes().get(2) == 2;
        Permutation p = new Permutation("456312");
        assertEquals(p, vp.getPermutation());
    }

    @Test
    public void constructorTest5_nonPrefix_nonSuffix() {
        VincularPattern vp = new VincularPattern("456*3*12");
        assertEquals(3, vp.getBlockSizes().size());
        assertFalse(vp.isFirstBlockPrefix());
        assertFalse(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 3;
        assert vp.getBlockSizes().get(1) == 1;
        assert vp.getBlockSizes().get(2) == 2;
        Permutation p = new Permutation("456312");
        assertEquals(p, vp.getPermutation());
    }

    @Test
    public void constructorTest6_prefix_suffix_oneBlock() {
        VincularPattern vp = new VincularPattern("^456312$");
        assertEquals(1, vp.getBlockSizes().size());
        assertTrue(vp.isFirstBlockPrefix());
        assertTrue(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 6;
        Permutation p = new Permutation("456312");
        assertEquals(p, vp.getPermutation());
    }

    @Test
    public void constructorTest7_prefix_suffix_blockOfSizeOne() {
        VincularPattern vp = new VincularPattern("^2*3*1$");
        assertEquals(3, vp.getBlockSizes().size());
        assertTrue(vp.isFirstBlockPrefix());
        assertTrue(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 1;
        assert vp.getBlockSizes().get(1) == 1;
        assert vp.getBlockSizes().get(2) == 1;
        Permutation p = new Permutation("231");
        assertEquals(p, vp.getPermutation());
    }

    @Test
    public void constructorTest8_emptyAdjacencySet() {
        VincularPattern vp = new VincularPattern("2*3*1");
        assertEquals(3, vp.getBlockSizes().size());
        assertFalse(vp.isFirstBlockPrefix());
        assertFalse(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 1;
        assert vp.getBlockSizes().get(1) == 1;
        assert vp.getBlockSizes().get(2) == 1;
        Permutation p = new Permutation("231");
        assertEquals(p, vp.getPermutation());
    }

    @Test
    public void constructorTest9() {
        VincularPattern vp = new VincularPattern("^2*1");
        assertEquals(2, vp.getBlockSizes().size());
        assertTrue(vp.isFirstBlockPrefix());
        assertFalse(vp.isLastBlockSuffix());
        assert vp.getBlockSizes().get(0) == 1;
        assert vp.getBlockSizes().get(1) == 1;
        Permutation p = new Permutation("21");
        assertEquals(p, vp.getPermutation());
    }
}