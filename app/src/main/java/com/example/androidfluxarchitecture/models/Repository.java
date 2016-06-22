package com.example.androidfluxarchitecture.models;

import com.google.gson.annotations.SerializedName;

public class Repository {

    @SerializedName("owner")
    protected User owner;

    @SerializedName("name")
    protected String name;

    @SerializedName("full_name")
    protected String full_name;

    @SerializedName("html_url")
    protected String html_url;

    @SerializedName("description")
    protected String description;

    @SerializedName("stargazers_count")
    protected Integer stargazers_count;

    @SerializedName("watchers_count")
    protected Integer watchers_count;

    @SerializedName("language")
    protected String language;

    protected String query;

    public Repository() {
        super();
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStargazers_count() {
        return stargazers_count;
    }

    public Integer getWatchers_count() {
        return watchers_count;
    }

    public String getLanguage() {
        return language;
    }

    public String getQuery() {
        return query;
    }
}
