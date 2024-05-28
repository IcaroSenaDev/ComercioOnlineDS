package com.example.comercioonlineds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TrocarSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trocar_senha);
    }

    public void voltartelalogin (View view) {

        Intent in = new Intent(TrocarSenha.this, TelaLogin.class);
        startActivity(in);

    }
}