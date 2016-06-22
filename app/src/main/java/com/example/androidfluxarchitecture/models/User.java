package com.example.androidfluxarchitecture.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    protected String login;

    @SerializedName("avatar_url")
    protected String avatar_url;

    @SerializedName("following")
    protected Integer following;

    @SerializedName("repos_url")
    protected String repos_url;

    @SerializedName("name")
    protected String name;

    @SerializedName("email")
    protected String email;

    @SerializedName("public_repos")
    protected Integer public_repos;

    @SerializedName("followers")
    protected Integer followers;

    public User() {
        super();
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public Integer getFollowing() {
        return following;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPublic_repos() {
        return public_repos;
    }

    public Integer getFollowers() {
        return followers;
    }
}
