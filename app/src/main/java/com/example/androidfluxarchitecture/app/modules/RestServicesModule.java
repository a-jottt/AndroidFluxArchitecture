package com.example.androidfluxarchitecture.app.modules;

import com.example.androidfluxarchitecture.app.RetrofitFactory;
import com.example.androidfluxarchitecture.app.services.RepositoryService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joanna on 22.06.16.
 */
@Module
public class RestServicesModule {

    @Provides
    @Singleton
    RepositoryService provideRepositoryService() {
        return  RetrofitFactory.getAdapter().create(RepositoryService.class);
    }
}
