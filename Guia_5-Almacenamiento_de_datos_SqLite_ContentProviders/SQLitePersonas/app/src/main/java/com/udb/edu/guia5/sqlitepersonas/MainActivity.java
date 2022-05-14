package com.udb.edu.guia5.sqlitepersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3,etApellido,etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        etApellido=findViewById(R.id.etApellido);
        et3=findViewById(R.id.et3);
        etTelefono=findViewById(R.id.telefono);
    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String apellido=etApellido.getText().toString();
        String pre = et3.getText().toString();
        String tel=etTelefono.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("codigo", cod);
        registro.put("nombres", descri);
        registro.put("edad", pre);
        registro.put("apellidos",apellido);
        registro.put("telefono",tel);

        try {
            bd.insertOrThrow("personas", null, registro);
            bd.close();
            et1.setText("");
            et2.setText("");
            etApellido.setText("");
            et3.setText("");
            etTelefono.setText("");
            Toast.makeText(this, "Se cargaron los datos de la persona",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se cargaron los datos del artículo" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = bd.rawQuery("select nombres,apellidos,edad,telefono from personas where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            etApellido.setText(fila.getString(1));
            et3.setText(fila.getString(2));
            etTelefono.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe una persona con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = et2.getText().toString();
        Cursor fila = bd.rawQuery("select codigo,apellidos,edad,telefono from personas where nombres='" + descri +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            etApellido.setText(fila.getString(1));
            et3.setText(fila.getString(2));
            etTelefono.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe una persona con dicha nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();
        int cant = bd.delete("personas", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        etApellido.setText("");
        et3.setText("");
        etTelefono.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró la persona con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona con dicho código",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String apellido=etApellido.getText().toString();
        String pre = et3.getText().toString();
        String tel=etTelefono.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("nombres", descri);
        registro.put("apellidos",apellido);
        registro.put("edad", pre);
        registro.put("telefono",tel);
        int cant = bd.update("personas", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe una persona con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }
}