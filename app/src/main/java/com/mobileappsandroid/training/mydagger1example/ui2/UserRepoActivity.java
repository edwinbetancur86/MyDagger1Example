package com.mobileappsandroid.training.mydagger1example.ui2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.mobileappsandroid.training.mydagger1example.Data.GitData;
import com.mobileappsandroid.training.mydagger1example.R;

import java.util.Arrays;
import java.util.List;


public class UserRepoActivity extends AppCompatActivity implements UserRepoContract.View{

    private TextView repoResult;
    private Intent intent;
    private UserRepoContract.Presenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_repo);

        repoResult = (TextView) findViewById(R.id.editTextRepoResult);

        presenter = new UserRepoPresenter();

        presenter.attachView(this);

        intent = getIntent();

        presenter.loadRetroGitData(this, intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(String result) {

        // Display the repos in a scrollView
        repoResult.setText(result);
    }


}
