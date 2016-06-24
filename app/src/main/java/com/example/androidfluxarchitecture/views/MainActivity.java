package com.example.androidfluxarchitecture.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.androidfluxarchitecture.R;
import com.example.androidfluxarchitecture.actions.ActionCreator;
import com.example.androidfluxarchitecture.app.BaseApplication;
import com.example.androidfluxarchitecture.data.RepositoriesList;
import com.example.androidfluxarchitecture.stores.RepositoryStore;
import com.example.androidfluxarchitecture.views.adapters.RepositoryListAdapter;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Inject
    EventBus eventBus;

    @Inject
    ActionCreator actionCreator;

    @Inject
    RepositoryStore repositoryStore;

    @ViewById(R.id.editTextLanguage)
    EditText editTextLanguage;

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication) getApplication()).component().inject(this);
        mContext = this;
    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        repositoryStore.onPause();
        eventBus.unregister(this);
        super.onStop();
    }

    @Click(R.id.buttonSearch)
    public void searchRepositories() {
        String language = editTextLanguage.getText().toString();
        if (!language.isEmpty()) {
            editTextLanguage.setText("");
            actionCreator.createGetRepositoriesByLanguageAction(language);
        }
    }

    @Subscribe
    public void onRepositoryListUpdated(RepositoriesList repositoriesList) {
        RepositoryListAdapter adapter = new RepositoryListAdapter(repositoriesList.getRepositories(), mContext);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }
}
