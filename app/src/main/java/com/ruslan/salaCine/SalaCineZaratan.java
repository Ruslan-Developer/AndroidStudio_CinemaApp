package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SalaCineZaratan extends AppCompatActivity {

    private Chip chipHora01, chipHora02, chipHora03, chipHora04;
    private ImageButton btCalendario;
    private ImageView iv_napolean, iv_wonka, iv_anatomia, iv_asesinos;
    private TabLayout tabLayout;
    private String diaSeleccionado;
    private TextView tvFecha;
    private EditText etNapoleon;
    private Reserva reserva;
    private HashMap<ImageView, String> peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_cine_zaratan);

        chipHora01 = findViewById(R.id.chip31);
        chipHora02 = findViewById(R.id.chip32);
        chipHora03 = findViewById(R.id.chip33);
        chipHora04 = findViewById(R.id.chip34);
        btCalendario = findViewById(R.id.bt_calendar);
        tabLayout = findViewById(R.id.tab_layout_1);
        tvFecha = findViewById(R.id.tv_fecha);
        etNapoleon = findViewById(R.id.et_napoleon);

        iv_napolean = findViewById(R.id.ivNapoleon);
        iv_wonka = findViewById(R.id.ivWonka);
        iv_anatomia = findViewById(R.id.ivAnatomia);
        iv_asesinos = findViewById(R.id.ivAsesinos);

        // Obtenemos el objeto reserva de la actividad anterior
        Intent intent = getIntent();
        reserva = (Reserva) intent.getSerializableExtra("reserva");

        //reserva = new Reserva();

        /* Esta parte del codigo esta comentada al ser una implementacion anterior que no se usa pero puede ser útil
        * para futuras implementaciones, consiste en un HashMap que recoge todos los ImageView con su titulo de pelicula correspondiente
        * y nos permite acceder a ellos mediante un bucle for y un objeto Map.Entry que representa un par clave-valor.
        * Ademas lo mas interesante es que al pulsar en la imagen guardamos el titulo para obtener el dato mas adelante y cambiar a la siguiente pantalla.
        * */

        /*
        // Inicializamos el objeto reserva y el HashMap de peliculas
        //reserva = new Reserva();
        peliculas = new HashMap<>();
        peliculas.put(iv_napolean, "Napoleon");
        peliculas.put(iv_wonka, "Wonka");
        peliculas.put(iv_anatomia, "Anatomia");
        peliculas.put(iv_asesinos, "Asesinos");

        /*
            Cuando usamos el método entrySet() en un HashMap, obtenemos un conjunto de todas las entradas en el HashMap.
            Cada entrada es un objeto Map.Entry que representa un par clave-valor.
            En el bucle for, entrada es una variable que representa la entrada actual en el conjunto de entradas mientras recorremos el HashMap.
            Usamos entrada.getKey() para obtener la clave de la entrada actual (que es un ImageView en este caso)
            y entrada.getValue() para obtener el valor de la entrada actual (que es el nombre de la película en este caso).
         */

        //for (final Map.Entry<ImageView, String> entrada : peliculas.entrySet()) {
            /*
                El modificador final se utiliza en este contexto para permitir que la variable entrada
                sea accesible dentro de la clase anónima OnClickListener.
                En Java, las clases anónimas pueden acceder a variables locales del método que las contiene
                solo si estas variables son final.
             */
            /*
            entrada.getKey().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pelicula = entrada.getValue();
                    reserva.setPelicula(pelicula);
                    Intent cambio = new Intent(SalaCineZaratan.this, ReservaAsientoSala.class);
                    cambio.putExtra("reserva", reserva);
                    startActivity(cambio);

                }
            });
        }
        */

        btCalendario.setColorFilter(Color.BLUE);

        // Esto nos sirve para que al iniciar la pantalla, se quede seleccionado el tab del viernes si el indice es 0 y asi sucesivamente
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        if(tab != null) {
            tab.select(); //
        }


        /**
         * Método que muestra el calendario con la fecha del viernes, sabado o domingo
         * Al seleccionar un día de la semana viernes, sabado o domingo se muestra el calendario
         * Solo se puede seleccionar un día de la semana a la vez (Viernes, Sábado o Domingo)
         *
         */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                    diaSeleccionado = tab.getText().toString();
                    mostrarFechaSeleccionada();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                diaSeleccionado = tab.getText().toString();
                mostrarFechaSeleccionada();
            }

        });


    }

    /**
     * Método que muestra el calendario con la fecha del viernes, sabado o domingo
     * Solo se puede seleccionar en el calendario la fecha del viernes, sabado o domingo
     *
     * Es un método con otros métodos dentro
     */
    public void mostrarFechaSeleccionada() {

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Mostramos la fecha seleccionada en un TextView.
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        TextView dateTextView = findViewById(R.id.tv_fecha);
                        dateTextView.setText(selectedDate);
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        ) {
            /**
             * Método que controla que se selecciona correctamente el dia de la semana
             * Si el usuario se equivoca al seleccionar el dia de la semana,
             * automaticamente se selecciona el viernes, sabado o domingo mas cercano
             */
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);

                int diaSemana = -1; // -1 indica que no se ha seleccionado ningun dia de la semana
                if(diaSeleccionado.equals("Viernes")) {
                    diaSemana = Calendar.FRIDAY;
                } else if(diaSeleccionado.equals("Sábado")) {
                    diaSemana = Calendar.SATURDAY;
                } else if(diaSeleccionado.equals("Domingo")) {
                    diaSemana = Calendar.SUNDAY;
                }

                if(calendar.get(Calendar.DAY_OF_WEEK) != diaSemana) {
                    while(calendar.get(Calendar.DAY_OF_WEEK) != diaSemana) {
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                    }
                    // Actualizamos el calendario con la fecha del viernes, sabado o domingo mas cercano al seleccionado por el usuario en el TabLayout
                    view.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                }
            }
        };
        // Mostramos el calendario
        datePickerDialog.show();
    }

    //Metodo para cambiar a la siguiente pantalla
    public void cambiarPantallaReservaAsiento(View view){

        // Guardamos el titulo pelicula en el objeto reserva
        String tituloPelicula = etNapoleon.getText().toString();
        reserva.setPelicula(tituloPelicula);

        // Guardamos la fecha seleccionada en el objeto reserva
        String fecha = tvFecha.getText().toString();
        reserva.setFecha(fecha);

        // Guardamos la hora seleccionada en el objeto reserva
        String hora01 = chipHora01.getText().toString();
        String hora02 = chipHora02.getText().toString();
        String hora03 = chipHora03.getText().toString();
        String hora04 = chipHora04.getText().toString();
        reserva.setHora(hora01);
        reserva.setHora(hora02);
        reserva.setHora(hora03);
        reserva.setHora(hora04);

        // Cambiamos a la siguiente pantalla
        Intent cambio = new Intent(SalaCineZaratan.this, ReservaAsientoSala.class);
        cambio.putExtra("reserva", reserva);
        startActivity(cambio);

    }
}