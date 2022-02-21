package sv.edu.udb.contador_vc190544;

import android.content.Intent;

import androidx.lifecycle.ViewModel;

public class ModeloNumero extends ViewModel {
    private int numerito;

    public int getNumber(){
        if (numerito==0){
            numerito=0;
            getNum();
        }
        return numerito;
    }

    private void setNumerito(int numerito){
        this.numerito=numerito;
    }

    private void getNum(){
        Intent intent=new Intent();
        //numerito= Integer.parseInt(intent.getStringExtra("tv_cont"));
        //numerito=0;
        numerito=intent.getIntExtra("cont",0);
    }
}
