package com.example.lucasbarrozo.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btncalcular = (Button)findViewById(R.id.btCalcular);

       btncalcular.setOnClickListener(calcula);

    }

    public View.OnClickListener calcula = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            TextView txtResultado = (TextView) findViewById(R.id.tvResultado);
            TextView txtClassifica = (TextView) findViewById(R.id.tvClassifica);

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

            txtResultado.setText(resultado+"");

            if(resultado < 16){


                txtClassifica.setText("Magreza Grave");
            }
            else if(resultado <17){

                txtClassifica.setText("Magreza Moderada");
            }
            else if(resultado < 18.5){

                txtClassifica.setText("Magreza Leve");
            }
            else if(resultado <25){

                txtClassifica.setText("Saudável");
            }
            else if(resultado <30){

                txtClassifica.setText("Sobrepeso");
            }

            else if(resultado <35){

                txtClassifica.setText("Obesidade Grau I");
            }
            else if(resultado <40){

                txtClassifica.setText("Obesidade Grau II (severa)");
            }
            else{

                txtClassifica.setText("Obesidade Grau III (mórbida)");
            }

        }
    };

}
