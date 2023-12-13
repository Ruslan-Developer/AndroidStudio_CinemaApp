package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResumenReserva extends AppCompatActivity {

        private Reserva reserva;
        private TextView tv_titulo_pelicula;
        private TextView tv_sala;
        private TextView tv_fecha;
        private TextView tv_hora;
        private TextView tv_fila;
        private TextView tv_numeroAsiento;
        private TextView tv_listaReservas;
        private List<Reserva> listaReservas;
        private String fila;
        private String numeroAsiento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_reserva);

        tv_titulo_pelicula = findViewById(R.id.tv_tituloPelicula);
        tv_sala = findViewById(R.id.tvSala);
        tv_fecha = findViewById(R.id.tvFecha);
        tv_hora = findViewById(R.id.tvHora);
        tv_fila = findViewById(R.id.tvFila);
        tv_numeroAsiento = findViewById(R.id.tvNumAsiento);
        tv_listaReservas = findViewById(R.id.tvListaReservas);


        // Obtén la reserva del Intent
        Intent intent = getIntent();



        if (intent != null) {
            reserva = (Reserva) intent.getSerializableExtra("reserva");
            // Registrar los valores de la fila y el número del asiento
            Log.d("ResumenReserva", "Fila: " + reserva.getFila() + ", Número de asiento: " + reserva.getNumeroAsiento());

            if (reserva != null) {
                String pelicula = reserva.getTituloPelicula();
                String sala = intent.getStringExtra("sala");
                String fecha = reserva.getFecha();
                String hora = reserva.getHora();
                String fila = reserva.getFila();
                String numeroAsiento = reserva.getNumeroAsiento();

                if (pelicula != null) {
                    tv_titulo_pelicula.setText(pelicula);
                }

                if (sala != null) {
                    tv_sala.setText(sala);
                }

                if (fecha != null) {
                    tv_fecha.setText(fecha);
                }

                if (hora != null) {
                    tv_hora.setText(hora);
                }

                if (fila != null) {
                    tv_fila.setText(fila);
                }

                if (numeroAsiento != null) {
                    tv_numeroAsiento.setText(numeroAsiento);
                }
                /*

                if(listaReservas != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Reserva reserva : listaReservas) {
                        sb.append("Fila: ").append(reserva.getFila())
                                .append(", Número de asiento: ").append(reserva.getNumeroAsiento())
                                .append("\n");
                    }
                    tv_listaReservas.setText(sb.toString());



                }

                 */

                ArrayList<String> asientosSeleccionadosIds = intent.getStringArrayListExtra("asientosSeleccionados");
                if (asientosSeleccionadosIds != null) {
                    StringBuilder sb = new StringBuilder();
                    for (String asientoId : asientosSeleccionadosIds) {
                         fila = asientoId.substring(4, 6);
                         numeroAsiento = asientoId.substring(14,16);
                        sb.append("Fila: ").append(fila)
                                .append(", Número de asiento: ").append(numeroAsiento)
                                .append("\n");
                    }
                    tv_listaReservas.setText(sb.toString());
                }
            }

        }
    }
}
