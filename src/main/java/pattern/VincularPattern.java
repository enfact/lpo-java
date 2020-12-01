package pattern;

import core.PatternFinder;
import core.Permutation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static util.ArrayListUtil.*;

public class VincularPattern {
    public static int IMPLICIT_START_END_OF_STRING = 1;
    public static int EXPLICIT_START_END_OF_STRING = 2;
    private static int currentStyle = EXPLICIT_START_END_OF_STRING;

    public VincularPattern(Permutation p, Integer... x) {
        permutation = p;
        Collections.addAll(adjacency, x);
        calculateBlockSizes();
    }
    public VincularPattern(Permutation p, Collection<Integer> x) {
        permutation = p;
        adjacency.addAll(x);
        calculateBlockSizes();
    }

    public VincularPattern(@NotNull String s) {
        init(s, currentStyle);
    }

    public VincularPattern(@NotNull String s, int style) {
        init(s, style);
    }

    private void init(String s, int style) {
        if (style == EXPLICIT_START_END_OF_STRING) {
            if (s.charAt(0) == '^') s = (String) s.subSequence(1, s.length());
            else s = "*"+s;

            if (s.charAt(s.length()-1) == '$') s = (String) s.subSequence(0, s.length()-1);
            else s = s + "*";
        }
        ArrayList<Integer> al_permutation = new ArrayList<>();
        ArrayList<Integer> al_x = new ArrayList<>();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '*') {
                ++j;
                if (i == 0) al_x.add(0);
                if (i > 0 && s.charAt(i-1) != '*') al_x.add(j-1);
                if (i == s.length()-1) al_x.add(j);
                al_permutation.add(Integer.parseInt(""+s.charAt(i)));
            }
        }
        permutation = new Permutation(al_permutation);
        adjacency = al_x;
        calculateBlockSizes();
    }

    private void calculateBlockSizes() {
        blockSizes = new ArrayList<>();
        if (adjacency.isEmpty()) {
            for (int i = 0; i < permutation.size(); ++i) blockSizes.add(1);
            return;
        }
        if (adjacency.get(0) == 0) firstBlockPrefix = true;
        if (back(adjacency) == permutation.size()) lastBlockSuffix = true;
        int i = 1, j = 0;
        if (adjacency.get(0) == 0) ++j;
        while (i <= permutation.size()) {
            while (j < adjacency.size() && i != adjacency.get(j)) {
                ++i;
                blockSizes.add(1);
            }
            int blockSize = 1;
            while (j < adjacency.size() && i == adjacency.get(j)) {
                i++;
                j++;
                ++blockSize;
            }
            if (i > permutation.size()) --blockSize;
            else ++i;
            blockSizes.add(blockSize);
        }
    }

    public int countMatches(Permutation p) {
        return PatternFinder.countMatches(p, this);
    }

    private boolean firstBlockPrefix, lastBlockSuffix;
    private Permutation permutation;
    private ArrayList<Integer> adjacency = new ArrayList<>(), blockSizes = new ArrayList<>();

    public Permutation getPermutation() {
        return permutation;
    }

    public ArrayList<Integer> getBlockSizes() {
        return blockSizes;
    }

    public ArrayList<Integer> getAdjacency() {
        return adjacency;
    }

    public boolean isFirstBlockPrefix() {
        return firstBlockPrefix;
    }

    public boolean isLastBlockSuffix() {
        return lastBlockSuffix;
    }

    public static int getCurrentStyle() {
        return currentStyle;
    }

    public static void setCurrentStyle(int currentStyle) {
        VincularPattern.currentStyle = currentStyle;
    }
}
