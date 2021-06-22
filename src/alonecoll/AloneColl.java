package alonecoll;

import java.util.*;

public class AloneColl {

    public static void main(String[] args) {

        String array[] = {"one", "one", "two", "three", "four", "five"};

        List<String> arrayListAlone = new ArrayList<>();
        Set<String> hashSetAlone = new HashSet<>();
        HashMap<Integer, String> hashMap1Alone = new HashMap<>();
        HashMap<String, Integer> hashMap2Alone = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            arrayListAlone.add(array[i]);
            hashSetAlone.add(array[i]);
            hashMap1Alone.put(i, array[i]);
            hashMap2Alone.put(array[i], i);
        }
        System.out.println("");


        System.out.println(arrayListAlone);
        System.out.println(arrayListAlone.get(5));
        System.out.println(hashSetAlone);
        System.out.println(hashMap1Alone);
        System.out.println(hashMap2Alone);
    }
}
