package com.calisma.temastakip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    TextView textViewAyarlarIptal, textViewBluetooth;

    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textViewAyarlarIptal = findViewById(R.id.textViewAyarlarIptal);
        textViewBluetooth = findViewById(R.id.textViewBluetooth);

        switch1 = findViewById(R.id.switch1);

        textViewAyarlarIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentAyarlarIptal = new Intent(SettingsActivity.this, HomeActivity.class);
                startActivity(intentAyarlarIptal);
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switch1.isChecked()){
                    textViewBluetooth.setText("Ayar: Açık");
                    Toast.makeText(SettingsActivity.this, "Bluetooth Connection Active", Toast.LENGTH_SHORT).show();
                }
                else{
                    textViewBluetooth.setText("Ayar: Kapalı");
                }

            }
        });


    }
}