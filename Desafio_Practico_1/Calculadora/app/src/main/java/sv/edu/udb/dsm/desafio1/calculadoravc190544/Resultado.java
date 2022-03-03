package sv.edu.udb.dsm.desafio1.calculadoravc190544;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado=(TextView) findViewById(R.id.tv);

        Bundle bundle=getIntent().getExtras();
        String resultado=bundle.getString("txtRes");

        tvResultado.setText(resultado);
    }

    public void Finalizar(View v){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}