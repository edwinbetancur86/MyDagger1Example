package com.mobileappsandroid.training.mydagger1example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobileappsandroid.training.mydagger1example.Data.GitData;
import com.mobileappsandroid.training.mydagger1example.R;
import com.mobileappsandroid.training.mydagger1example.ui2.UserRepoActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    //private MainComponet mMainComponet;
    //@Inject Gson gson;
    //@Inject OkHttpClient okHttpClient;
    //@Inject SharedPreferences sharedPreferences;
    //private RetroInterface retroInterface;

    private Button buttonFindRepos;
    private EditText editTextUserName;
    private MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();

        presenter.attachView(this);


        buttonFindRepos = (Button) findViewById(R.id.buttonFindRepos);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);


        buttonFindRepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.goToUserRepoActivity
                        (editTextUserName.getText().toString(),
                                MainActivity.this);

            }
        });


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
    public void showData(List<GitData> data) {

    }
}
