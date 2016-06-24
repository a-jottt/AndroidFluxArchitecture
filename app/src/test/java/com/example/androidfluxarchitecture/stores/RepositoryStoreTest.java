package com.example.androidfluxarchitecture.stores;

import com.example.androidfluxarchitecture.actions.ActionCreator;
import com.example.androidfluxarchitecture.actions.ActionTypes;
import com.example.androidfluxarchitecture.actions.CallApiAction;
import com.example.androidfluxarchitecture.actions.DataBundle;
import com.example.androidfluxarchitecture.actions.DataKeys;

import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

/**
 * Created by joanna on 23.06.16.
 */
public class RepositoryStoreTest {

    public static String language;
    private EventBus eventBus;
    private RepositoryStore mockRepositoryStore;
    private static final String METHOD = "getRepoByLanguage";

    @Rule
    public Timeout globalTimeout = new Timeout(4000, TimeUnit.MILLISECONDS);

    @Before
    public void setup() {
        eventBus = EventBus.getDefault();
        mockRepositoryStore = new RepositoryStore(eventBus);
        language = "test";
    }

    @Test
    public void RepositoryStoreCreationTest() {
        assertThat(mockRepositoryStore.eventBus).isNotNull();
        assertThat(mockRepositoryStore.eventBus.isRegistered(mockRepositoryStore)).isEqualTo(true);
        assertThat(mockRepositoryStore.repositories).isNotNull();
        assertThat(mockRepositoryStore.repositories.size()).isEqualTo(0);
    }

    @Test
    public void onPauseShouldUnregisterClass() {
        mockRepositoryStore.onPause();
        assertThat(eventBus.isRegistered(mockRepositoryStore)).isEqualTo(false);
    }

    @Test
    public void onCallApiActionTest() throws Exception {
//        ActionCreator actionCreatorMock = PowerMockito.mock(ActionCreator.class);
//        RepositoryStore repositoryStoreMock = PowerMockito.mock(RepositoryStore.class);
//
//        actionCreatorMock.createGetRepositoriesByLanguageAction(getLanguage());
//
//        PowerMockito.doNothing().when(repositoryStoreMock, METHOD);
//        verifyPrivate(repositoryStoreMock).invoke(METHOD, getLanguage());
    }

    public static String getLanguage() {
        return language;
    }
}
