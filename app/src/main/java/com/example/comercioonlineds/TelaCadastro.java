package com.example.comercioonlineds;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class TelaCadastro extends AppCompatActivity {

    private EditText email_cadastro;
    private EditText senha_cadastro;
    private EditText confirmarsenha_cadastro;
    private Button cadastrar_btn_cadastro;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        mAuth = FirebaseAuth.getInstance();

        email_cadastro = findViewById(R.id.email_cadastro);
        senha_cadastro = findViewById(R.id.senha_cadastro);
        confirmarsenha_cadastro = findViewById(R.id.confirmarsenha_cadastro);
        cadastrar_btn_cadastro = findViewById(R.id.cadastrar_btn_cadastro);
        email_cadastro = findViewById(R.id.email_cadastro);

        cadastrar_btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email_cadastro.getText().toString();
                String senha = senha_cadastro.getText().toString();
                String confirmarsenha = confirmarsenha_cadastro.getText().toString();

                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(senha) || !TextUtils.isEmpty(confirmarsenha)){
                    if(senha.equals(confirmarsenha)){

                        mAuth.createUserWithEmailAndPassword(email,senha)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if(task.isSuccessful()){
                                            telaprodutos();
                                        }
                                        else {
                                            String error = task.getException().getMessage();
                                            Toast.makeText(TelaCadastro.this, "" + error, Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                    }else {
                        Toast.makeText(TelaCadastro.this, "A senha deve ser a mesma em ambos os campos!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void telaprodutos () {

        Intent in = new Intent(TelaCadastro.this, TelaProdutosServicos.class);
        startActivity(in);
        finish();

    }
}