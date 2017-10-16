package com.example.lyavon.tourism;



import android.os.AsyncTask;

import com.example.lyavon.tourism.Models.DirectionModel;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 13.09.2017.
 */

 class ParseProvider extends AsyncTask<Void, Void, ArrayList<String>> {

     ArrayList<String> startLocLat = new ArrayList<String>();


   /* class MyTask  extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Begin");
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            tvInfo.setText("End");
        }
    }*/
   @Override
   protected void onPreExecute() {
       super.onPreExecute();
       System.out.println("Begin");
   }

    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        Retrofit2App.getApi().getData("Брест", "Берёза", "optimize:true|Кобрин|Жабинка", "driving")
                .enqueue(new Callback<DirectionModel>() {

                    @Override
                    public void onResponse(Call<DirectionModel> call, Response<DirectionModel> response) {


                        for (int rou = 0; rou < response.body().getRoutes().size(); rou++) {
                            for (int leg = 0; leg < response.body().getRoutes().get(rou).getLegs().size() - 1; leg++) {

                                for (int step = 0; step < response.body().getRoutes().get(rou).getLegs().get(leg).getSteps().size() - 1; step++) {

                                    startLocLat.add(response.body().getRoutes().get(rou).getLegs().get(leg).getSteps()
                                            .get(step).getStartLocation().getLat().toString());

                                }
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<DirectionModel> call, Throwable t) {

                    }

                });

        return  startLocLat;


    }
    @Override
    protected void onPostExecute(ArrayList<String> startLocLat) {
        super.onPostExecute(startLocLat);
        System.out.println("End");
    }


}

/*Retrofit2App.getApi().getData("Брест", "Берёза", "optimize:true|Кобрин|Жабинка", "driving")
        .enqueue(new Callback<DirectionModel>() {

@Override
public void onResponse(Call<DirectionModel> call, Response<DirectionModel> response) {


        for (int rou = 0; rou < response.body().getRoutes().size(); rou++) {
        for (int leg = 0; leg < response.body().getRoutes().get(rou).getLegs().size() - 1; leg++) {

        for (int step = 0; step < response.body().getRoutes().get(rou).getLegs().get(leg).getSteps().size() - 1; step++) {

        startLocLat.add(response.body().getRoutes().get(rou).getLegs().get(leg).getSteps()
        .get(step).getStartLocation().getLat().toString());

        }
        }
        }
        }


@Override
public void onFailure(Call<DirectionModel> call, Throwable t) {

        }

        });

        return  startLocLat;
*/