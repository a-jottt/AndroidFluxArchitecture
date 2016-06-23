package com.example.androidfluxarchitecture.actions;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by joanna on 22.06.16.
 */
public class ActionCreator {

    private EventBus eventBus;

    public ActionCreator(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public final void createGetRepositoriesByLanguageAction(final String language) {
        DataBundle<DataKeys> bundle = new DataBundle<>();
        bundle.put(DataKeys.REPO_LANGUAGE, language);
        eventBus.post(new CallApiAction(ActionTypes.GET_REPOS_BY_LANGUAGE, bundle));
    }
}
