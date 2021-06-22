package collection;

import java.util.*;

public class CollectionsFirst {
    public static void main(String[] args) {
        String[] array = {"egy", "egy", "ketto", "harom", "negy", "ot"};

        List<String> arrayList = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
            hashSet.add(array[i]);
            hashMap1.put(i, array[i]);
            hashMap2.put(array[i], i);
        }
        System.out.println("");
    }
}
