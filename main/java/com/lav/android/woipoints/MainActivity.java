package com.lav.android.woipoints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lav.android.woipoints.models.GeocodedWaypoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    private final String URL = "https://maps.googleapis.com";
    private final String KEY = "AIzaSyC6EuUNIr6fJT_st5FFvBDIJzrJqHafBuA";

    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();

    private Face obj = retrofit.create(Face.class);

    //https://maps.googleapis.com/maps/api/directions/json?origin=Берёза&destination=Брест&waypoints=optimize:true|Кобрин|Жабинка|

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Map<String,String> mapJson = new HashMap<String, String>();
                mapJson.put("origin","Берёза");
                mapJson.put("destination","Брест");
                mapJson.put("waypoints","optimize:true|Кобрин|Жабинка|");
                mapJson.put("key",KEY);

                Call<GeocodedWaypoint> call = obj.getParse(mapJson);

                try {
                    Response<GeocodedWaypoint> response = call.execute();

                    Map<String,String> map = gson.fromJson(response.body().toString(),Map.class);

                    for (Map.Entry e : map.entrySet()){

                        System.out.println(e.getKey()+" " + e.getValue());

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}

