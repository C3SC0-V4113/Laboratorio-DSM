package sv.edu.udb.contador_vc190544;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv_cont;
    private Button btnCont;
    private int cont;
    private ModeloNumero modelo;

    //Observador para el botón
    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /**
             * Se ejecuta el método de contador. Independientemente del resultado
             * se guarda el valor en el ViewModel
             */
            Contador();
            modelo.getNumerito().setValue(cont);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se inicializan los componentes
        tv_cont=(TextView) findViewById(R.id.tv_cont);
        btnCont=(Button) findViewById(R.id.btnCont);
        cont=0;
        //Se agrega el metodo onClick al botón
        btnCont.setOnClickListener(clickListener);
        //Se inicializa el contador ViewModel
        initCounter();

    }

    private void initCounter(){
        //Iniciando ViewModel
        modelo=new ViewModelProvider(this).get(ModeloNumero.class);
        //Obteniendo observador
        final Observer<Integer> cambio =new Observer<Integer>() {
            /**
             *En caso de cambio del ViewModel guardado, se actualizará
             * la interfaz y la variable de contador se volvera
             * la guardada
             */
            @Override
            public void onChanged(@Nullable final Integer inte) {
                tv_cont.setText(inte+"");
                cont=inte;
            }
        };
        //En caso de guardado, se obtiene el valor
        modelo.getNumerito().observe(this,cambio);
    }

    public void Contador(){
        /**
         * En caso de llegar a 9, el contador
         * volverá a cero y actualizará la UI
         */
        if (cont==9){
            cont=0;
        }else {
            cont++;
        }
        tv_cont.setText(cont+"");
    }
}
