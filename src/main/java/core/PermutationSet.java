package core;

import org.jetbrains.annotations.NotNull;
import pattern.VincularPattern;

import java.util.*;

public class PermutationSet implements Iterable<Permutation> {
    public PermutationSet(int n) {
        Permutation p = new Permutation(n);
        do {
            set.add(p.clone());
        } while (p.nextPermutation() != null);
    }
    
    public PermutationSet(int n, ArrayList<VincularPattern> avoidAll, @NotNull ArrayList<VincularPattern> containAny) {
        Permutation p = new Permutation(n);
        do {
            boolean checkMatch = containAny.isEmpty(), checkAvoid = true;
            for (VincularPattern vp : containAny) {
                if (new PatternFinder(p, vp).computeNextMatch() != null) {
                    checkMatch = true;
                    break;
                }
            }
            for (VincularPattern vp : avoidAll) {
                if (new PatternFinder(p,vp).computeNextMatch() != null) {
                    checkAvoid = false;
                    break;
                }
            }
            if (checkAvoid && checkMatch) set.add(p.clone());
        } while (p.nextPermutation() != null);
    }

    public int size() {
        return set.size();
    }

    public static PermutationSetFactory getFactory() {
        return new PermutationSetFactory();
    }
    
    HashSet<Permutation> set = new HashSet<>();
    
    public static class PermutationSetFactory {
        public PermutationSet build() {
            return new PermutationSet(n, avoidAll, containAny);
        }
        
        public PermutationSetFactory setSize(int n) {
            this.n = n;
            return this;
        }

        public PermutationSetFactory addAvoidAll(VincularPattern... avoidAll) {
            Collections.addAll(this.avoidAll, avoidAll);
            return this;
        }
        
        public PermutationSetFactory addAvoidAll(String... avoidAll) {
            for (String s : avoidAll) {
                this.avoidAll.add(new VincularPattern(s));
            }
            return this;
        }

        public PermutationSetFactory addContainAny(VincularPattern... containAny) {
            Collections.addAll(this.containAny, containAny);
            return this;
        }

        public PermutationSetFactory addContainAny(String... containAny) {
            for (String s : containAny) {
                this.containAny.add(new VincularPattern(s));
            }
            return this;
        }

        int n;
        ArrayList<VincularPattern> avoidAll = new ArrayList<>();
        ArrayList<VincularPattern> containAny = new ArrayList<>();
    }

    @Override
    public Iterator<Permutation> iterator() {
        return set.iterator();
    }
}
