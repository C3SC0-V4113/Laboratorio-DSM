package com.udb.edu.guia5.appcontentprovider_vc190544;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText etcarnet,etnombre,etapellido;
    Button btnadd,btnexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        inicializar();
    }

    private void inicializar(){
        etcarnet=findViewById(R.id.etCarnet);
        etnombre=findViewById(R.id.etNombre);
        etapellido=findViewById(R.id.etApellido);
        btnadd=findViewById(R.id.btnGuardar);
        btnexit=findViewById(R.id.btnSalir);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddStudent.this, "Vamoooos", Toast.LENGTH_SHORT).show();
                AddingStudent();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AddingStudent(){
        String carnet=etcarnet.getText().toString();
        String nombre=etnombre.getText().toString();
        String apellido=etapellido.getText().toString();
        ContentValues values = new ContentValues();
        Toast.makeText(this, carnet+"-"+nombre+"-"+apellido, Toast.LENGTH_SHORT).show();
        values.put(StudentsContract.Columnas.NOMBRE, nombre);
        values.put(StudentsContract.Columnas.APELLIDO, apellido);
        values.put(StudentsContract.Columnas.CARNET, carnet);
        getContentResolver().insert(StudentsContract.CONTENT_URI,values);

        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}