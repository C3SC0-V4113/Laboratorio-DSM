package sv.edu.udb.permisosapp_vc190544;

import static android.Manifest.permission.READ_CONTACTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lblPermiso;
    private TextView lblContacto;
    private final int MY_PERMISSION=100;//Codigo que utilizamos para solicitar los permisos, puede ser cualquier número

    private final int OPEN_CONTACT=200;//Codigo que utilizamos para solicitar los permisos, puede ser cualquier número

    private final String str_permitido="PERMITIDO";
    private final String str_denegado="DENEGADO";
    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean verificarPermiso(){
        /*Comprobando la version del dispositivo, en este caso que sea la versión de Android 6.0*/
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.M) return true;

        /*Comprobando que los permisos ya hayan sido aceptados por el usuario*/
        if (checkSelfPermission(READ_CONTACTS)== PackageManager.PERMISSION_GRANTED)
            return true;

        /*Los permisos nos fueron aceptados por el usuario*/
        return false;
    }
}