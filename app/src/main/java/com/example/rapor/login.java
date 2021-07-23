package com.example.rapor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rapor.model.login.LData;
import com.example.rapor.model.login.Login;
import com.example.rapor.retrofit.ApiEndpoint;
import com.example.rapor.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText etemail, etpassword;
    Button login;
    String email, password;
    ApiEndpoint apiEndpoint;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.email);
        etpassword = findViewById(R.id.password);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                email = etemail.getText().toString();
                password = etpassword.getText().toString();
                login(email,password);
                break;
        }
    }

    private void login(String email, String password) {

        apiEndpoint = ApiService.getService().create(ApiEndpoint.class);
        Call<Login> loginCall = apiEndpoint.loginResponse(email,password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                    sessionManager = new SessionManager(login.this);
                    LData ldata = response.body().getLData();
                    sessionManager.createLoginSession(ldata);

                    Intent dashboardintent = new Intent(login.this, dashboard.class);
                    startActivity(dashboardintent);
                }else {
                    Toast.makeText(login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });

    }
}