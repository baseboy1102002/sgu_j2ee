package model;

public class ModelPair<K, V> {
    private K key;
    private V value;

    public ModelPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
