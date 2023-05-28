package brandao.android.a37_jamilton_bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para utilizar recursos de um bando de dados precisamos colocar dentro de um try catch

        //Já que é um recurso muito sensivel precisamos testar pra ver se vai ser executado
        try{

            //Criar um BD
            /* Paramentros:
            * 1-Nome do banco
            * 2- Modo do banco, no caso privado, só o nosso app tem acesso
            * 3- Factory
            */

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");
            //AUTOINCREMENT --- > incrementa automaticamente os Id's
            //Excluir tabela
            //bancoDados.execSQL("DROP TABLE pessoas ");

            //Inserir dados

           // bancoDados.execSQL("UPDATE pessoas SET idade = 19 WHERE nome = 'Vanessa'");



           // String nome1 = "Daniel";
           // int idade1 = 32;

           // bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('"+nome1+"', "+idade1+")");
           // bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Danilo', 21) ");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Lizandra', 23) ");
          //  bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Maria', 35) ");
          //  bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Vanessa', 20) ");
          //  bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Pedro', 55) ");
           // bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Gabriel', 31) ");
           // bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES('Vitória', 25) ");

            //Recuperar as pessoas


            //Consulta -- Facilitando a consulta (resumindo códigos)

            String consulta =

                    "SELECT id, nome," +
                    " idade FROM pessoas";


                    /* Paramentros:
             * 1-SELECT
             * 2- SelectionArgs
             */
            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tabela

            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            //Iniciar o cursor
            cursor.moveToFirst();

            while(cursor != null){

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - nome",nome + "/ idade " + idade + " / id " + id);

                cursor.moveToNext();
            }

        }catch (Exception e){
            //Se der algum erro vai ser printado no log
            e.printStackTrace();
        }
    }

}