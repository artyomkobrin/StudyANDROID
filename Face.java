package com.example.lyavon.tourism;

import com.example.lyavon.tourism.Models.DirectionModel;

import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;



/**
 * Created by hp on 10.09.2017.
 */
//https://maps.googleapis.com/maps/api/directions/json?origin=&destination=&waypoints=optimize:true|&mode=driving
public interface Face {
    @GET("maps/api/directions/json")
    Call<DirectionModel>  getData(@Query("origin") String originName,
                                  @Query("destination") String destinationName,
                                  @Query("waypoints") String waypointsName,
                                  @Query("mode") String modeName);

}
