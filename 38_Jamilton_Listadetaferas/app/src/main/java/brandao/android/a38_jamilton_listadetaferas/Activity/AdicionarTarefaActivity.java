package brandao.android.a38_jamilton_listadetaferas.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import brandao.android.a38_jamilton_listadetaferas.Model.Tarefas;
import brandao.android.a38_jamilton_listadetaferas.R;
import brandao.android.a38_jamilton_listadetaferas.helper.TarefaDAO;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefas tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textoTarefa21);

        //Recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefas) getIntent().getSerializableExtra("tarefaSelecionada" );

        //Configurar  tarefa na caixa de texto
        if(tarefaAtual != null){

            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.itemSalvar:
           //Executa ação para o item salvar


                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if(tarefaAtual != null){//edição

                    String nomeTarefa = editTarefa.getText().toString();

                    if(!nomeTarefa.isEmpty()){

                        Tarefas tarefa = new Tarefas();
                        //configurando a tarefa com o novo nome
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        //atualizar no banco de dados
                        //se tarefaDAO.atualizar for verdadeiro executa o código e exibe msg
                        if(tarefaDAO.atualizar(tarefa)){

                            finish();
                            Toast.makeText(this, "Sucesso ao salvar a tarefa!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(this, "Erro ao salvar a tarefa!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    editTarefa.setText(tarefaAtual.getNomeTarefa());
                }else{//salvar

                    String nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){
                        Tarefas tarefas = new Tarefas();
                        tarefas.setNomeTarefa(nomeTarefa);

                        if( tarefaDAO.salvar(tarefas)){//Se for possivel salvar

                            finish();
                            Toast.makeText(this, "Sucesso ao salvar a tarefa!", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(this, "Erro ao salvar a tarefa!", Toast.LENGTH_SHORT).show();
                        }

                   }

                }

               break;



        }
        return super.onOptionsItemSelected(item);
    }
}