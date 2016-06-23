package com.example.androidfluxarchitecture.app.modules;

import android.app.Application;
import android.content.Context;

import com.example.androidfluxarchitecture.actions.ActionCreator;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joanna on 23.06.16.
 */
@Module
public class ApplicationModule {

    Application application;
    Context context;

    public ApplicationModule(Application app) {
        this.application = app;
        this.context = app.getApplicationContext();
    }

    @Provides
    @Singleton
    ActionCreator provideActionCreator() {
        return new ActionCreator(provideEventBus());
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }
}
