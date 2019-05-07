package com.example.stephend.service;

/**
 * Created by stephend on 4/23/19.
 */

import com.example.stephend.model.Contacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    String BASE_URL = "https://api.androidhive.info/";

    @GET("contacts")
    Call<Contacts> getContacts();

}