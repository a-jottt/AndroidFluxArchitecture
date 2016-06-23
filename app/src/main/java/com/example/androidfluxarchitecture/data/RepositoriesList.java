package com.example.androidfluxarchitecture.data;

import com.example.androidfluxarchitecture.models.Repository;

import java.util.ArrayList;

/**
 * Created by joanna on 23.06.16.
 */
public class RepositoriesList {

    public ArrayList<Repository> repositories;

    public RepositoriesList() {
        repositories = new ArrayList<Repository>();
    }

    public RepositoriesList(ArrayList<Repository> list) {
        this.repositories = new ArrayList<Repository>();
        this.repositories.addAll(list);
    }
}
