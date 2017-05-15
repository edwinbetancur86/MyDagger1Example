package com.mobileappsandroid.training.mydagger1example;

/**
 * Created by Android on 5/14/2017.
 */

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);
    void detachView();

}
