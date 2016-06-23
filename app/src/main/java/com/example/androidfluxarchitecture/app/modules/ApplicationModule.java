package com.example.androidfluxarchitecture.app.modules;

import com.example.androidfluxarchitecture.app.BaseApplication;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joanna on 23.06.16.
 */
@Module
public class ApplicationModule {

    private final BaseApplication baseApplication;

    public ApplicationModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    @Provides
    @Singleton
    BaseApplication provideBaseApplication() {
        return baseApplication;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }
}
