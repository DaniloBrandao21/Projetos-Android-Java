package brandao.android.salvarcomroom.roomDataBase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PessoaDao {


    //Listar pessoas
    @Query("SELECT * FROM Pessoa")
    MutableLiveData<List<Pessoa>> getPessoa();

    //Inserir pessoas
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPessoa(Pessoa pessoa);

    //Deletar pessoas
    @Delete
    void deletePessoa(Pessoa pessoa);

    //Atualizar pessoa
    @Query("UPDATE pessoa SET name =:name WHERE id =:id")
    void updatePessoa(String name, int id);

}
