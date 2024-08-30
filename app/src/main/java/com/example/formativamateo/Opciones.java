package com.example.formativamateo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Opciones extends AppCompatActivity {

    Spinner combo_opc;
    Button btn_operar;
    EditText edt_num1, edt_num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones);

        btn_operar = findViewById(R.id.btn_operar);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);

        combo_opc = findViewById(R.id.id_Spinner);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,
                R.array.combo_opc, android.R.layout.simple_spinner_item);
        combo_opc.setAdapter(adapter);

        btn_operar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = edt_num1.getText().toString();
                String text2 = edt_num2.getText().toString();
                String operacion = combo_opc.getSelectedItem().toString();


                int num1= Integer.parseInt(text1);
                int num2= Integer.parseInt(text2);

                switch (operacion){
                    case "-" :
                        int r1 = num1-num2;
                        Toast.makeText(Opciones.this,"El resultado de la resta es: "+ r1,
                                Toast.LENGTH_LONG).show();
                        break;
                    case "*":
                        int r2= num1*num2;
                        Toast.makeText(Opciones.this,"El resultado de la multiplicación es: "+ r2,
                                Toast.LENGTH_LONG).show();
                        break;
                    case "/":
                        int r3 = num1/num2;
                        Toast.makeText(Opciones.this,"El resultado de la división es: "+ r3,
                                Toast.LENGTH_LONG).show();
                        break;
                    case "ˆ":
                        double r= Math.pow(num1,num2);
                        Toast.makeText(Opciones.this,"El resultado de la potencia es: "+ r,
                                Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });

    }
}