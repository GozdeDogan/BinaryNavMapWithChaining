/**
 * Created by GozdeDogan on 30.04.2017.
 */
public interface HashMap<K, V> {

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    int size();

    boolean isEmpty();
}
