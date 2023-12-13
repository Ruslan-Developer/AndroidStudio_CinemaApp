package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_password;
    private Button bt_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_nombre = findViewById(R.id.et_nombre);
        et_password = findViewById(R.id.et_password);
        bt_inicio = findViewById(R.id.bt_entrar);

    }
    
    //Método que comprueba el usuario y contraseña introducidos
    
    public void comprobarLogin(View view){
        if(et_nombre.getText().toString().equals("usuario") 
                && et_password.getText().toString().equals("password")
                && !et_nombre.getText().toString().equals("")
                && !et_password.getText().toString().equals("")){
           Intent cambio = new Intent(this, SeleccionCine.class);
              startActivity(cambio);
        }else{
            Toast mensajeError = Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
            mensajeError.show();


        }
    }
}