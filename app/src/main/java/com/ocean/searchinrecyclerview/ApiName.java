package com.ocean.searchinrecyclerview;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiName {

    @Multipart
    @POST("/customer_search.php")
    Call<List<SearchEmpModel>> searchCustomer(@Part("auth_key") RequestBody auth_key, @Part("customer_name") RequestBody customer_name);

}
