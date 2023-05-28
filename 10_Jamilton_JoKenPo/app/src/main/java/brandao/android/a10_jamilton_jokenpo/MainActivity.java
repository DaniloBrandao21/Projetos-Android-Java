package brandao.android.a10_jamilton_jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void selecionadoPedra(View View){

        System.out.println("Selecionado Pedra!");
        //Chacou outro método da mesma classe
        this.opcaoSelecionada("Pedra");


    }

    public void selecionadoPapel(View View){
        System.out.println("Selecionado Papel!");

        this.opcaoSelecionada("Papel");


    }


    public void selecionadoTesoura(View View){
        System.out.println("Selecionado Tessoura! ");

        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView resultado = findViewById(R.id.resultado);
        ImageView pedra = findViewById(R.id.pedra);
        TextView texto2 = findViewById(R.id.texto2);

        int numero = new Random().nextInt(3); //0, 1, 2

        String [] opcoes = {"Pedra", "Papel", "Tesoura"}; // cria um array com as opções para o aplicativo

        String opcaoApp = opcoes[numero]; // Sorteia um numero relacionado com algum espaço dentro de array e joga o conteudo para outra variavel

        switch (opcaoApp){

            case "Pedra":

                resultado.setImageResource(R.drawable.img_2);
                break;
            case "Papel":

                resultado.setImageResource(R.drawable.img_1);
                break;
            case "Tesoura":

                resultado.setImageResource(R.drawable.img_3);
                break;

        }
       // Usuário venceu
        if(opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura" ||
           opcaoSelecionada == "Tesoura" && opcaoApp == "Papel" ||
           opcaoSelecionada == "Papel" && opcaoApp == "Pedra"){

            texto2.setText("Você venceu!");

        }
        // Empate
        else if(opcaoSelecionada == opcaoApp ){

            texto2.setText("Empate!");
        }
        // APP venceu
        else{
            texto2.setText("Você Perdeu!");
        }



        System.out.println("Danilo Selecionou ---> " + opcaoSelecionada);
        System.out.println("APP Selecionou ---> " + opcaoApp);







    }
}