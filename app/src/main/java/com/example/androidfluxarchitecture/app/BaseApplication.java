package com.example.androidfluxarchitecture.app;

import android.app.Application;

import com.example.androidfluxarchitecture.app.modules.ApplicationModule;
import com.example.androidfluxarchitecture.app.modules.RestServicesModule;
import com.example.androidfluxarchitecture.stores.RepositoryStore;
import com.example.androidfluxarchitecture.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joanna on 22.06.16.
 */
public class BaseApplication extends Application {

    @Singleton
    @Component(modules = {RestServicesModule.class, ApplicationModule.class})
    public interface ApplicationComponent {
        void inject(BaseApplication application);
        void inject (RepositoryStore repositoryStore);
        void inject (MainActivity mainActivity);
    }
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerBaseApplication_ApplicationComponent.builder()
                .restServicesModule(new RestServicesModule())
                .applicationModule(new ApplicationModule(this))
                .build();
        component().inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

}