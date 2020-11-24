package org.backbase.core.api;

import org.backbase.core.PropertyManager;
import retrofit2.Retrofit;

public class RetrofitManager {

    public static RetrofitManager retrofitManager;
    private Retrofit retrofit;

    private RetrofitManager() {
        retrofit =
                new Retrofit.Builder()
                        .baseUrl(PropertyManager.getProperty("base.url"))
                        .build();
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
