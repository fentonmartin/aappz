package io.github.fentonmartin.aappz.location.listener;

/**
 * Basic abstraction for key value storage.
 */
public interface StoreListener<T> {

    T get(String key);

    void put(String key, T value);

    void remove(String key);

}
