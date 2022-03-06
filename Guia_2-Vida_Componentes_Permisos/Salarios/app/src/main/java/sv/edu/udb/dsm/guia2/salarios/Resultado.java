package sv.edu.udb.dsm.guia2.salarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultado extends AppCompatActivity {

    private Button btn_salir;
    private TextView tv_name;
    private TextView tv_hours;
    private TextView tv_salario;
    private double salario;
    private TextView tv_isss;
    private double isss;
    private TextView tv_afp;
    private double afp;
    private TextView tv_renta;
    private double renta;
    private TextView tv_total;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btn_salir=findViewById(R.id.btn_salir);
        tv_name=findViewById(R.id.name);
        tv_hours=findViewById(R.id.hours);
        tv_salario=findViewById(R.id.salario);
        tv_isss=findViewById(R.id.isss);
        tv_afp=findViewById(R.id.afp);
        tv_renta=findViewById(R.id.renta);
        tv_total=findViewById(R.id.total);

        btn_salir.setOnClickListener(clickListener);

        Bundle bundle=getIntent().getExtras();
        String nombre=bundle.getString("txtName");
        Integer horas= Integer.valueOf(bundle.getString("txtHours"));

        Llenando(nombre,horas);
    }

    //Observador para el botón
    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finalizar(view);
        }
    };

    public void Llenando(String nombre,Integer horas){
        tv_name.setText(nombre);
        tv_hours.setText(horas.toString());
        salario=8.5*Double.parseDouble(String.valueOf(horas));
        tv_salario.setText(salario+"");
        isss=salario*0.02;
        tv_isss.setText(isss+"");
        afp=salario*0.03;
        tv_afp.setText(afp+"");
        renta=salario*0.04;
        tv_renta.setText(renta+"");
        total=salario-isss-afp-renta;
        tv_total.setText(total+"");
    }

    public void finalizar(View v){
        finish();
    }
}