package com.example.listcountries;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static retrofit2.Retrofit getRetrofitInstance() {
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static Service getService() {
        return getRetrofitInstance().create(Service.class);
    }

    public MutableLiveData<List<RootObject>> getRootObject() {
        final MutableLiveData<List<RootObject>> liveData = new MutableLiveData<>();
        Service service = getRetrofitInstance().create(Service.class);
        Call<List<RootObject>> countries  = service.getAllCountries();
        countries.enqueue(new Callback<List<RootObject>>() {
            @Override
            public void onResponse(Call<List<RootObject>> call, Response<List<RootObject>> response) {
                Log.d("SUCCESS:","");
                List<RootObject> list = response.body();
                liveData.setValue(response.body());
                for(RootObject ro : list){
                    Log.d("name:",ro.getName());
                    Log.d("capital:",ro.getCapital());
                    Log.d("flag:",ro.getFlag());
                }
            }

            @Override
            public void onFailure(Call<List<RootObject>> call, Throwable t) {
                Log.d("notsuccess:",t.getMessage());
            }
        });
        return liveData;
    }
}
