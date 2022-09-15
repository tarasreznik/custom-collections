package collections.impl;

public class MyHashMap<K, V> {

    private Entry<K, V>[] table;
    private int capacity = 16;
    private int size = 0;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        table = new Entry[capacity];
    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;

        int hash = hash(newKey);

        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

        if (table[hash] == null) {
            size++;
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K deleteKey) {
        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            size--;
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        Entry<K, V>[] entry;
        if ((entry = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < entry.length; ++i) {
                entry[i] = null;
            }
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}