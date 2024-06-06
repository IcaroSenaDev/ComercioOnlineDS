package com.example.comercioonlineds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TelaLogin extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button login_btn;
    private Button cadastro_btn;
    private Button recuperarsenha_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById (R.id.email);
        senha = findViewById (R.id.senha);
        login_btn = findViewById (R.id.login_btn);
        cadastro_btn = findViewById (R.id.cadastro_btn);
        recuperarsenha_btn = findViewById (R.id.recuperarsenha_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail = email.getText().toString();
                String loginSenha = senha.getText().toString();

                if (!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha));
                mAuth.signInWithEmailAndPassword(loginEmail, loginSenha)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    telaprodutos();
                                }
                                else{
                                    String error = task.getException().getMessage();
                                    Toast.makeText(TelaLogin.this, "Email ou senha incorreto! " + error, Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });
    }

    public void telaprodutos () {

        Intent in = new Intent(TelaLogin.this, TelaProdutosServicos.class);
        startActivity(in);
        finish();

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