package udb.edu.sv.guia4.personasdbvc190544;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import udb.edu.sv.guia4.personasdbvc190544.datos.Persona;
import android.view.View;
import android.widget.RadioButton;

public class AddPersonaActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    EditText edtDUI, edtNombre;
    RadioButton rbtnMasc,rbtnFem,rbtnNo;
    String key="",nombre="",dui="",accion="",genero="",fecha="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();
    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        rbtnMasc=findViewById(R.id.Masculino);
        rbtnFem=findViewById(R.id.Femenino);
        rbtnNo=findViewById(R.id.No);



        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        genero=datos.getString("genero");
        nombre=datos.getString("nombre");
        fecha=datos.getString("fecha");
        accion=datos.getString("accion");
        // Agregando simples String
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        //Agregando Genero
        switch (genero){
            case "Masculino":
                rbtnMasc.setChecked(true);
                break;
            case "Femenino":
                rbtnFem.setChecked(true);
                break;
            case "No":
                rbtnNo.setChecked(true);
                break;
        }

    }

    String date;
    String genre;
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Masculino:
                if (checked)
                    genre="Masculino";
                    break;
            case R.id.Femenino:
                if (checked)
                    genre="Femenino";
                    break;
            case R.id.No:
                if (checked)
                    genre="No";
                break;
        }
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String fecha=date;
        String genero=genre;
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,genero,fecha);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        date=i+"-"+i1+"-"+i2;
    }
}