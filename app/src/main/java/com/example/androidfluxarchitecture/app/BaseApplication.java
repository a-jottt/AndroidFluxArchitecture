package com.example.androidfluxarchitecture.app;

import android.app.Application;

import com.example.androidfluxarchitecture.app.modules.RestServicesModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joanna on 22.06.16.
 */
public class BaseApplication extends Application {

    @Singleton
    @Component(modules = {RestServicesModule.class})
    public interface ApplicationComponent {
        void inject(BaseApplication application);
    }
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerBaseApplication_ApplicationComponent.builder()
                .restServicesModule(new RestServicesModule())
                .build();
        component().inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

}