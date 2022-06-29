package com.calisma.temastakip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    ImageView imageViewCheck, imageViewTracing, imageViewInfo,imageViewSettings;
    TextView textViewCheck, textViewTracing, textViewInfo, textViewSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageViewCheck = findViewById(R.id.imageViewCheck);
        imageViewTracing = findViewById(R.id.imageViewTracing);
        imageViewInfo = findViewById(R.id.imageViewInfo);
        imageViewSettings = findViewById(R.id.imageViewSettings);

        textViewCheck = findViewById(R.id.textViewCheck);
        textViewTracing = findViewById(R.id.textViewTracing);
        textViewInfo = findViewById(R.id.textViewInfo);
        textViewSettings = findViewById(R.id.textViewSettings);


        View.OnClickListener generalTextListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){

                    case R.id.textViewCheck:
                    case R.id.imageViewCheck:
                        Intent intentCheck = new Intent(HomeActivity.this, CheckActivity.class);
                        startActivity(intentCheck);

                        break;

                    case R.id.textViewTracing:
                    case R.id.imageViewTracing:
                        Intent intentTracing = new Intent(HomeActivity.this, TracingActivity.class);
                        startActivity(intentTracing);

                        break;

                    case R.id.textViewInfo:
                    case R.id.imageViewInfo:
                        Intent intentInfo = new Intent(HomeActivity.this, InfoActivity.class);
                        startActivity(intentInfo);

                        break;

                    case R.id.textViewSettings:
                    case R.id.imageViewSettings:
                        Intent intentSettings = new Intent(HomeActivity.this, SettingsActivity.class);
                        startActivity(intentSettings);

                        break;

                }


            }
        };

        textViewCheck.setOnClickListener(generalTextListener);
        textViewTracing.setOnClickListener(generalTextListener);
        textViewInfo.setOnClickListener(generalTextListener);
        textViewSettings.setOnClickListener(generalTextListener);
        imageViewCheck.setOnClickListener(generalTextListener);
        imageViewTracing.setOnClickListener(generalTextListener);
        imageViewInfo.setOnClickListener(generalTextListener);
        imageViewSettings.setOnClickListener(generalTextListener);



    }
}