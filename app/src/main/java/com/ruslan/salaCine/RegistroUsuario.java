package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroUsuario extends AppCompatActivity {

    private EditText etNombre, etApellido, etCorreo, etContrasena, etConfirmarContrasena;
    private Button btnRegistrar;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.et_apellidos);
        etCorreo = findViewById(R.id.et_correo);
        etContrasena = findViewById(R.id.et_pass);
        etConfirmarContrasena = findViewById(R.id.et_confirm_pass);
        btnRegistrar = findViewById(R.id.btn_registrarse);
        db = new DatabaseHelper(this);

    }

    /**
     * Método que registra los datos del usuario en la base de datos
     * @param view
     * @return void
     *
     */
    public void registrarDatos(View view) {

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String correo = etCorreo.getText().toString();
        String password = etContrasena.getText().toString();
        String confirmarPassword = etConfirmarContrasena.getText().toString();

        // Comprobamos que los campos no estén vacíos
        if ( nombre.equals("")
                || apellido.equals("")
                || correo.equals("")
                || password.equals("")
                || etConfirmarContrasena.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor, ingrese todos los campos", Toast.LENGTH_SHORT).show();
        } else {

            // Comprobamos que el usuario no exista en la base de datos
            if(db.checkUsuario(correo, password)) {
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            } else {
                // Comprobamos que las contraseñas coincidan
                if (password.equals(confirmarPassword)) {
                    Boolean insertar = db.agregarUsuario(correo, password);
                    if (insertar) {
                        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent cambio = new Intent(this, MainActivity.class);
                        startActivity(cambio);
                    } else {
                        Toast.makeText(this, "Registro fallido, revise las contraseñas", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}