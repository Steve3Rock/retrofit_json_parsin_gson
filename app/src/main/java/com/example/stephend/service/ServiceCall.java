package com.example.stephend.service;

/**
 * Created by stephend on 4/23/19.
 */
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class ServiceCall {

        private static Retrofit retrofit = null;

        /** Add converter factory for serialization and deserialization of objects. */

        public static Retrofit getRetService() {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(ApiInterface.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

    }


