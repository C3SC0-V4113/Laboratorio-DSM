package sv.edu.udb.dsm.desafio1.calculadoravc190544;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1f1;
    private EditText et2f1;
    private EditText et1f2;
    private EditText et2f2;
    private double v1;
    private double v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1f1=findViewById(R.id.et1f1);
        et2f1=findViewById(R.id.et2f1);
        et1f2=findViewById(R.id.et1f2);
        et2f2=findViewById(R.id.et2f2);
    }

    public void fracciondouble(){
        String numerador1=et1f1.getText().toString();
        String denominador1=et2f1.getText().toString();
        String numerador2=et1f2.getText().toString();
        String denominador2=et2f2.getText().toString();
        v1 = Double.parseDouble(numerador1)/Double.parseDouble(denominador1);
        v2 = Double.parseDouble(numerador2)/Double.parseDouble(denominador2);
    }

    public String doublefraccion(double resu){
        boolean isNeg=false;
        String cadena="";
        if (resu<0){
            isNeg=true;
            resu=resu*-1;
        }
        String s=String.valueOf(resu);
        int digitDec=s.length()-1-s.indexOf('.');

        int denom=1;
        for (int i = 0; i < digitDec; i++) {
            resu*=10;
            denom*=10;
        }

        int num=(int) Math.round(resu);

        if (!isNeg){
            cadena=String.valueOf(num) + "/" + String.valueOf(denom);
        } else{
            cadena="-"+String.valueOf(num) + "/" + String.valueOf(denom);
        }

        Intent i=new Intent(this,Resultado.class);
        i.putExtra("txtRes",cadena);
        startActivity(i);

        return cadena;
    }

    //Este método se ejecutará cuando se presione el botón
    public void sumar(View view) {
        fracciondouble();
        double suma=v1+v2;
        String resu=doublefraccion(suma);
    }

    public void restar(View view) {
        fracciondouble();
        double resta=v1-v2;
        String resu=doublefraccion(resta);
    }

    public void multiplicar(View view) {
        fracciondouble();
        double multiplicacion=v1*v2;
        String resu=doublefraccion(multiplicacion);
    }

    public void division(View view) {
        fracciondouble();
        double dividir=v1/v2;
        String resu=doublefraccion(dividir);
    }

}