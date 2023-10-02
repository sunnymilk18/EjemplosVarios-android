package com.example.ejemplosvarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText etxt1;
    private Button btn1, btn2, btn3;
    private ImageButton imgbtn1;
    private RadioButton rb1, rb2;
    private ToggleButton tbtn1;
    private CheckBox chkb1, chkb2, chkb3;
    private RatingBar rtb1;
    private ProgressBar pb1;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxt1 = (EditText) findViewById(R.id.etxt1);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        imgbtn1 = (ImageButton) findViewById(R.id.imgbtn1);

        tbtn1 = (ToggleButton) findViewById(R.id.tbtn1);

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);

        chkb1 = (CheckBox) findViewById(R.id.chkb1);
        chkb2 = (CheckBox) findViewById(R.id.chkb2);
        chkb3 = (CheckBox) findViewById(R.id.chkb3);

        pb1 = (ProgressBar) findViewById(R.id.pb1);

        rtb1 = (RatingBar) findViewById(R.id.rtb1);

        capturarID();
        comprobarRB1();
        comprobarRB2();
        progressBar();
        cambiarEstado();
    }

    public void capturarID() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etxt1.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "El ID esta vacio", Toast.LENGTH_SHORT).show();
                }else {
                    int id = Integer.parseInt(etxt1.getText().toString());
                    Toast.makeText(MainActivity.this, "El id es: " + id, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void comprobarRB1() {
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb1.getText().toString();
                Toast.makeText(MainActivity.this, "El RadioButton seleccionado es: " + tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void comprobarRB2() {
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb2.getText().toString();
                Toast.makeText(MainActivity.this, "El RadioButton seleccionado es: " + tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //metodo para comprobar radio boton con un boton
    public void comprobarRadioButton(View v) {
        String tipo = "";
        if (rb1.isChecked()) {
            tipo = rb1.getText().toString();
        }else {
            tipo = rb2.getText().toString();
        }
        Toast.makeText(this, "RadioButton seleccionado es: "+ tipo, Toast.LENGTH_SHORT).show();
    }

    public void progressBar () {
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        contador++;
                        pb1.setProgress(contador);
                        if (contador == 100) {
                            t.cancel();
                        }
                    }
                };
                t.schedule(tt, 0, 100);
            }
        });
    }

    public void comprobarCheckBox (View v) {
        String comprobarCB1 = "";
        String comprobarCB2 = "";
        String comprobarCB3 = "";
        String etiqueta = "";

        if (chkb1.isChecked() == true) {
            comprobarCB1 = chkb1.getText().toString();
        }
        if (chkb2.isChecked() == true) {
            comprobarCB2 = chkb2.getText().toString();
        }
        if (chkb3.isChecked() == true) {
            comprobarCB3 = chkb3.getText().toString();
        }
        if (comprobarCB1 == "" && comprobarCB2 == "" && comprobarCB3 == "") {
            Toast.makeText(MainActivity.this, "No se a seleccionado una opcion", Toast.LENGTH_SHORT).show();
        }else {
            etiqueta = (comprobarCB1 + " " + comprobarCB2 + " " + comprobarCB3);
            Toast.makeText(MainActivity.this, "Las opciones seleccionadas son: " + etiqueta, Toast.LENGTH_SHORT).show();
        }
    }

    public void cuantasEstrellas (View v) {
        Toast.makeText(MainActivity.this, "Usted a otorgado " + rtb1.getRating() + " estrellas!!!", Toast.LENGTH_SHORT).show();
    }

    public void cambiarEstado () {
        etxt1.setEnabled(false);
        btn1.setEnabled(false);

        tbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tbtn1.isChecked()) {
                    etxt1.setEnabled(true);
                    btn1.setEnabled(true);
                }else {
                    etxt1.setEnabled(false);
                    btn1.setEnabled(false);
                }
            }
        });
    }

}