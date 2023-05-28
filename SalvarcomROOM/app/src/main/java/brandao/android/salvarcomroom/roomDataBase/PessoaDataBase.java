package brandao.android.salvarcomroom.roomDataBase;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pessoa.class}, exportSchema = false, version = 1)

public abstract class PessoaDataBase extends RoomDatabase {

    private static final String DB_name = "data_db";
    private static PessoaDataBase instancia;

    public static synchronized PessoaDataBase getInstance(Context context){

            instancia = Room.databaseBuilder(context.getApplicationContext(), PessoaDataBase.class,DB_name)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();

            PessoaDao pessoaDao = instancia.pessoaDao();
        return instancia;
    }

    public abstract PessoaDao pessoaDao();


}
