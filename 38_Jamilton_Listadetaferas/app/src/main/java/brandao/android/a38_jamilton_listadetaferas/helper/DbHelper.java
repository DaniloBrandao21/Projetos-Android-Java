package brandao.android.a38_jamilton_listadetaferas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    /*   Neste caso nós apagamos os parametros que estavam auatomaticamente no counstrutor (DbHelper)
    e Criamos nosso parametros abaixo (Versão do banco e nome do banco) podemos deixar o factory como null
    Factory serve para definição de cursor    */
    public static int VERSION = 4;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Criando tabelas
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT," + " nome TEXT NOT NULL" + " );";



        try{
            sqLiteDatabase.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao cria a tabela");

        }
        catch (Exception e){
            Log.i("INFO DB", "Erro ao cria a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;";

        try{
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("INFO DB", "Tabela atualizada com sucesso ");

        }catch (Exception e ){
                 Log.i("INFO DB", "Erro ao deletar a tabela" + e.getMessage());

        }

    }
}
