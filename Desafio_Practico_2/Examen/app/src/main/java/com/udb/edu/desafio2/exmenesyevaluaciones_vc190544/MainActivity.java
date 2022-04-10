package com.udb.edu.desafio2.exmenesyevaluaciones_vc190544;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText emailET,passwordET;
    private Button loginBtn, registerBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        inicializandoUI();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registro.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccount();
            }
        });
    }

    private void loginUserAccount(){
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

        if (email.equals("administrador") && password.equals("dsm104")){
            Toast.makeText(MainActivity.this,"Bienvenido Administrador",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,DashboardAdmin.class);
            startActivity(intent);
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Inicio de Sesión Exitoso",Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "El Inicio de Sesión ha fallado! Porfavor, volver a intentar", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void inicializandoUI(){
        emailET=findViewById(R.id.etUser);
        passwordET=findViewById(R.id.etPassword);

        loginBtn=findViewById(R.id.btnLog);
        registerBtn=findViewById(R.id.btnReg);
    }
}