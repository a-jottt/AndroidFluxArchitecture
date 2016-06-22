package com.example.androidfluxarchitecture.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepositoryQueryData {

    @SerializedName("items")
    protected List<Repository> items;

    public List<Repository> getItems() {
        return items;
    }
}
