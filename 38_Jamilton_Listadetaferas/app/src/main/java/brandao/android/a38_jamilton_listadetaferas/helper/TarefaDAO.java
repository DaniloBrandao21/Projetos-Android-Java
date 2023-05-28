package brandao.android.a38_jamilton_listadetaferas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import brandao.android.a38_jamilton_listadetaferas.Model.Tarefas;

public class TarefaDAO implements iTarefaDAO{

    // vamos atulizar o escreve para salvar/escrever em uma tabela
    private SQLiteDatabase escreve;

    // vamos atulizar o le para ler as tabelas;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {

        DbHelper db = new DbHelper(context);

        //Recuperar um objeto que permite salvar no banco de dados
        escreve = db.getWritableDatabase();

        //Recuperar um objeto que nos permite ler os dados em uma tabela
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefas tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
       try{
           escreve.insert(DbHelper.TABELA_TAREFAS,null, cv);
           Log.i("INFO", "Sucesso ao salvar tarefa");

       }catch(Exception e){

           Log.i("INFO", "Erro ao salvar tarefa" + e.getMessage());

           return false;
       }

        return true;
    }

    @Override
    public boolean atualizar(Tarefas tarefa) {


        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        try{
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS, cv, "id = ?",args);
            Log.i("INFO", "Tarefa atualizada com sucesso!");

        }catch (Exception e){

            Log.i("INFO", "esso ao atualizada com sucesso!" + e.getMessage());

        }
        return true;
    }

    @Override
    public boolean deletar(Tarefas tarefa) {

        try{
            String [] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS,"id = ?",args );
            Log.i("INFO", "Tarefa atualizada com sucesso!");

        }catch (Exception e){

            Log.i("INFO", "esso ao atualizada com sucesso!" + e.getMessage());
            return false;

        }

        return true;
    }

    @Override
    public List<Tarefas> listar() {

        //Criar uma lista tarefas para retornar a lista de tarefas

        List<Tarefas> tarefas = new ArrayList<>();


        //Recuparar as tarefas direto do BD


        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS +";";


        Cursor c = le.rawQuery(sql, null);


        while(c.moveToNext()){

            Tarefas tarefa = new Tarefas();
           Long id = c.getLong(c.getColumnIndexOrThrow("id"));
          String nomeTarefa = c.getString(c.getColumnIndexOrThrow("nome"));

        tarefa.setId( id);
        tarefa.setNomeTarefa(nomeTarefa);

        //criamos um objeto tarefa pq o nosso arrayList de retorno é um List de objetos tarefas


            //adicionando tarefa ao list
            tarefas.add(tarefa);

        }




        return tarefas;
    }
}
