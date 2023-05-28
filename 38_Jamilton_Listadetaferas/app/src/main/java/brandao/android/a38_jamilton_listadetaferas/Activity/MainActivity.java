package brandao.android.a38_jamilton_listadetaferas.Activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import brandao.android.a38_jamilton_listadetaferas.Adapter.TarefaAdapter;
import brandao.android.a38_jamilton_listadetaferas.Model.Tarefas;
import brandao.android.a38_jamilton_listadetaferas.R;
import brandao.android.a38_jamilton_listadetaferas.databinding.ActivityMainBinding;
import brandao.android.a38_jamilton_listadetaferas.helper.DbHelper;
import brandao.android.a38_jamilton_listadetaferas.helper.RecycleItemClickListener;
import brandao.android.a38_jamilton_listadetaferas.helper.TarefaDAO;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefas> listaTarefas = new ArrayList<>();
    private Tarefas tarefaSelecionada;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);




        //Configurar recycleView
        recyclerView = findViewById(R.id.recyclerView);

        DbHelper db = new DbHelper(getApplicationContext());


        //ContentValues cv = new ContentValues();
        //cv.put("nome", "teste");

        //db.getWritableDatabase().insert("tarefas", null, cv);

        /*Paramentros  db.getWritableDatabase().insert  1-- tabela onde desejamos salvar
        *                                               2--
        *                                               3-- Dados que desejamos salvar*/


        /*Para salvar os dados precisamos da classe ContentValues para criar a estrutura
        Essa classe permite que possamos definir itens, quase como um Array
        Parametros do método .put 1-- Chave --> Nome do campo (nome da tarefa, o Id já é AUTOINCREMENT)
                                  2-- valor do campo
         */

        //adicionar evento de click

        recyclerView.addOnItemTouchListener(
               new RecycleItemClickListener(
                       getApplicationContext(),
                       recyclerView,
                       new RecycleItemClickListener.OnItemClickListener() {
                           @Override
                           public void onItemClick(View view, int position) {

                               //recuper tarefa para edição

                               Tarefas tarefaSelecionada = listaTarefas.get(position);

                               //Enviar tarefa para tela adicionar tarega

                               Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                               intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                               startActivity(intent);

                           }

                           @Override
                           public void onLongItemClick(View view, int position) {

                               //Recuperando a tarefa para deletar
                                   tarefaSelecionada = listaTarefas.get(position);


                               AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                               //Configurar titulo e msg

                               dialog.setTitle("Confirmar exclusão ");

                               dialog.setMessage("Deseja excluir a tarefa: " + tarefaSelecionada.getNomeTarefa()+" ?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                                        if(tarefaDAO.deletar(tarefaSelecionada)){
                                            carregarListTarefas();
                                            Toast.makeText(getApplicationContext(), "Sucesso ao deletar a tarefa!",
                                                    Toast.LENGTH_SHORT)
                                                    .show();

                                        }else{
                                            Toast.makeText(getApplicationContext(), "Erro ao deletar a tarefa!",
                                                    Toast.LENGTH_SHORT)
                                                    .show();
                                        }

                                    }
                                });

                               dialog.setNegativeButton("Não", null);

                                //Exibir dialog
                               dialog.create();
                               dialog.show();

                           }

                           @Override
                           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                           }
                       }
               )
        );



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void carregarListTarefas(){

        //Listar tarefas

       TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
       listaTarefas = tarefaDAO.listar();


        /*
        * Exibe Lista de tarefas no recycleView*/

      //  list<Tarefas>

        //Configurar Adapter

        tarefaAdapter = new TarefaAdapter( listaTarefas  );

        //Configurar recyclewView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);
    }

    @Override
    protected void onStart() {
        carregarListTarefas();
        super.onStart();
    }
}