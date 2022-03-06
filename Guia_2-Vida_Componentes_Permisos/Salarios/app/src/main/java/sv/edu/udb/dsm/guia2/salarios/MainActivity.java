package sv.edu.udb.dsm.guia2.salarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_nombre;
    private EditText et_horas;
    private Button bt_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre=findViewById(R.id.et_name);
        et_horas=findViewById(R.id.et_horas);
        bt_res=findViewById(R.id.btn_calcular);

        bt_res.setOnClickListener(clickListener);
    }

    //Observador para el botón
    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /**
             * Se ejecuta el método de contador. Independientemente del resultado
             * se guarda el valor en el ViewModel
             */
            PasandoDatos(view);
        }
    };

    private void PasandoDatos(View v){
        Intent intent=new Intent(this,Resultado.class);
        intent.putExtra("txtName",et_nombre.getText().toString());
        intent.putExtra("txtHours",et_horas.getText().toString());
        startActivity(intent);
    }
}