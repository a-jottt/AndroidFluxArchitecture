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

    public Repository(String name, Integer stargazers_count) {
        this.name = name;
        this.stargazers_count = stargazers_count;
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

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStargazers_count(Integer stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public void setWatchers_count(Integer watchers_count) {
        this.watchers_count = watchers_count;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
