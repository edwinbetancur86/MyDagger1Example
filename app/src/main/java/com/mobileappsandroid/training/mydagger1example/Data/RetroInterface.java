package com.mobileappsandroid.training.mydagger1example.Data;

import com.mobileappsandroid.training.mydagger1example.Data.GitData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Android on 5/13/2017.
 */

public interface RetroInterface
{
    @GET("users/{username}/repos")
    Call<List<GitData>> getGitData(@Path("username") String userName);


}
