package com.example.androidfluxarchitecture.app.services;

import com.example.androidfluxarchitecture.models.Repository;
import com.example.androidfluxarchitecture.models.RepositoryQueryData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joanna on 22.06.16.
 */
public interface RepositoryService {

    @GET("/users/{user_name}/repos")
    Observable<List<Repository>> getUserRepos(@Path("user_name") String user_name);

    @GET("/search/repositories")
    Observable<RepositoryQueryData> getMostPopularReposByLanguage(@Query("q") String language, @Query("per_page") String perPage);
}
