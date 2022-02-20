package sv.edu.udb.contador_vc190544;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_cont;
    private Button btnCont;
    private int cont;

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Contador();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_cont=(TextView) findViewById(R.id.tv_cont);
        btnCont=(Button) findViewById(R.id.btnCont);
        btnCont.setOnClickListener(clickListener);

        initCounter();
        
        ModeloNumero modelo=new ViewModelProvider(this).get(ModeloNumero.class);
        tv_cont.setText(modelo.getNumber()+"");
    }

    private void initCounter(){
        cont=0;
        tv_cont.setText(cont+"");
    }

    public void Contador(){
        if (cont==9){
            cont=0;
        }else {
            cont++;
        }
        tv_cont.setText(cont+"");
    }
}