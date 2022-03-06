package sv.edu.udb.dsm.guia3.calculadora_gridlayout_vc190544;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pantalla;
    private TextView clicked;
    private TextView no1;
    private TextView no2;
    private TextView no3;
    private TextView no4;
    private TextView no5;
    private TextView no6;
    private TextView no7;
    private TextView no8;
    private TextView no9;
    private TextView no0;
    private TextView punto;
    private TextView del;
    private TextView ac;
    private TextView clickedDEL;

    private String number="";

    private View.OnClickListener remover=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clickedDEL=findViewById(view.getId());
            if (clickedDEL==del){
                number=number.substring(0,number.length()-1);
            }else{
                number="";
            }
            pantalla.setText(number);
        }
    };

    private View.OnClickListener adder=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clicked=findViewById(view.getId());
            number+=clicked.getText();
            //Toast.makeText(getApplicationContext(),"Agregado numero: "+clicked.getText(),Toast.LENGTH_SHORT).show();
            pantalla.setText(number);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Agregando todos los TextView en el codigo
         * creando sus eventos de click respectivos
         */
        pantalla=findViewById(R.id.Calc);
        no1=findViewById(R.id.numero_1);
        no0=findViewById(R.id.cero);
        no2=findViewById(R.id.numero_2);
        no3=findViewById(R.id.numero_3);
        no4=findViewById(R.id.numero_4);
        no5=findViewById(R.id.numero_5);
        no6=findViewById(R.id.numero_6);
        no7=findViewById(R.id.numero_7);
        no8=findViewById(R.id.numero_8);
        no9=findViewById(R.id.numero_9);
        punto=findViewById(R.id.punto);
        del=findViewById(R.id.del);
        ac=findViewById(R.id.AC);
        no0.setOnClickListener(adder);
        no1.setOnClickListener(adder);
        no2.setOnClickListener(adder);
        no3.setOnClickListener(adder);
        no4.setOnClickListener(adder);
        no5.setOnClickListener(adder);
        no6.setOnClickListener(adder);
        no7.setOnClickListener(adder);
        no8.setOnClickListener(adder);
        no9.setOnClickListener(adder);
        punto.setOnClickListener(adder);
        del.setOnClickListener(remover);
        ac.setOnClickListener(remover);
    }

}