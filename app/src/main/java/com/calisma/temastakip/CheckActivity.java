package com.calisma.temastakip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    TextView textViewBelirtiIptal;
    CheckBox checkBoxAtes, checkBoxOksuruk, checkBoxKokutat;
    Button buttonBelirtiGonder;

    int data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        textViewBelirtiIptal = findViewById(R.id.textViewBelirtiIptal);

        checkBoxAtes = findViewById(R.id.checkBoxAtes);
        checkBoxOksuruk = findViewById(R.id.checkBoxOksuruk);
        checkBoxKokutat = findViewById(R.id.checkBoxKokuTat);

        buttonBelirtiGonder = findViewById(R.id.buttonBelirtiGonder);

        AlertDialog.Builder builder = new AlertDialog.Builder(CheckActivity.this);

        textViewBelirtiIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCancel = new Intent(CheckActivity.this, HomeActivity.class);
                startActivity(intentCancel);
            }
        });


        buttonBelirtiGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBoxAtes.isChecked() || checkBoxOksuruk.isChecked() || checkBoxKokutat.isChecked()) {
                     Intent intent = new Intent(CheckActivity.this,TracingActivity.class);
                     data = 1;
                     intent.putExtra("sayi",data);
                     startActivity(intent);
                }

                if (checkBoxAtes.isChecked() && checkBoxOksuruk.isChecked() && checkBoxKokutat.isChecked()) {

                    builder.setTitle("Uyarı!");
                    builder.setMessage("Acilen Hastaneye Gidiniz!!!");
                    builder.show();

                } else if (checkBoxAtes.isChecked()) {
                    builder.setTitle("Uyarı!");
                    builder.setMessage("Ates Kontrolu Yapın");
                    builder.show();
                } else if (checkBoxOksuruk.isChecked()) {
                    builder.setTitle("Uyarı!");
                    builder.setMessage("Oksurugunuz uzun sure devam ediyorsa hasteneye basvurun!");
                    builder.show();
                } else if (checkBoxKokutat.isChecked()) {
                    builder.setTitle("Uyarı!");
                    builder.setMessage("Hastaneye gidiniz ve temaslı oldugunuz kisileri uyarın!");
                    builder.show();
                } else {
                    builder.setTitle("Boş Geçilemez!");
                    builder.setMessage("Herhangi bir belirti seçmediniz.");
                    builder.show();
                }

            }
        });

    }
}