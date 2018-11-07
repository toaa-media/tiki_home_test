package com.vn.tikihometest.apis;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * This class is used for building and configuring the {@link Retrofit} api service.
 */
public class ApiManager {

    private static final String URL_SERVER = "https://gist.githubusercontent.com/";

    /**
     * Builds and configures the api service using {@link Retrofit}
     *
     * @return the api interface.
     */
    public static Apis apis() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(Apis.class);
    }

}
