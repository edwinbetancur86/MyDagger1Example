package com.mobileappsandroid.training.mydagger1example.ui;

import android.content.Context;

import com.mobileappsandroid.training.mydagger1example.BasePresenter;
import com.mobileappsandroid.training.mydagger1example.BaseView;
import com.mobileappsandroid.training.mydagger1example.Data.GitData;

import java.util.List;

/**
 * Created by Android on 5/14/2017.
 */

public interface MainContract {

    interface View extends BaseView{
        void showData(List<GitData> data);
    }

    interface Presenter extends BasePresenter<View>{
        void goToUserRepoActivity(String userName, Context context);
    }

}
