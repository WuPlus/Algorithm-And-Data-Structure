
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Google;

import java.util.*;

/**
 *
 * @author Wu
 */
public class MyHashTable<K, V> {

    class Entry<K, V> {

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
    }
    private int size = 0;
    private ArrayList<LinkedList<Entry<K, V>>> ary = new ArrayList<>(size);

    public MyHashTable(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            ary.add(i, null);
        }
    }

    public void put(K key, V value) {
        if (key == null) {

            throw new NullPointerException("null of key is not allowed");
        }
        int index = key.hashCode() % size;
        if (ary.get(index) == null) {
            ary.set(index, new LinkedList<Entry<K, V>>());
            ary.get(index).add(new Entry<K, V>(key, value));
        } else {
            LinkedList<Entry<K, V>> list = ary.get(key.hashCode() % size);
            Iterator<Entry<K, V>> iterator = list.iterator();
            while (iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (e.key.equals(key)) {
                    e.value = value;
                    return;
                }
            }
            list.add(new Entry<K, V>(key, value));
        }

    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("null of key is not allowed");
        }
        if (ary.get(key.hashCode() % size) == null) {
            return null;
        } else {
            LinkedList<Entry<K, V>> res = ary.get(key.hashCode() % size);
            Iterator<Entry<K, V>> iterator = res.iterator();
            while (iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        }
    }

    public void delete(V key, V value) {
        if (key == null) {
            throw new NullPointerException("null of key is not allowed");
        }
        if (ary.get(key.hashCode() % size) == null) {
            throw new NullPointerException("key is not existed");
        } else {
            LinkedList<Entry<K, V>> res = ary.get(key.hashCode() % size);
            Iterator<Entry<K, V>> iterator = res.iterator();
            while (iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (e.value.equals(value)) {
                    res.remove(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashTable<String, String> m = new MyHashTable<>(1000);
        m.put("abc", "eee");
        m.put("abc", "bbb");
        System.out.println(m.get("abc"));
    }
}
