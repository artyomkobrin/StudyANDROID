package com.lav.android.gmailapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lav.android.gmailapi.Models.Bounds;
import com.lav.android.gmailapi.Models.Distance;
import com.lav.android.gmailapi.Models.EndLocation;
import com.lav.android.gmailapi.Models.GeocodedWaypoint;
import com.lav.android.gmailapi.Models.Model;
import com.lav.android.gmailapi.Models.Route;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Button button;

    //private  final String KEY="AIzaSyCS_hwLh4bQm-Q13Acii5KW6DyHNAvFBHE";

    private Gson gson = new GsonBuilder().create();


   private Retrofit retrofit = new Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create(gson))
           .baseUrl("https://maps.googleapis.com/")
           .build();

    private GMapsApi intf = retrofit.create(GMapsApi.class);



    //https://maps.googleapis.com/maps/api/directions/json?origin=Кобрин&destination=Брест


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intf.trans("Кобрин","брест").enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call call, Response response) {

                        response.body();//.getRoutes().get(0).getLegs().get(0);
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {

                    }
                });
            }
        });
    }
}
