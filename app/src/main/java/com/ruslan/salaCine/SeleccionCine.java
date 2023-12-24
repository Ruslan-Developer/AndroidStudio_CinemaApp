package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SeleccionCine extends AppCompatActivity {

    private ListView listViewCines;
    private TextView textViewSalas;
    private Button buttonSiguiente;
    private Reserva reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_cine);

        listViewCines = findViewById(R.id.listView_cines);
        textViewSalas = findViewById(R.id.textView_salas);
        buttonSiguiente = findViewById(R.id.bt_siguiente_sala);

        reserva = new Reserva();

        //Cargar los cines en el ListView
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_list_item_1);
        listViewCines.setAdapter(adapter);

        /**
         * Método que carga las salas de cine en el ListView
         * Al seleccionar una ciudad del ListView se cargan las salas de cine
         * @param parent Vista de la actividad actual (SeleccionCine)
         *
         */
        listViewCines.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Cargar las salas de cine en el ListView
                String[] salas = getResources().getStringArray(R.array.salas);

                //Mostrar las salas de cine que el usuario ha seleccionado en el TextView
                textViewSalas.setText(salas[position]);
            }
        });


    }

    /**
     * Método que abre la sala de cine seleccionada en el ListView
     * Pulsando el botón "Siguiente" se abre la sala de cine seleccionada
     * @param view Vista de la actividad actual (SeleccionCine)
     * @return void No devuelve nada
     *
     */
    public void abrirSala(View view){
        if(textViewSalas.getText().toString().equals("Cinesa Zaratán")){
            //Registramos la reserva de la sala de cine
            reserva.setSala("Cinesa Zaratán");
            Intent cambio = new Intent(SeleccionCine.this, SalaCineZaratan.class);
            cambio.putExtra("reserva", reserva);
            startActivity(cambio);
        }else if(textViewSalas.getText().toString().equals("Cinesa Diagonal")) {
            //Intent cambio = new Intent(this, SalaCine.class);
        }else if(textViewSalas.getText().toString().equals("Cinesa Zubiarte")) {
            //Intent cambio = new Intent(this, SalaCine.class);
        }else if(textViewSalas.getText().toString().equals("Cinesa Principe Pio")) {
            //Intent cambio = new Intent(this, SalaCine.class);
        }else if(textViewSalas.getText().toString().equals("Cinesa Plaza de Armas")) {
            //Intent cambio = new Intent(this, SalaCine.class);
        }else if(textViewSalas.getText().toString().equals("Cinesa Bonaire")) {
            //Intent cambio = new Intent(this, SalaCine.class);
        }
        else{
           Toast errorSala =  Toast.makeText(this, "Debe seleccionar una sala existente", Toast.LENGTH_SHORT);
           errorSala.show();
        }

    }

}