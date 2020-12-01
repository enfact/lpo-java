package util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ArrayListUtil {
    public static <E> E back(@NotNull ArrayList<E> al) {
        return al.get(al.size()-1);
    }

    public static void incBack(@NotNull ArrayList<Integer> al) {
        al.set(al.size()-1, al.get(al.size()-1) + 1);
    }

    public static <E> void popBack(@NotNull ArrayList<E> al) {
        al.remove(al.size()-1);
    }
}
