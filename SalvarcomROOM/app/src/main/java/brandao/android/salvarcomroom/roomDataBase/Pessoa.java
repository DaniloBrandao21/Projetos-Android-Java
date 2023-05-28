package brandao.android.salvarcomroom.roomDataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "pessoa")
public class Pessoa {

    //@ColumnInfo dando nome as colunas
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "id")
    //transformando o id em chave primaria
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "address")
    private String address;

    @Ignore
    public Pessoa(int id) {
        this.id = id;
    }

    //Precisa ter um creator
    public Pessoa(String name, int id,  String address){

        this.name = name;
        this.id = id;
        this.address = address;
    }

    @Ignore
    public Pessoa(String name, String address){
        this.name = name;
        this.address = address;
    }

    //Criar setter para todos

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
