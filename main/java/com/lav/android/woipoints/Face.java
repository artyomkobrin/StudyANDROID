package com.lav.android.woipoints;


import com.lav.android.woipoints.models.GeocodedWaypoint;

import java.util.Map;

import retrofit2.Call;


import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by hp on 07.09.2017.
 */

//https://maps.googleapis.com/maps/api/directions/json?origin=Берёза&destination=Брест&waypoints=optimize:true|Кобрин|Жабинка|


public interface Face {

    @FormUrlEncoded
    @POST("/maps/api/directions/json")
    Call<GeocodedWaypoint> getParse(@FieldMap Map<String,String> map);


}
