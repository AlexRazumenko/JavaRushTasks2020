package task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int valuesNumber = 0;
        for (List<V> valuesList : map.values()) {
            valuesNumber += valuesList.size();
        }
        return  valuesNumber;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V lastAdded = null;
        if (map.containsKey(key)) {
            List<V> entryValuesList = map.get(key);
            int listSize = entryValuesList.size();
            if (listSize > 0) lastAdded = entryValuesList.get(listSize - 1);

            if (listSize < repeatCount) {
                entryValuesList.add(value);
            } else {
                entryValuesList.remove(0);
                entryValuesList.add(value);
            }
        } else map.put(key, new ArrayList<V>(Arrays.asList(value)));
        return lastAdded;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (!map.containsKey(key) || map.get(key).isEmpty()) return null;

        List<V> entryValuesList = map.get(key);
        V removedElement = entryValuesList.remove(0);
        if (entryValuesList.isEmpty())
            map.remove(key);
        return removedElement;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> valuesList = new ArrayList<>();
        for (List<V> entryValuesList : map.values()) {
            valuesList.addAll(entryValuesList);
        }
        return valuesList;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for (List<V> entryValuesList : map.values()) {
            if (entryValuesList.contains(value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}