package com.example.androidfluxarchitecture.data;

import com.example.androidfluxarchitecture.models.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by joanna on 23.06.16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class RepositoriesListTest {

    @Test
    public void createRepositoriesListFromNothing() {
        RepositoriesList repositoriesList = new RepositoriesList();
        assertThat(repositoriesList.repositories).isNotNull();
        assertThat(repositoriesList.repositories.size()).isEqualTo(0);
    }

    @Test
    public void createRepositoriesListFromArrayListTest() {
        ArrayList<Repository> list = new ArrayList<Repository>(3);

        String jekyllName = "jekyll";
        String hydeName = "hyde";
        String frankieName = "frankie";
        int jekyllStars = 123;
        int hydeStars = 456;
        int frankieStars = 789;

        list.add(new Repository(jekyllName, jekyllStars));
        list.add(new Repository(hydeName, hydeStars));
        list.add(new Repository(frankieName, frankieStars));

        RepositoriesList repositoriesList = new RepositoriesList(list);

        assertThat(repositoriesList.repositories).isNotNull();
        assertThat(repositoriesList.repositories.get(0).getName()).isEqualTo(jekyllName);
        assertThat(repositoriesList.repositories.get(0).getStargazers_count()).isEqualTo(jekyllStars);
        assertThat(repositoriesList.repositories.get(1).getName()).isEqualTo(hydeName);
        assertThat(repositoriesList.repositories.get(1).getStargazers_count()).isEqualTo(hydeStars);
        assertThat(repositoriesList.repositories.get(2).getName()).isEqualTo(frankieName);
        assertThat(repositoriesList.repositories.get(2).getStargazers_count()).isEqualTo(frankieStars);
    }
}
