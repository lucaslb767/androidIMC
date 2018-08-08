package com.example.lucasbarrozo.imc;

import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  TextView txtresultado;
    private  TextView txtclassifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtresultado =(TextView) findViewById(R.id.tvResultado);
        txtclassifica = (TextView) findViewById(R.id.tvClassifica);

        Button btncalcular = (Button)findViewById(R.id.btCalcular);

       btncalcular.setOnClickListener(calcula);

    }

    public View.OnClickListener calcula = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

//            TextView txtResultado = (TextView) findViewById(R.id.tvResultado);
//            TextView txtClassifica = (TextView) findViewById(R.id.tvClassifica);

            EditText editPeso = (EditText) findViewById(R.id.editPeso);
            EditText editAltura = (EditText) findViewById(R.id.editAltura);

            String testPeso = editPeso.getText().toString();
            String testAltura = editAltura.getText().toString();

            if (testPeso.matches("")) {
                Toast.makeText(getApplicationContext(), "Você não colocou o peso", Toast.LENGTH_SHORT).show();
                return;
            }

            if (testAltura.matches("")) {
                Toast.makeText(getApplicationContext(), "Você não colocou a altura", Toast.LENGTH_SHORT).show();
                return;
            }

            int peso = Integer.parseInt(editPeso.getText().toString());
            float altura = Float.parseFloat(editAltura.getText().toString());



            float resultado = (peso/((altura*altura)/10000));

            txtresultado.setText(resultado+"");

            if(resultado < 16){


                txtclassifica.setText("Magreza Grave");
                txtclassifica.setTextColor(Color.parseColor("#d50000"));
            }
            else if(resultado <17){

                txtclassifica.setText("Magreza Moderada");
                txtclassifica.setTextColor(Color.parseColor("#ffca28"));
            }
            else if(resultado < 18.5){

                txtclassifica.setText("Magreza Leve");
                txtclassifica.setTextColor(Color.parseColor("#ffca28"));
            }
            else if(resultado <25){

                txtclassifica.setText("Saudável");
                txtclassifica.setTextColor(Color.parseColor("#00C853"));
            }
            else if(resultado <30){

                txtclassifica.setText("Sobrepeso");
                txtclassifica.setTextColor(Color.parseColor("#FFEB3B"));
            }

            else if(resultado <35){

                txtclassifica.setText("Obesidade Grau I");
                txtclassifica.setTextColor(Color.parseColor("#FFEB3B"));
            }
            else if(resultado <40){

                txtclassifica.setText("Obesidade Grau II (severa)");
                txtclassifica.setTextColor(Color.parseColor("#FFEB3B"));
            }
            else{

                txtclassifica.setText("Obesidade Grau III (mórbida)");
                txtclassifica.setTextColor(Color.parseColor("#d50000"));

            }

        }
    };


}
