import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by GozdeDogan on 30.04.2017.
 * Kod kitaptan alindi, toString metodu eklendi
 * remove da numKeys azaltilmiyordu o eklendi
 * Entry classina toString metodu eklendi
 */
public class HashTableChaining<K, V> implements HashMap<K, V> {
    /**
     * Contains key-value pairs for a hash table.
     */
    private static class Entry<K, V> {
        private K key;
        private V value;

        /**
         * Creates a new key-value pair
         * @param key   The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         * @return The key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        /**
         * entry'i gorebilmek icin yazildi!
         * @return
         */
        public String toString(){
            return "(" + key.toString() + ", " + value.toString() + ")";
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    /**
     * No-parameter constructor
     */
    public HashTableChaining() {
        table = new LinkedList[CAPACITY];
    }

    /**
     * Method get for class HashtableChain.
     *
     * @param key The key being sought
     * @return The value associated with this key if found;
     * otherwise, null
     */
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index])
            if (nextItem.key.equals(key))
                return nextItem.value;

        return null;
    }

    /**
     * Method put for class HashtableChain.
     * post: This key-value pair is inserted in the
     * table and numKeys is incremented. If the key is already
     * in the table, its value is changed to the argument
     * value and numKeys is not changed.
     *
     * @param key   The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     * found; otherwise, null
     */
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<Entry<K, V>>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index])
            if (nextItem.key.equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }

        table[index].addFirst(new Entry<K, V>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    /**
     * Returns the number of entries in the map
     */
    public int size() {
        return numKeys;
    }

    /**
     * Returns true if empty
     */
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     * gelen keyi siler varsa!
     * numKeys i de azaltir. (Bunu ben ekledim, kitaptaki kodda yoktu!)
     * @param key
     * @return
     */
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // Key not in table
        Iterator<Entry<K, V>> iter = table[index].iterator();
        while (iter.hasNext()) {
            Entry<K, V> nextItem = iter.next();
            // If the search is successful, return the value.
            if (nextItem.key.equals(key)) {
                V returnValue = nextItem.value;
                iter.remove();
                numKeys--;
                return returnValue;
            }
        }
        return null; // Key not in table
    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * post: the size of table is doubled and is an
     * odd integer. Each non-deleted entry from the original
     * table is reinserted into the expanded table.
     * The value of numKeys is reset to the number of items
     * actually inserted; numDeletes is reset to 0.
     */
    public void rehash() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[2 * oldTable.length + 1];

        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++)
            if (oldTable[i] != null)
                for (Entry<K, V> nextEntry : oldTable[i])
                    put(nextEntry.key, nextEntry.value);
    }

    /**
     * map elemanlarini gorebilmel icin yazildi ama bir sorun var tam calismiyor.
     * @return
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        for(int i=0; i<numKeys; i++){
            if(table[i] != null){
                Iterator<Entry<K, V>> iter = table[i].iterator();
                while (iter.hasNext()) {
                    Entry<K, V> nextItem = iter.next();
                    //System.out.println(i + ". " + nextItem.toString());
                    sb.append(nextItem.toString());
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}