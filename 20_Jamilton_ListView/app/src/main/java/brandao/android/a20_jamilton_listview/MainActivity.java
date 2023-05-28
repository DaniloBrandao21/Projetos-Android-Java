package brandao.android.a20_jamilton_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;


    //Craindo uma lista pré-definida
    private String[] itens = {"Eua", "Canadá", "Alemanha",
                              "Suécia", "África do Sul",
                              "Brasil", "Inglaterra", "México",
                               "Japão", "Guatemala", "Espanha",
                              "Portugal", "Chile", "Uruguai", "Argentina",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        /*Criar adaptador --> Serve para adaptar os itens que vão ser ixibidos na listagem
        de uma maneira que o listView consiga exibir*/

        /*Parametros do adapter: 1 --Contexto da aplicaçãp
                                 2 -- layout da lista (Nesse caso usamos um layout do padrão android
                                 3 -- id identificador do que iremos trabalhar dentro do layout
                                 4 -- Listagem


         */
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(

                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens

        );

        //Adicionar o adaptador na list

        listLocais.setAdapter(adaptador);

        //Adicionar click na lista

        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //recuperar a posição do item selecionado pelo usuário
                String valorSelecionado = listLocais.getItemAtPosition(i).toString();

                Toast.makeText(
                        getApplicationContext(),
                        valorSelecionado,
                        Toast.LENGTH_SHORT

                ).show();
            }
        });
    }
}