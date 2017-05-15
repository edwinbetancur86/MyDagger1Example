package com.mobileappsandroid.training.mydagger1example.ui2;

import android.content.Context;
import android.content.Intent;

import com.mobileappsandroid.training.mydagger1example.BasePresenter;
import com.mobileappsandroid.training.mydagger1example.BaseView;
import com.mobileappsandroid.training.mydagger1example.Data.GitData;

import java.util.List;


/**
 * Created by Android on 5/14/2017.
 */

public interface UserRepoContract {

    interface View extends BaseView
    {

        void showData(String result);
    }


    interface Presenter extends BasePresenter<View>
    {
        void loadRetroGitData(Context context, Intent intent);

    }

}
