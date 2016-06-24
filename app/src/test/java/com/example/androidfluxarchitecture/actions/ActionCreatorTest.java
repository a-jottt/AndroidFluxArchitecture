package com.example.androidfluxarchitecture.actions;

import com.example.androidfluxarchitecture.SubscribeBase;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by joanna on 23.06.16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ActionCreatorTest {

    @Rule
    public Timeout globalTimeout = new Timeout(4000, TimeUnit.MILLISECONDS);

    public static EventBus eventBus;
    public static ActionCreator actionCreator;
    public static String language;

    @BeforeClass
    public static void setup() {
        eventBus = EventBus.getDefault();
        actionCreator = new ActionCreator(eventBus);
        language = "test";
    }

    @Test
    public void createGetRepositoriesByLanguageActionTest() {
        final AtomicBoolean testDone = new AtomicBoolean(false);

        eventBus.register(new TestSubscribers().setTestDone(testDone));

        actionCreator.createGetRepositoriesByLanguageAction(getLanguage());

        while (!testDone.get()) ;
    }

    public static String getLanguage() {
        return language;
    }

    public class TestSubscribers extends SubscribeBase {
        @Subscribe
        public void getRepositoriesByLanguage(CallApiAction action) {
            assertThat(action.getData().get(DataKeys.REPO_LANGUAGE, "")).isEqualTo(ActionCreatorTest.getLanguage());
            testDone.set(true);
        }
    }
}
