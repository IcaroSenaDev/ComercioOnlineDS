package com.example.comercioonlineds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VerificarEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_email);
    }

    public void trocadesenha(View view) {

        Intent in = new Intent(this, TrocarSenha.class);
        startActivity(in);

    }
}