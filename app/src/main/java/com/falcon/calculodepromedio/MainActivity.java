package com.falcon.calculodepromedio;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText AreaTexto1,AreaTexto2,AreaNota1,AreaNota2, AreaNota3;
    Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AreaTexto1 = findViewById(R.id.nombre);
        AreaTexto2 = findViewById(R.id.carrera);
        AreaNota1 = findViewById(R.id.nota01);
        AreaNota2 = findViewById(R.id.nota02);
        AreaNota3 = findViewById(R.id.nota03);

    }

    public void siguienteVentana(View vista){
        String nombre, carrera;
        String notaP,notaS,notaT;
        double nota1,nota2,nota3,promedio;

        notaP = AreaNota1.getText().toString();
        notaS = AreaNota2.getText().toString();
        notaT = AreaNota3.getText().toString();
        nombre = AreaTexto1.getText().toString();
        carrera = AreaTexto2.getText().toString();

        nota1 = Double.parseDouble(notaP);
        nota2 = Double.parseDouble(notaS);
        nota3 = Double.parseDouble(notaT);


        if(notaP.isEmpty() || notaS.isEmpty() || notaT.isEmpty()){


            Toast.makeText(this, "Ingrese un caracter permitido", Toast.LENGTH_LONG).show();
        }else{
            if(nota1>0 && nota1<7 && nota2>0 && nota2<7 && nota3>0 && nota3<7){
                promedio = (nota1+nota2+nota3)/3;

                Intent intent = new Intent(this, VentanaRespuesta.class);
                intent.putExtra("promedio",promedio);
                intent.putExtra("nombre",nombre);
                intent.putExtra("carrera",carrera);
                startActivity(intent);
            }else{

                Toast.makeText(this, "Ingrese valores entre 0.0 y 0.7", Toast.LENGTH_LONG).show();

            }
        }
    }



}