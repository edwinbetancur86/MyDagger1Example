package com.mobileappsandroid.training.mydagger1example.ui;

import android.content.Context;
import android.content.Intent;

import com.mobileappsandroid.training.mydagger1example.ui2.UserRepoActivity;


/**
 * Created by Android on 5/14/2017.
 */

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;


    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void goToUserRepoActivity(String userName, Context context) {

        Intent intent = new Intent(context, UserRepoActivity.class);

        intent.putExtra("userName", userName);

        context.startActivity(intent);

    }
}
