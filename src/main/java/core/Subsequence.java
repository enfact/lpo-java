package core;

import java.util.ArrayList;

public class Subsequence<Seq extends ISequence> {
    Subsequence(Seq originalSequence, ArrayList<Integer> firstIndices, ArrayList<Integer> blockSizes) {
        assert firstIndices.size() == blockSizes.size();
        for (int i = 0; i < firstIndices.size(); ++i) {
            for (int j = 0; j < blockSizes.get(i); ++j) {
                indices.add(firstIndices.get(i) + j);
            }
        }
        for (int i : indices) values.add(originalSequence.get(i));
    }

    public ArrayList<Integer> getIndices() {
        return indices;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    ArrayList<Integer> indices = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();
}
