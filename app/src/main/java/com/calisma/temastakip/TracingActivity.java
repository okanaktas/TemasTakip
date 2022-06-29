package com.calisma.temastakip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class TracingActivity extends AppCompatActivity {

    TextView textViewTakipIptal, textViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing);

        textViewTakipIptal = findViewById(R.id.textViewTakipIptal);
        textViewCounter = findViewById(R.id.textViewCounter);

        textViewTakipIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentTakipIptal = new Intent(TracingActivity.this, HomeActivity.class);
                startActivity(intentTakipIptal);

            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle !=null) {
            int gelenSayi = bundle.getInt("sayi");
            if (gelenSayi == 1) {
                new CountDownTimer(450000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        textViewCounter.setText("" + String.format("'' %d Gün '' Boyunca Kendizi İzole Ediniz",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                    }
                }.start();
            } else {
                textViewCounter.setText("Herhangi bir belirti teşhis edilmedi");
            }
        }
    }


}