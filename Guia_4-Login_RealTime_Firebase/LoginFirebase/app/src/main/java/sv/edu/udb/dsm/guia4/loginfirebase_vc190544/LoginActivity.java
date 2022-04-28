package sv.edu.udb.dsm.guia4.loginfirebase_vc190544;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailTV, passwordTV;
    private Button loginBtn, registerBtn,loginGoogle;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * Obteniendo la instancia de Firebase
         */
        mAuth=FirebaseAuth.getInstance();

        /**
         * Se inicializa la UI del login
         */
        initializeUI();

        /**
         * Listener de click en botón de registro
         * unicamente cambia de Activity
         */
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        /**
         * Listener de click en botón de Registro
         */
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccount();
            }
        });

        /**
         * Listener de Login con Google
         */
        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUserAccount();
            }
        });
    }

    /**
     * Al inicializar la aplicación se verifica si ya habia
     * una sesión iniciada
     */
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(LoginActivity.this, "Inicio de Sesión Exitoso ", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);

        Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(intent);
    }
    
    private void loginUserAccount(){
        progressBar.setVisibility(View.VISIBLE);
        
        String email,password;
        email=emailTV.getText().toString();
        password=passwordTV.getText().toString();
        
        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Porfavor ingrese su correo...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Porfavor ingrese su contraseña...", Toast.LENGTH_LONG).show();
            return;
        }
        
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Inicio de Sesión Exitoso", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                    Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "El Inicio de Sesión ha fallado! Porfavor, volver a intentar", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
    
    private void initializeUI(){
        emailTV=findViewById(R.id.email);
        passwordTV=findViewById(R.id.password);
        
        loginBtn=findViewById(R.id.login);
        registerBtn=findViewById(R.id.register);
        loginGoogle=findViewById(R.id.sign_in_button);
        progressBar=findViewById(R.id.progressBar);
    }
}