package com.mobileappsandroid.training.mydagger1example.ui2;

import android.content.Context;
import android.content.Intent;
import android.test.mock.MockContext;

import com.mobileappsandroid.training.mydagger1example.BaseView;
import com.mobileappsandroid.training.mydagger1example.Data.GitData;
import com.mobileappsandroid.training.mydagger1example.ui.MainActivity;
import com.mobileappsandroid.training.mydagger1example.ui.MainContract;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Android on 5/14/2017.
 */
public class UserRepoPresenterTest {


    @Test
    public void shouldPassStringResultToView()
    {
        // Given
        UserRepoContract.View view = new MockView();
        MockUserRepo mockUserRepo = new MockUserRepo();
        // When
        UserRepoPresenter presenter = new UserRepoPresenter();
        presenter.loadRetroGitData(new MockContext(), new Intent());
        // Then
        Assert.assertEquals(true, ((MockView)view).passed);
    }

    private class MockView implements UserRepoContract.View
    {
        boolean passed;

        @Override
        public void showError(String error) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void showData(String result) {

        }

    }

    public class MockUserRepo implements UserRepoContract.View
    {
        Boolean passed;


        @Override
        public void showError(String error) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void showData(String result) {

        }

    }


}