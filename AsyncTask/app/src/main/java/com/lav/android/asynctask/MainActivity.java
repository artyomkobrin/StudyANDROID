package com.lav.android.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] integers = null;
    int Clicks = 0;
    ProgressBar indicatorBar;
    TextView statusView;
    TextView clicksView;
    Button progressBTN;
    Button clicksBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        integers = new int[100];
        for(int i=0;i<100;i++) {
            integers[i] = i + 1;
    }
        indicatorBar = (ProgressBar) findViewById(R.id.indicator);
        statusView = (TextView) findViewById(R.id.statusView);
        progressBTN = (Button) findViewById(R.id.progressBtn);
        progressBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ProgressTask().execute();
            }
        });

        clicksView = (TextView) findViewById(R.id.clicksView);
        clicksBTN = (Button) findViewById(R.id.clicksBtn);
        clicksBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Clicks++;
                clicksView.setText("Clicks: " + Clicks);
            }
        });
    }

    class ProgressTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... unused) {
            for (int i = 0; i<integers.length;i++) {

                publishProgress(i);
                SystemClock.sleep(400);
            }
            return(null);
        }
        @Override
        protected void onProgressUpdate(Integer... items) {
            indicatorBar.setProgress(items[0]+1);
            statusView.setText("Статус: " + String.valueOf(items[0]+1));
        }
        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(getApplicationContext(), "Задача завершена", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
