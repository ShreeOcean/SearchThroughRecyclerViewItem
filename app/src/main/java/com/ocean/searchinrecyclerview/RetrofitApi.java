package com.ocean.searchinrecyclerview;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    private static final String BASE_URL = "https://erpsurya.co.in/basic/api_tracker/";
    private static Retrofit retrofit =null;
    private OkHttpClient.Builder httpClient;
    private ApiName apiServices;
    private static RetrofitApi instance;

//    public static Retrofit getRetrofit(){
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create()).build();
//        }
//        return retrofit;
//    }

    public static RetrofitApi getInstance() {
        if (instance == null)
            instance = new RetrofitApi();
        return instance;
    }

    private RetrofitApi() {
        httpClient = new OkHttpClient.Builder();
        apiServices = create(BASE_URL, ApiName.class);
    }

    public ApiName getApiServices() {
        return apiServices;
    }

    private <T> T create(String baseUrl, Class<T> cls) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        T t = retrofit.create(cls);
        return t;
    }
}
