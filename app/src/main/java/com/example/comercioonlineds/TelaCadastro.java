package com.example.comercioonlineds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
    }

    public void telalogin (View view) {

        Intent in = new Intent(TelaCadastro.this, TelaLogin.class);
        startActivity(in);

    }
}