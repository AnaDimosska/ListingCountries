package com.example.listcountries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    String BASE_URL = "https://restcountries.eu/rest/v2/";
    @GET("all")
    Call<List<RootObject>> getAllCountries();
}
