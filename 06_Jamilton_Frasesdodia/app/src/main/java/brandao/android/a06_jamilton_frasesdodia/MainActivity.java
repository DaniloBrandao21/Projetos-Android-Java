package brandao.android.a06_jamilton_frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Criando uma função para gerar a nova frase
    public void gerarNovaFrase(View View){

        //sorteando um numero para o array
        int i = new Random().nextInt(5);

        //criando um array apra comportar as frases
        String[] frases = {"BORAAAAAAAA, HORA DE FICAR SHEEEEEEEIPADO!!!",
                           "BORA QUE É HORA DE TRAMPAR!!!",
                           "Owww, cê tá ficando grande hein ? SHEEEIPADO ",
                           "Treine, enquanto eles dormem .\n" +
                                   "Treine, enquanto eles se divertem. \n" +
                                   "Treine, enquanto eles descansam. ",
                           "Qual a meta de hoje ??? \n" +
                                   "Trabalhar, treinar e estudar. \n" +
                                   "BORA!!! "
        };

        //configurando para encontrar o id e associar à variavel

        TextView texto = findViewById(R.id.frase);


        //Trocando o texto da frase
        texto.setText(frases[i]);




    }
}