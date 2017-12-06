package com.bwie.rxjavalian.net;

import com.bwie.rxjavalian.Constants;
import com.bwie.rxjavalian.model.HomeData;
import com.bwie.rxjavalian.model.ShopResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/12/5.
 */

public interface ShopApi {
    @GET("{token}")
    public Flowable<ShopResponse<HomeData>> homepage(@Path("token") String token, @Query("uri") String uri);
}
