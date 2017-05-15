package com.mobileappsandroid.training.mydagger1example.Dagger;

import com.mobileappsandroid.training.mydagger1example.ui2.UserRepoActivity;
import com.mobileappsandroid.training.mydagger1example.ui2.UserRepoPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android on 5/12/2017.
 */
@Singleton
@Component(modules=NetModule.class)
public interface MainComponet {

    //void inject(MainActivity activity);
    void inject(UserRepoActivity activity);
    void inject(UserRepoPresenter presenter);
    // void inject(MyFragment fragment);
    // void inject(MyService service);

}
