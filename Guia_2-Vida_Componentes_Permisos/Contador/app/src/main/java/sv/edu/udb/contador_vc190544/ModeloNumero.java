package sv.edu.udb.contador_vc190544;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModeloNumero extends ViewModel {
    /**
     * Creando el método que retornará el
     * número
     * https://developer.android.com/topic/libraries/architecture/livedata?hl=es-419
     */
    private MutableLiveData<Integer> numerito;

    public MutableLiveData<Integer> getNumerito(){
        if(numerito==null){
            numerito=new MutableLiveData<Integer>();
        }
        return numerito;
    }

}
