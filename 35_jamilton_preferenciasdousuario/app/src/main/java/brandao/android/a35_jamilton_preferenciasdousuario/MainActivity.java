package brandao.android.a35_jamilton_preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonsSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Parametros do getSharedPreferences
                            1- String name ---> nome do arquivo que queremos criar (Recomendado usar constantes)
                            2- Mode        ---> Modo de gravação que queremos fazer (modo 0/privado ---> Só o nosso app
                                                  vai poder salvar e ler o arquivo)
                 */
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                //Retorna um obj tipo Editor que poderesmos editar
                SharedPreferences.Editor editor = preferences.edit();

                //validar o nome
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o nome ", Toast.LENGTH_LONG).show();
                }else{
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();

                    textResultado.setText("Olá, " + nome);
                }

            }
        });

        //Recuperar os dados salvos

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0 );

        //validar se temos o nome em preferencia

        if(preferences.contains("nome")){

            String nome = preferences.getString("nome", "usuário não definido");
            textResultado.setText("Olá, " + nome);

        }else{
            textResultado.setText("Olá, usuário não definido");
        }

    }
}