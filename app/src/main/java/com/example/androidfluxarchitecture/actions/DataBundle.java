package com.example.androidfluxarchitecture.actions;

import java.util.HashMap;

/**
 * Created by joanna on 22.06.16.
 */
public class DataBundle <T extends DataKey> {
    HashMap<T, Object> map;

    public DataBundle() {
        map = new HashMap<>();
    }

    public void put(T key, Object data) {
        map.put(key, data);
    }

    public Object get(T key, Object defaultValue) {
        Object object = map.get(key);
        if (object == null) {
            return defaultValue;
        }
        
        return object;
    }
}
