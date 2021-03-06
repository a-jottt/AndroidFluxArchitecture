package com.example.androidfluxarchitecture.stores;

import com.example.androidfluxarchitecture.actions.ActionTypes;
import com.example.androidfluxarchitecture.actions.CallApiAction;
import com.example.androidfluxarchitecture.actions.DataBundle;
import com.example.androidfluxarchitecture.actions.DataKeys;
import com.example.androidfluxarchitecture.app.services.RepositoryService;
import com.example.androidfluxarchitecture.data.RepositoriesList;
import com.example.androidfluxarchitecture.models.Repository;
import com.example.androidfluxarchitecture.models.RepositoryQueryData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by joanna on 22.06.16.
 */
public class RepositoryStore {

    public ArrayList<Repository> repositories;
    public EventBus eventBus;

    @Inject
    RepositoryService repositoryService;

    @Inject
    public RepositoryStore(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.register(this);
        repositories = new ArrayList<>();
    }

    public void onPause() {
        eventBus.unregister(this);
    }

    @Subscribe
    public final void onCallApiAction(CallApiAction action) {
        DataBundle<DataKeys> data = action.getData();
        String language = (String) data.get(DataKeys.REPO_LANGUAGE, -1);
        ActionTypes actionType = action.getType();
        switch (actionType) {
            case GET_REPOS_BY_LANGUAGE:
                getRepoByLanguage(language);
                break;
        }
    }


    private void getRepoByLanguage(String language) {
        repositoryService.getMostPopularReposByLanguage("language:" + language, "20").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RepositoryQueryData>() {

                    @Override
                    public void onCompleted() {
                        eventBus.post(new RepositoriesList(repositories));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(RepositoryQueryData items) {
                        repositories.addAll(items.getItems());
                    }
                });
    }
}
