package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_password;
    private Button bt_inicio;
    private ImageButton bt_registro_usuario;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_nombre = findViewById(R.id.et_nombre);
        et_password = findViewById(R.id.et_password);
        bt_inicio = findViewById(R.id.bt_entrar);
        bt_registro_usuario = findViewById(R.id.btnAgregarUsuario);
        db = new DatabaseHelper(this);

    }
    
    //Método que comprueba el usuario y contraseña introducidos
    
    public void comprobarLogin(View view){
        String email = et_nombre.getText().toString();
        String password = et_password.getText().toString();

        if(db.checkUsuario(email, password)){
            Intent cambio = new Intent(this, SeleccionCine.class);
            startActivity(cambio);
        }else{
            Toast mensajeError = Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
            mensajeError.show();
        }
    }

    //Método que lleva a la pantalla de registro de usuario

    public void registroUsuario(View view){
        Intent cambio = new Intent(this, RegistroUsuario.class);
        startActivity(cambio);
    }
}