package com.javarush.task.task35.task3509;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();
        for (T object : elements) set.add(object);
        return set;
    }

    public static <K,V> HashMap <K,V> newHashMap(List <? extends K> keys, List <? extends V> values) {
        HashMap<K,V> map= new HashMap<>();
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
