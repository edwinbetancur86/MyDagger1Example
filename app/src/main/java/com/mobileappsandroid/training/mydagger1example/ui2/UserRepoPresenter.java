package com.mobileappsandroid.training.mydagger1example.ui2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


import com.mobileappsandroid.training.mydagger1example.Dagger.DaggerMainComponet;
import com.mobileappsandroid.training.mydagger1example.Data.GitData;
import com.mobileappsandroid.training.mydagger1example.Data.RetroInterface;
import com.mobileappsandroid.training.mydagger1example.Dagger.NetModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Android on 5/14/2017.
 */

public class UserRepoPresenter implements UserRepoContract.Presenter{


    private UserRepoContract.View view;
    private String username;
    @Inject Retrofit retrofit;

    public void attachView(UserRepoContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadRetroGitData(final Context context, Intent intent) {


        username = intent.getStringExtra("userName");


        // Use retrofit to retrieve data and call showData on view
        // to display it.

        DaggerMainComponet.builder()
                .netModule(new NetModule("https://api.github.com/"))
                .build()
                .inject(UserRepoPresenter.this);

        RetroInterface retroInterface
                = retrofit.create(RetroInterface.class);

        Call<List<GitData>> call =
                retroInterface.getGitData
                        (username);

        call.enqueue(new Callback<List<GitData>>() {
            @Override
            public void onResponse(Call<List<GitData>> call, Response<List<GitData>> response) {

                String result = "";

                List<GitData> gitDataList = response.body();

                for (int i = 0; i < gitDataList.size(); i++)
                {
                    result += gitDataList.get(i).getHtmlUrl() + "\n";
                }

                    view.showData(result);

            }

            @Override
            public void onFailure(Call<List<GitData>> call, Throwable t) {
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.i("TAG", t.getLocalizedMessage());
            }
        });


    }



}
