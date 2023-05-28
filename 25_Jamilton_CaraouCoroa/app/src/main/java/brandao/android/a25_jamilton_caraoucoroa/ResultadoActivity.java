package brandao.android.a25_jamilton_caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {

    ImageView imageViewResultado;
    ImageButton imageButtonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageViewResultado = findViewById(R.id.imageViewResultado);
        imageButtonVoltar = findViewById(R.id.imageButtonVoltar);

        //Recuperando dados

        Bundle dados = getIntent().getExtras();
        int resultado;
        resultado = dados.getInt("resultado");

        if (resultado == 0){
            imageViewResultado.setImageResource(R.drawable.moeda_cara);
        }else{
            imageViewResultado.setImageResource(R.drawable.moeda_coroa);
        }

        imageButtonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);*/

                /* Podemos voltar para tela anterior ou podemos encerrar a activity usando o  finish();
                 */
                finish();
            }
        });

    }
}