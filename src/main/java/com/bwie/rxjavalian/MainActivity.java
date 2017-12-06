package com.bwie.rxjavalian;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.bwie.rxjavalian.model.HomeData;
import com.bwie.rxjavalian.model.ShopResponse;
import com.bwie.rxjavalian.net.ShopApi;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ShopApi shopApi = retrofit.create(ShopApi.class);
        shopApi.homepage(Constants.TOKEN, "homepage")
                .subscribeOn(Schedulers.io())//被观察者执行线程
//               Schedulers 线程调度器
                .observeOn(AndroidSchedulers.mainThread())//观察者线程
        .subscribe(new Consumer<ShopResponse<HomeData>>() {
            @Override
            public void accept(ShopResponse<HomeData> homeDataShopResponse) throws Exception {
                Log.v(getLocalClassName(),homeDataShopResponse.toString());
            }
        });
    }
}
