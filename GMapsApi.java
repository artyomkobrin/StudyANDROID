package com.lav.android.gmailapi;

import com.lav.android.gmailapi.Models.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hp on 08.09.2017.
 */
//https://maps.googleapis.com/maps/api/directions/json?origin=&destination=
public interface GMapsApi {

    @GET("maps/api/directions/json")
    Call<Model> trans(@Query ("origin") String origin,
                      @Query ("destination") String destination );
}
