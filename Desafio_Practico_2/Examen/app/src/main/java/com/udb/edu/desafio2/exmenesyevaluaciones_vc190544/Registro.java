package com.udb.edu.desafio2.exmenesyevaluaciones_vc190544;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    private EditText emailET,passwordET;
    private Button regBtn,exitBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth=FirebaseAuth.getInstance();

        InicializandoUI();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Registro.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerNewUser(){
        String email,password;
        email=emailET.getText().toString();
        password=passwordET.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Porfavor ingrese su correo...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Porfavor ingrese su contraseña...", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Registro.this, "Registro Completado", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Registro.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Registro.this, "El Registro ha fallado! Intentelo nuevamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void InicializandoUI(){
        emailET=findViewById(R.id.etUser);
        passwordET=findViewById(R.id.etPassword);
        regBtn=findViewById(R.id.btnReg);
        exitBtn=findViewById(R.id.btnExit);
    }
}