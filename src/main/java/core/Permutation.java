package core;

import pattern.VincularPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Permutation implements ISequence {
    /**
     * Construct an identity permutation
     * @param n permutation length
     */
    public Permutation(int n) {
        for (int i = 1; i <= n; ++i) permutation.add(i);
    }

    public Permutation(Collection<Integer> al) {
        permutation.addAll(al);
    }

    public Permutation(Integer... ints) {
        Collections.addAll(permutation, ints);
    }

    public Permutation(int[] ints) {
        for (int anInt : ints) permutation.add(anInt);
    }

    public Permutation(String s) {
        for (int i = 0; i < s.length(); ++i) permutation.add(Integer.parseInt(""+s.charAt(i)));
    }

    /**
     * Generate a random permutation of size n
     * @param n permutation length
     * @return a random permutation
     */
    public static Permutation randomPermutation(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        al.ensureCapacity(n);
        for (int i = 1; i <= n; ++i) al.add(i);
        Collections.shuffle(al);
        return new Permutation(al);
    }

    /**
     * Compute the next permutation (lexicographically) to a permutation
     * @param p a permutation
     * @return next permutation of the given permutation, if any; or null otherwise
     */
    public static Permutation nextPermutation(Permutation p) {
        ArrayList<Integer> al = (ArrayList<Integer>) p.getArrayList().clone();
        for (int a = al.size()-2; a >= 0; --a) {
            if (al.get(a) < al.get(a+1)) {
                for (int b = al.size() - 1;; --b) {
                    if (al.get(b) > al.get(a)) {
                        Collections.swap(al, a, b);
                        for (++a, b=al.size()-1; a < b; ++a, --b) Collections.swap(al, a, b);
                        return new Permutation(al);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Similar to {@link Permutation#nextPermutation(Permutation) nextPermutation(Permutation)} but calculate
     * the next permutation based on the current permutation the object is storing.
     * @return next permutation of the current state
     */
    public Permutation nextPermutation() {
        ArrayList<Integer> al = permutation;
        for (int a = al.size()-2; a >= 0; --a) {
            if (al.get(a) < al.get(a+1)) {
                for (int b = al.size() - 1;; --b) {
                    if (al.get(b) > al.get(a)) {
                        Collections.swap(al, a, b);
                        for (++a, b=al.size()-1; a < b; ++a, --b) Collections.swap(al, a, b);
                        return this;
                    }
                }
            }
        }
        return null;
    }

    public int countMatches(VincularPattern vp) {
        return PatternFinder.countMatches(this, vp);
    }

    public int size() {
        return permutation.size();
    }

    public int get(int i) {
        return permutation.get(i);
    }

    protected ArrayList<Integer> getArrayList() {
        return permutation;
    }

    private final ArrayList<Integer> permutation = new ArrayList<>();

    // AUTO-GENERATED

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permutation that = (Permutation) o;

        return permutation.equals(that.permutation);
    }

    @Override
    public int hashCode() {
        return permutation.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int x : permutation) res.append(x);
        return res.toString();
    }

    protected Permutation clone() {
        return new Permutation((ArrayList<Integer>)this.permutation.clone());
    }
}
