package com.example.comercioonlineds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    public void telaprodutos (View view) {

        Intent in = new Intent(TelaLogin.this, TelaProdutosServicos.class);
        startActivity(in);

    }

    public void telaregistro (View view) {

        Intent in = new Intent(TelaLogin.this, TelaCadastro.class);
        startActivity(in);

    }

    public void recuperarsenha (View view) {

        Intent in = new Intent(TelaLogin.this, TelaRecuperarSenha.class);
        startActivity(in);

    }
}