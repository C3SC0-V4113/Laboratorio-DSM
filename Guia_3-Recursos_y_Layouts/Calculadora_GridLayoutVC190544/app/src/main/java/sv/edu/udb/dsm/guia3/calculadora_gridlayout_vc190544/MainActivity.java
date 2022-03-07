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
    private TextView mas;
    private TextView menos;
    private TextView por;
    private TextView entre;
    private TextView operacion;
    private Integer operacion_plus;
    private TextView tv_opera;
    private TextView opera;
    private TextView igual;

    private String number="";
    private String operando1;
    private String operando2;
    private Double resultado;

    private View.OnClickListener result=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /**
             * Se obtienen los dos valores y en base a la operación
             * seleccionada se efectua e imprime la respuesta
             */
            operando2=number;
            double n1=Double.parseDouble(operando1);
            double n2=Double.parseDouble(operando2);
            switch (operacion_plus){
                case 0:
                    resultado=n1+n2;
                    break;
                case 1:
                    resultado=n1-n2;
                    break;
                case 2:
                    resultado=n1/n2;
                    break;
                case 3:
                    resultado=n1*n2;
                    break;
            }
            limpiar();
            tv_opera.setText("Ans: "+resultado);
            pantalla.setText(resultado.toString());
            operacion_plus=5;
        }
    };

    private View.OnClickListener operation=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /**
             * Se obtiene el id del botón clickeado
             * se obtiene su signo y en base a esto se
             * escoge que operacion es, además se crea
             * otra variable para guardar el tipo de operación
             */
            operacion=findViewById(view.getId());
            operando1=number;
            opera.setText(operando1);
            switch (operacion.getText().toString()){
                case "+":
                    operacion_plus=0;
                    tv_opera.setText("SUMA");
                    limpiar();
                    break;
                case "-":
                    operacion_plus=1;
                    tv_opera.setText("RESTA");
                    limpiar();
                    break;
                case "÷":
                    operacion_plus=2;
                    tv_opera.setText("DIVISIÓN");
                    limpiar();
                    break;
                case "x":
                    operacion_plus=3;
                    tv_opera.setText("MULTIPLICACIÓN");
                    limpiar();
                    break;
                default:
                    Toast.makeText(getApplicationContext(),"Seleccione una operación",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private View.OnClickListener remover=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /**
             * Se obtiene el id del botón pulsado, se guarda el botón
             * en una variable temporal TextView, se obtiene el texto
             * si es el indicado para el botón individual se borra el
             * ultimo caracter, de lo contrario se limpia la pantalla
             */
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
            /**
             * Se obtiene el id del botón pulsado, se guarda el botón
             * en una variable temporal TextView, se obtiene el texto
             * en este (número o signo de punto).
             * Y se agrega a la pantalla
             */
            clicked=findViewById(view.getId());
            number+=clicked.getText();
            pantalla.setText(number);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Agregando todos los TextView en el codigo
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
        mas=findViewById(R.id.signo_mas);
        menos=findViewById(R.id.signo_menos);
        por=findViewById(R.id.signo_por);
        entre=findViewById(R.id.dividir);
        tv_opera=findViewById(R.id.operacion);
        opera=findViewById(R.id.number1);
        igual=findViewById(R.id.signo_igual);
        /**
         * Añadido su metodo a todos los TextView
         * que añaden algo a la pantalla
         */
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
        /**
         * Añadido su metodo a todos los TextView
         * que remueven algo de la pantalla
         */
        del.setOnClickListener(remover);
        ac.setOnClickListener(remover);
        /**
         * Añadido su metodo a todos los TextView
         * que son operadores
         */
        mas.setOnClickListener(operation);
        menos.setOnClickListener(operation);
        entre.setOnClickListener(operation);
        por.setOnClickListener(operation);
        /**
         * Añadido metodo al TextView que
         * da el resultado
         */
        igual.setOnClickListener(result);
    }

    private void limpiar(){
        /**
         * Limpiando pantalla y
         * reiniciando la variable
         * temporal
         */
        pantalla.setText("");
        number="";
    }

}