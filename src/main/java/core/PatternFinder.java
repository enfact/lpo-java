package core;

import core.Permutation;
import core.Subsequence;
import pattern.VincularPattern;
import util.OrderMorphism;

import java.util.ArrayList;
import static util.ArrayListUtil.*;

public class PatternFinder {
    public PatternFinder(Permutation p, VincularPattern vp) {
        firstIndices.add(0);
        permutation = p;
        pattern = vp;
        fillUpIndices();
    }

    private void fillUpIndices() {
        while (firstIndices.size() < pattern.getBlockSizes().size())
            firstIndices.add(back(firstIndices) + pattern.getBlockSizes().get(firstIndices.size()-1));
        assert(firstIndices.size() == pattern.getBlockSizes().size());
        if (permutation.size() == pattern.getPermutation().size()) return;
        if (pattern.isLastBlockSuffix()) {
            popBack(firstIndices);
            firstIndices.add(permutation.size() - back(pattern.getBlockSizes()));
        }
    }

    public Subsequence<Permutation> computeNextMatch() {
        int i = firstIndices.get(0);
        if (pattern.isFirstBlockPrefix() && firstIndices.size() > 1) {
            i = firstIndices.get(1);
        }
//        if (i + pattern.getPermutation().size() - pattern.getBlockSizes().get(0) >= permutation.size()) return null;

        while (true) {
            if (!skipCheck) {
                Subsequence<Permutation> subsequence = new Subsequence<>(permutation, firstIndices, pattern.getBlockSizes());
                if (OrderMorphism.Companion.check(pattern.getPermutation().getArrayList(), subsequence.getValues())) {
                    skipCheck = true;
                    return subsequence;
                }
            } else skipCheck = false;
            if (back(firstIndices) + back(pattern.getBlockSizes()) >= permutation.size()) {
                // cannot incBack(firstIndices)
                int sumBlockSize = back(pattern.getBlockSizes());

                while (back(firstIndices) + sumBlockSize >= permutation.size()) {
                    popBack(firstIndices);
                    if (firstIndices.isEmpty()) return null;
                    sumBlockSize += pattern.getBlockSizes().get(firstIndices.size() - 1);
                }
                if (firstIndices.size() == 1 && pattern.isFirstBlockPrefix()) return null;
                incBack(firstIndices);
                fillUpIndices();
            } else incBack(firstIndices);
        }
    }

    public static int countMatches(Permutation p, VincularPattern vp) {
        PatternFinder pf = new PatternFinder(p, vp);
        int ans = 0;
        while (pf.computeNextMatch() != null) ++ans;
        return ans;
    }


    private ArrayList<Integer> firstIndices = new ArrayList<>();
    private VincularPattern pattern;
    private Permutation permutation;
    private boolean skipCheck = false;
}
