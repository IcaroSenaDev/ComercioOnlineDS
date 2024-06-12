package com.example.comercioonlineds;

import static com.example.comercioonlineds.R.id.email;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class TelaRecuperarSenha extends AppCompatActivity {

    private EditText emailrecuperar;
    private Button enviaremail_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_recuperar_senha);

        mAuth = FirebaseAuth.getInstance();
        emailrecuperar = findViewById(R.id.emailrecuperar);
        enviaremail_btn = findViewById(R.id.enviaremail_btn);

        enviaremail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String recuperarEmail = emailrecuperar.getText().toString();

                if (!TextUtils.isEmpty(recuperarEmail));
                mAuth.sendPasswordResetEmail(recuperarEmail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful()){
                                    Toast.makeText(TelaRecuperarSenha.this, "Enviamos uma mensagem para o seu e-mail!", Toast.LENGTH_SHORT).show();
                                    telaloginvolta();
                                }
                                else{
                                    String error = task.getException().getMessage();
                                    Toast.makeText(TelaRecuperarSenha.this, "Email ou senha incorretos!" + error, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }

    public void telaloginvolta() {

        Intent in = new Intent(TelaRecuperarSenha.this, TelaLogin.class);
        startActivity(in);

    }
}