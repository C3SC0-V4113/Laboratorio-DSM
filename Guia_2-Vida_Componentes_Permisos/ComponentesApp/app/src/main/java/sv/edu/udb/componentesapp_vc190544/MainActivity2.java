package sv.edu.udb.componentesapp_vc190544;

import androidx.appcompat.app.AppCompatActivity;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNombre=(TextView)findViewById(R.id.textViewNombre);
        tvEdad=(TextView)findViewById(R.id.textViewEdad);

        Bundle bundle=getIntent().getExtras();
        String nombre=bundle.getString("txtNombre");
        String edad=bundle.getString("txtEdad");

        tvNombre.setText(nombre);
        tvEdad.setText(edad);
    }

    public void finalizar(View v){
        finish();
    }
}