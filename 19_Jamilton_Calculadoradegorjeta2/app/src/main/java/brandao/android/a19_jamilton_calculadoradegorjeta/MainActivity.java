package brandao.android.a19_jamilton_calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textPorcentagem, textTotal, textGorjeta;
    private SeekBar seekBar;

    private double porcentagem = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor    = findViewById(R.id.editTextValor);
        textPorcentagem  = findViewById(R.id.textPorcentagem);
        textTotal        = findViewById(R.id.textTotal);
        textGorjeta      = findViewById(R.id.textGorjeta);
        seekBar          = findViewById(R.id.seekBar);

        //variaveis
        String valor;
        float valorFloat;


      //  valor = editTextValor.getText().toString();








        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                porcentagem = i;

                textPorcentagem.setText(Math.round(porcentagem) + "%");

                Log.i("Tag", String.valueOf(porcentagem));

                calcular();





            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void calcular(){

        String valorRecuperado = editTextValor.getText().toString();

        if(valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(getApplicationContext(),"Digite um valor primeiro", Toast.LENGTH_LONG

                    ).show();

        }else{

            //Converter String para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //Calculo da gorjeta

            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            //Exibe a gorjeta e total
            textGorjeta.setText("R$ " + (gorjeta));
            textTotal.setText("R$ " + (total));

        }




    }
}