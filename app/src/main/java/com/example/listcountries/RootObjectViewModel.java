package com.example.listcountries;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class RootObjectViewModel extends ViewModel {
  private RootObject rootObject;
  private Retrofit retrofit=new Retrofit();

  private MutableLiveData<List<RootObject>> liveData;
  public MutableLiveData<List<RootObject>> getData(){
      if(liveData ==null){
          liveData = retrofit.getRootObject();
      }
      return liveData;
  }
}
