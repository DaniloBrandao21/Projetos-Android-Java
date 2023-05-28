package brandao.android.a18_jamilton_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarEscala;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarEscala = findViewById(R.id.seekBarEscala);
        textResultado = findViewById(R.id.textResultado);

        //monitorando se existe alguma alteração no seekbar
        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Parametros do onProgressChanger: seekBar ---> Acessa recursos do seekBar
                //Progress ---> Progresso

                //quando altera a escala
                textResultado.setText("Progresso: " + i + " / " + seekBar.getMax()); //seekBar.getMax recupera o valor maximo

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //quando clica na escala
                //textResultado.setText("onStartTrackingTouch");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //quando solta a escala
                //textResultado.setText("onStopTrackingTouch");

            }
        });
    }
    public void recuperarProgresso(View view){

        textResultado.setText("Escolhido: " + seekBarEscala.getProgress());


    }
}