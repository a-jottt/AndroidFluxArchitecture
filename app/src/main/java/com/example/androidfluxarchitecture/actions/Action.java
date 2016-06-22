package com.example.androidfluxarchitecture.actions;

/**
 * Created by joanna on 22.06.16.
 */
public interface Action {
    ActionType getType();
    DataBundle getData();
}
