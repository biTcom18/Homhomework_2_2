
import java.util.Map;
import java.util.Objects;


public class Entry<K, V> implements Map.Entry<K, V> {

    /**
     * This entry's key
     */
    private final K key;

    /**
     * This entry's value
     */
    private V val;

    /**
     * Constructs an empty Entry
     * @param key the entry's assigned key, value the entry's assigned value
     */
    public Entry(K key, V value){
        this.key = key;
        this.val = value;
    }

    public Entry() {
        this.key = null;
        this.val = null;
    }

    /**
     * Returns this entry's key
     */
    @Override
    public K getKey() {
        return this.key;
    }

    /**
     * Returns this entry's value
     */
    @Override
    public V getValue() {
        return this.val;
    }

    /**
     * Updates this entry's value and returns the previous value
     * @param value the new value
     */
    @Override
    public V setValue(V value) {
        V old = this.val;
        this.val = value;
        return old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry<?, ?> entry)) return false;
        return Objects.equals(getKey(), entry.getKey())
                && Objects.equals(val, entry.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), val);
    }



    public String toString() {
        return "("+ this.key + ", " + this.val + ")";
    }

}
