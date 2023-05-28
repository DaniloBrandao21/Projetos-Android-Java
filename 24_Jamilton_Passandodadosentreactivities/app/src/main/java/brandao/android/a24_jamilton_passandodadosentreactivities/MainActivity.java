package brandao.android.a24_jamilton_passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        //Add um evento de click
        //Dentro do setOnClickListener vamos instanciar uma classe anonima (Por ser uma interface)

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instanciando a Intent vc pode configurar o contexto e pra qual activity ela tem a intenção de seguir
                //SegundaActivity.class indica que quero abrir a classe SegundaActivity

                //Instanciar o obj
                Usuario usuario = new Usuario("Danilo", "Danilo@gmail.com");
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                //Passar Dados


                //name --> A "chave" que será utilizada para recuperar o valor passado dentro da activity

                intent.putExtra("nome", "Danilo");
                intent.putExtra("idade", 21);


                //Passar objeto para outra activity (necessario converter o obj para outro tipo, no caso Serializable)
                intent.putExtra("objeto", (Serializable) usuario);

                /*Ou seja, quero passar o índice nome com o valor Danilo
                E quero passar o ídice idade com o valor 21    */


                //chamando a intent
                startActivity(intent);

            }
        });
    }
}