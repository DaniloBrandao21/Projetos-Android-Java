package brandao.android.a24_jamilton_passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);

        //Recuperar os dados enviados

        /*Para recuperar utilizamos o objeto especial chamado Bundle
        Bundle - permite que recupere os dados que foram enviados de uma activity para outra */


        Bundle dados = getIntent().getExtras();  //Recuperar o que foi enviado como Extrar na nossa Intent


        //Recupera cada dado por vez. Utilizando o tipo do dados a variavel que o recebeu (dados) e a chave

        String  nome = dados.getString("nome");
        int  idade = dados.getInt("idade");

        //receber dados do objeto

        Usuario usuario = (Usuario) dados.getSerializable("objeto");
        // getSerializable retorna um objeto do tipo Serializable, então convertemos para Usuario (Usuario)


        //Configurar os valores recuperados

        //textNome.setText(nome);
        //textIdade.setText(String.valueOf(idade));

        //Configurar os valores recuperados do objeto

        textNome.setText(usuario.getEmail());
        textIdade.setText(String.valueOf(idade));


    }
}