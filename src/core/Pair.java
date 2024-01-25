package core;

/**
 * Represents a generic key-value pair.
 * 
 * @param <TKey> The type of the key.
 * @param <TValue> The type of the value.
 */
public class Pair<TKey, TValue> {
    private TKey key;
    private TValue value;

    /**
     * Constructor for Pair.
     * 
     * @param key The key in the pair.
     * @param value The value in the pair.
     */
    public Pair(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the pair key
     */
    public TKey getKey() {
        return key;
    }

    /**
     * Sets the pair key
     */
    public void setKey(TKey key) {
        this.key = key;
    }

    /**
     * Gets the pair value
     */
    public TValue getValue() {
        return value;
    }

    /**
     * Sets the pair value
     */
    public void setValue(TValue value) {
        this.value = value;
    }
}
