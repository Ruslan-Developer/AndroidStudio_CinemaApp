package com.ruslan.salaCine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ReservaAsientoSala extends AppCompatActivity {

    private ImageFilterButton ifbtn_13, ifbtn_14, ifbtn_15, ifbtn_16, ifbtn_17, ifbtn_18; //Botones de los asientos fila 1
    private ImageFilterButton ifbtn_22, ifbtn_23, ifbtn_24, ifbtn_25, ifbtn_26, ifbtn_27, ifbtn_28, ifbtn_29; //Botones de los asientos fila 2
    private ImageFilterButton ifbtn_31, ifbtn_32, ifbtn_33, ifbtn_34, ifbtn_35, ifbtn_36, ifbtn_37, ifbtn_38, ifbtn_39, ifbtn_310; //Botones de los asientos fila 3
    private ImageFilterButton ifbtn_41, ifbtn_42, ifbtn_43, ifbtn_44, ifbtn_45, ifbtn_46, ifbtn_47, ifbtn_48, ifbtn_49, ifbtn_410; //Botones de los asientos fila 4
    private ImageFilterButton ifbtn_51, ifbtn_52, ifbtn_53, ifbtn_54, ifbtn_55, ifbtn_56, ifbtn_57, ifbtn_58, ifbtn_59, ifbtn_510; //Botones de los asientos fila 5
    private ImageFilterButton ifbtn_61, ifbtn_62, ifbtn_63, ifbtn_64, ifbtn_65, ifbtn_66, ifbtn_67, ifbtn_68, ifbtn_69, ifbtn_610; //Botones de los asientos fila 6
    private ImageFilterButton ifbtn_71, ifbtn_72, ifbtn_73, ifbtn_74, ifbtn_75, ifbtn_76, ifbtn_77, ifbtn_78, ifbtn_79, ifbtn_710; //Botones de los asientos fila 7
    private ImageFilterButton ifbtn_81, ifbtn_82, ifbtn_83, ifbtn_84, ifbtn_85, ifbtn_86, ifbtn_87, ifbtn_88, ifbtn_89, ifbtn_810; //Botones de los asientos fila 8
    private ImageFilterButton ifbtn_91, ifbtn_92, ifbtn_93, ifbtn_94, ifbtn_95, ifbtn_96, ifbtn_97, ifbtn_98, ifbtn_99, ifbtn_910; //Botones de los asientos fila 9
    private ImageFilterButton ifbtn_101, ifbtn_102, ifbtn_103, ifbtn_104, ifbtn_105, ifbtn_106, ifbtn_107, ifbtn_108, ifbtn_109, ifbtn_1010; //Botones de los asientos fila 10
    private List<ImageFilterButton> listaAsientos = new ArrayList<ImageFilterButton>(); //Lista de asientos
    private boolean isButtonClicked = false; //Variable para saber si el boton ha sido pulsado
    private List<ImageFilterButton> listaAsientosOcupados = new ArrayList<ImageFilterButton>(); //Lista de asientos ocupados
    private List<Reserva> listaReservas = new ArrayList<>(); //Lista de reservas
    private Button btnReservarAsientos;
    private Reserva reserva;
    private List<ImageFilterButton> listaAsientosSeleccionados = new ArrayList<ImageFilterButton>(); //Lista de asientos seleccionados
    private Map<String, Double> preciosButacas = new HashMap<String, Double>();
    private double precioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_asiento_sala);

        Intent intent = getIntent();
        reserva = (Reserva) intent.getSerializableExtra("reserva");

        //reserva = new Reserva();

        // Llamada al método para asignar asiento a la reserva
        //asignarAsientoReserva();

        btnReservarAsientos = findViewById(R.id.btn_siguiente_reserva);

        //Botones de los asientos fila 1
        ifbtn_13 = findViewById(R.id.fila01_asiento03);
        ifbtn_14 = findViewById(R.id.fila01_asiento04);
        ifbtn_15 = findViewById(R.id.fila01_asiento05);
        ifbtn_16 = findViewById(R.id.fila01_asiento06);
        ifbtn_17 = findViewById(R.id.fila01_asiento07);
        ifbtn_18 = findViewById(R.id.fila01_asiento08);

        ifbtn_18.setContrast(2.5f);
        ifbtn_18.setSaturation(1.5f);
        ifbtn_18.setWarmth(1.5f);

        //Botones de los asientos fila 2
        ifbtn_22 = findViewById(R.id.fila02_asiento02);
        ifbtn_23 = findViewById(R.id.fila02_asiento03);
        ifbtn_24 = findViewById(R.id.fila02_asiento04);
        ifbtn_25 = findViewById(R.id.fila02_asiento05);
        ifbtn_26 = findViewById(R.id.fila02_asiento06);
        ifbtn_27 = findViewById(R.id.fila02_asiento07);
        ifbtn_28 = findViewById(R.id.fila02_asiento08);
        ifbtn_29 = findViewById(R.id.fila02_asiento09);

        //Botones de los asientos fila 3
        ifbtn_31 = findViewById(R.id.fila03_asiento01);
        ifbtn_32 = findViewById(R.id.fila03_asiento02);
        ifbtn_33 = findViewById(R.id.fila03_asiento03);
        ifbtn_34 = findViewById(R.id.fila03_asiento04);
        ifbtn_35 = findViewById(R.id.fila03_asiento05);
        ifbtn_36 = findViewById(R.id.fila03_asiento06);
        ifbtn_37 = findViewById(R.id.fila03_asiento07);
        ifbtn_38 = findViewById(R.id.fila03_asiento08);
        ifbtn_39 = findViewById(R.id.fila03_asiento09);
        ifbtn_310 = findViewById(R.id.fila03_asiento10);

        //Botones de los asientos fila 4
        ifbtn_41 = findViewById(R.id.fila04_asiento01);
        ifbtn_42 = findViewById(R.id.fila04_asiento02);
        ifbtn_43 = findViewById(R.id.fila04_asiento03);
        ifbtn_44 = findViewById(R.id.fila04_asiento04);
        ifbtn_45 = findViewById(R.id.fila04_asiento05);
        ifbtn_46 = findViewById(R.id.fila04_asiento06);
        ifbtn_47 = findViewById(R.id.fila04_asiento07);
        ifbtn_48 = findViewById(R.id.fila04_asiento08);
        ifbtn_49 = findViewById(R.id.fila04_asiento09);
        ifbtn_410 = findViewById(R.id.fila04_asiento10);

        //Botones de los asientos fila 5
        ifbtn_51 = findViewById(R.id.fila05_asiento01);
        ifbtn_52 = findViewById(R.id.fila05_asiento02);
        ifbtn_53 = findViewById(R.id.fila05_asiento03);
        ifbtn_54 = findViewById(R.id.fila05_asiento04);
        ifbtn_55 = findViewById(R.id.fila05_asiento05);
        ifbtn_56 = findViewById(R.id.fila05_asiento06);
        ifbtn_57 = findViewById(R.id.fila05_asiento07);
        ifbtn_58 = findViewById(R.id.fila05_asiento08);
        ifbtn_59 = findViewById(R.id.fila05_asiento09);
        ifbtn_510 = findViewById(R.id.fila05_asiento10);

        //Botones de los asientos fila 6
        ifbtn_61 = findViewById(R.id.fila06_asiento01);
        ifbtn_62 = findViewById(R.id.fila06_asiento02);
        ifbtn_63 = findViewById(R.id.fila06_asiento03);
        ifbtn_64 = findViewById(R.id.fila06_asiento04);
        ifbtn_65 = findViewById(R.id.fila06_asiento05);
        ifbtn_66 = findViewById(R.id.fila06_asiento06);
        ifbtn_67 = findViewById(R.id.fila06_asiento07);
        ifbtn_68 = findViewById(R.id.fila06_asiento08);
        ifbtn_69 = findViewById(R.id.fila06_asiento09);
        ifbtn_610 = findViewById(R.id.fila06_asiento10);

        //Botones de los asientos fila 7
        ifbtn_71 = findViewById(R.id.fila07_asiento01);
        ifbtn_72 = findViewById(R.id.fila07_asiento02);
        ifbtn_73 = findViewById(R.id.fila07_asiento03);
        ifbtn_74 = findViewById(R.id.fila07_asiento04);
        ifbtn_75 = findViewById(R.id.fila07_asiento05);
        ifbtn_76 = findViewById(R.id.fila07_asiento06);
        ifbtn_77 = findViewById(R.id.fila07_asiento07);
        ifbtn_78 = findViewById(R.id.fila07_asiento08);
        ifbtn_79 = findViewById(R.id.fila07_asiento09);
        ifbtn_710 = findViewById(R.id.fila07_asiento10);

        //Botones de los asientos fila 8
        ifbtn_81 = findViewById(R.id.fila08_asiento01);
        ifbtn_82 = findViewById(R.id.fila08_asiento02);
        ifbtn_83 = findViewById(R.id.fila08_asiento03);
        ifbtn_84 = findViewById(R.id.fila08_asiento04);
        ifbtn_85 = findViewById(R.id.fila08_asiento05);
        ifbtn_86 = findViewById(R.id.fila08_asiento06);
        ifbtn_87 = findViewById(R.id.fila08_asiento07);
        ifbtn_88 = findViewById(R.id.fila08_asiento08);
        ifbtn_89 = findViewById(R.id.fila08_asiento09);
        ifbtn_810 = findViewById(R.id.fila08_asiento10);

        //Botones de los asientos fila 9
        ifbtn_91 = findViewById(R.id.fila09_asiento01);
        ifbtn_92 = findViewById(R.id.fila09_asiento02);
        ifbtn_93 = findViewById(R.id.fila09_asiento03);
        ifbtn_94 = findViewById(R.id.fila09_asiento04);
        ifbtn_95 = findViewById(R.id.fila09_asiento05);
        ifbtn_96 = findViewById(R.id.fila09_asiento06);
        ifbtn_97 = findViewById(R.id.fila09_asiento07);
        ifbtn_98 = findViewById(R.id.fila09_asiento08);
        ifbtn_99 = findViewById(R.id.fila09_asiento09);
        ifbtn_910 = findViewById(R.id.fila09_asiento10);

        //Botones de los asientos fila 10
        ifbtn_101 = findViewById(R.id.fila10_asiento01);
        ifbtn_102 = findViewById(R.id.fila10_asiento02);
        ifbtn_103 = findViewById(R.id.fila10_asiento03);
        ifbtn_104 = findViewById(R.id.fila10_asiento04);
        ifbtn_105 = findViewById(R.id.fila10_asiento05);
        ifbtn_106 = findViewById(R.id.fila10_asiento06);
        ifbtn_107 = findViewById(R.id.fila10_asiento07);
        ifbtn_108 = findViewById(R.id.fila10_asiento08);
        ifbtn_109 = findViewById(R.id.fila10_asiento09);
        ifbtn_1010 = findViewById(R.id.fila10_asiento10);

        //Añadir los botones a la lista
        listaAsientos.add(ifbtn_13);
        listaAsientos.add(ifbtn_14);
        listaAsientos.add(ifbtn_15);
        listaAsientos.add(ifbtn_16);
        listaAsientos.add(ifbtn_17);
        listaAsientos.add(ifbtn_18);
        listaAsientos.add(ifbtn_22);
        listaAsientos.add(ifbtn_23);
        listaAsientos.add(ifbtn_24);
        listaAsientos.add(ifbtn_25);
        listaAsientos.add(ifbtn_26);
        listaAsientos.add(ifbtn_27);
        listaAsientos.add(ifbtn_28);
        listaAsientos.add(ifbtn_29);
        listaAsientos.add(ifbtn_31);
        listaAsientos.add(ifbtn_32);
        listaAsientos.add(ifbtn_33);
        listaAsientos.add(ifbtn_34);
        listaAsientos.add(ifbtn_35);
        listaAsientos.add(ifbtn_36);
        listaAsientos.add(ifbtn_37);
        listaAsientos.add(ifbtn_38);
        listaAsientos.add(ifbtn_39);
        listaAsientos.add(ifbtn_310);
        listaAsientos.add(ifbtn_41);
        listaAsientos.add(ifbtn_42);
        listaAsientos.add(ifbtn_43);
        listaAsientos.add(ifbtn_44);
        listaAsientos.add(ifbtn_45);
        listaAsientos.add(ifbtn_46);
        listaAsientos.add(ifbtn_47);
        listaAsientos.add(ifbtn_48);
        listaAsientos.add(ifbtn_49);
        listaAsientos.add(ifbtn_410);
        listaAsientos.add(ifbtn_51);
        listaAsientos.add(ifbtn_52);
        listaAsientos.add(ifbtn_53);
        listaAsientos.add(ifbtn_54);
        listaAsientos.add(ifbtn_55);
        listaAsientos.add(ifbtn_56);
        listaAsientos.add(ifbtn_57);
        listaAsientos.add(ifbtn_58);
        listaAsientos.add(ifbtn_59);
        listaAsientos.add(ifbtn_510);
        listaAsientos.add(ifbtn_61);
        listaAsientos.add(ifbtn_62);
        listaAsientos.add(ifbtn_63);
        listaAsientos.add(ifbtn_64);
        listaAsientos.add(ifbtn_65);
        listaAsientos.add(ifbtn_66);
        listaAsientos.add(ifbtn_67);
        listaAsientos.add(ifbtn_68);
        listaAsientos.add(ifbtn_69);
        listaAsientos.add(ifbtn_610);
        listaAsientos.add(ifbtn_71);
        listaAsientos.add(ifbtn_72);
        listaAsientos.add(ifbtn_73);
        listaAsientos.add(ifbtn_74);
        listaAsientos.add(ifbtn_75);
        listaAsientos.add(ifbtn_76);
        listaAsientos.add(ifbtn_77);
        listaAsientos.add(ifbtn_78);
        listaAsientos.add(ifbtn_79);
        listaAsientos.add(ifbtn_710);
        listaAsientos.add(ifbtn_81);
        listaAsientos.add(ifbtn_82);
        listaAsientos.add(ifbtn_83);
        listaAsientos.add(ifbtn_84);
        listaAsientos.add(ifbtn_85);
        listaAsientos.add(ifbtn_86);
        listaAsientos.add(ifbtn_87);
        listaAsientos.add(ifbtn_88);
        listaAsientos.add(ifbtn_89);
        listaAsientos.add(ifbtn_810);
        listaAsientos.add(ifbtn_91);
        listaAsientos.add(ifbtn_92);
        listaAsientos.add(ifbtn_93);
        listaAsientos.add(ifbtn_94);
        listaAsientos.add(ifbtn_95);
        listaAsientos.add(ifbtn_96);
        listaAsientos.add(ifbtn_97);
        listaAsientos.add(ifbtn_98);
        listaAsientos.add(ifbtn_99);
        listaAsientos.add(ifbtn_910);
        listaAsientos.add(ifbtn_101);
        listaAsientos.add(ifbtn_102);
        listaAsientos.add(ifbtn_103);
        listaAsientos.add(ifbtn_104);
        listaAsientos.add(ifbtn_105);
        listaAsientos.add(ifbtn_106);
        listaAsientos.add(ifbtn_107);
        listaAsientos.add(ifbtn_108);
        listaAsientos.add(ifbtn_109);
        listaAsientos.add(ifbtn_1010);





        //Generamos el tamaño de nuestra lista de asientos ocupados
        int numAsientosOcupados = new Random().nextInt(listaAsientos.size());

        /**
         * Bucle para generar los asientos ocupados
         * Se genera un numero aleatorio entre 0 y el tamaño de la lista de asientos
         * Si el asiento no esta ocupado, se añade a la lista y se pone en rojo
         */
        while(listaAsientosOcupados.size() < numAsientosOcupados) {
            //Generamos el numero aleatorio de asiento que se va a ocupar
            int numAsiento = new Random().nextInt(listaAsientos.size());
            //Obtenemos el asiento de la lista y lo guardamos en una variable
            ImageFilterButton asientoOcupado = listaAsientos.get(numAsiento);
            //Comprobamos que la variable asientoOcupado no este en la lista de asientos ocupados y si no esta, lo añadimos a la lista y lo ponemos en rojo
            if(!listaAsientosOcupados.contains(asientoOcupado)) {
                listaAsientosOcupados.add(asientoOcupado);
                asientoOcupado.setColorFilter(Color.RED);
            }
        }
        /**
         * Recorremos la lista de asientos para obtener el ID de cada asiento
         * Se obtiene el ID del asiento y se guarda en una variable de tipo String
         * Se guarda el ID del asiento y el precio en un Map para poder obtener el precio del asiento (clave) a partir del ID (valor) precio que fijamos en 8.40
         */

        for (ImageFilterButton butaca : listaAsientos) {
            String asientoId = getResources().getResourceEntryName(butaca.getId());
            preciosButacas.put(asientoId, 8.40);
        }


        /**
         * Listener para cambiar el color del asiento al pulsarlo
         * Si el asiento no esta en la lista de asientos ocupados, se cambia el color del asiento al pulsarlo y se pone en verde
         * Se condiciona para que si el asiento ya esta en verde y se vuelve a pulsar, se ponga en blanco
         * Tambien se condiciona para que si el asiento esta en rojo, no se pueda pulsar
         */
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageFilterButton asiento = (ImageFilterButton) v; //Se crea un objeto de tipo ImageFilterButton para poder cambiar el color del boton
                //Si el asiento no esta en la lista de asientos ocupados, se cambia el color del asiento al pulsarlo y se pone en verde
                if (!listaAsientosOcupados.contains(asiento)) {

                    if (listaAsientosSeleccionados.contains(asiento)) {
                        asiento.clearColorFilter();
                        listaAsientosSeleccionados.remove(asiento);
                        // Si el asiento ya estaba seleccionado, se resta el precio del asiento al precio total
                        String asientoId = getResources().getResourceEntryName(asiento.getId());
                        precioTotal -= preciosButacas.get(asientoId);
                        reserva.setPrecioEntradas(precioTotal);

                    } else {
                        //Marca en verde el asiento seleccionado
                        asiento.setColorFilter(Color.parseColor("#26D21B"));
                        // Agregamos el asiento a la lista de asientos seleccionados
                        listaAsientosSeleccionados.add(asiento);
                        // Si el asiento no estaba seleccionado, se suma el precio del asiento al precio total
                        String asientoId = getResources().getResourceEntryName(asiento.getId());
                        precioTotal += preciosButacas.get(asientoId);
                        reserva.setPrecioEntradas(precioTotal);
                        // Generamos una nueva lista de IDs de asientos reservados
                        ArrayList<String> asientosSeleccionadosIds= new ArrayList<String>();
                        // Recorremos la lista de asientos seleccionados para obtener los IDs de los asientos
                        for (ImageFilterButton asientoSeleccionado : listaAsientosSeleccionados) {
                            // Obtenemos el ID del asiento seleccionado y lo agregamos a una nueva lista de IDs de asientos reservados

                            asientosSeleccionadosIds.add(getResources().getResourceEntryName(asientoSeleccionado.getId()));
                        }


                        btnReservarAsientos.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent cambio = new Intent(ReservaAsientoSala.this, ResumenReserva.class);
                                cambio.putExtra("reserva", reserva);
                                cambio.putExtra("sala", "Cinesa Zaratan");
                                cambio.putStringArrayListExtra("asientosSeleccionados", asientosSeleccionadosIds);
                                startActivity(cambio);
                            }

                        });

                    }
                }
            }

        };

        //Recorremos la lista para cambiar el color del asiento al pulsarlo y que se quede en verde
        for (ImageFilterButton asiento : listaAsientos) {
            asiento.setOnClickListener(onClickListener);
        }

    }


    /*  Código de versiones antiguas que no se esta usando, pero nos sirve de referencia para seguir las evoluciones */


    //Metodo para cambiar a la siguiente pantalla
    public void finalizarSeleccion(View view){

        Intent cambio = new Intent(ReservaAsientoSala.this, ResumenReserva.class);
        cambio.putExtra("reserva", reserva);
        cambio.putExtra("sala", "Cinesa Zaratan");
        startActivity(cambio);


    }

    public void asignarAsientoReserva(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageFilterButton asiento = (ImageFilterButton) v;
                if(!listaAsientosOcupados.contains(asiento)){


                    //Obtener la etiqueta del asiento del ID del ImageView
                    String etiqueta = getResources().getResourceEntryName(asiento.getId());
                    String fila = etiqueta.substring(4,6);
                    String numeroAsiento = etiqueta.substring(13,15);

                    reserva.setFila(fila);
                    reserva.setNumeroAsiento(numeroAsiento);


                    Log.d("ReservaAsientoSala", "Fila: " + reserva.getFila() + ", Número de asiento: " + reserva.getNumeroAsiento());
                    /*
                    asientoReservado.setColorFilter(Color.parseColor("#26D21B"));
                    isButtonClicked = true;

                     */


                }
            }
        };

        // Importante asignar el OnClickListener a cada asiento
        for (ImageFilterButton asiento : listaAsientos) {
            asiento.setOnClickListener(onClickListener);
        }

    }



}