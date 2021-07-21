package com.example.rapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profil extends AppCompatActivity {
    TextView nama, nis, username, email, alamat, ganti;
    Button kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        nama = (TextView) findViewById(R.id.namasiswa);
        nis = (TextView) findViewById(R.id.nis);
        username = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        alamat = (TextView) findViewById(R.id.alamat);
        ganti = (TextView) findViewById(R.id.gantipassword);
        kembali = (Button) findViewById(R.id.kembali);

        ganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gantipassIntent = new Intent(profil.this, gantipass.class);
                startActivity(gantipassIntent);
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboardIntent = new Intent(profil.this, dashboard.class);
                startActivity(dashboardIntent);
            }
        });
    }
}