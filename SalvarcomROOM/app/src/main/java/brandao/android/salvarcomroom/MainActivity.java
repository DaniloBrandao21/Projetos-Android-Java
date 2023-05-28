package brandao.android.salvarcomroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import brandao.android.salvarcomroom.roomDataBase.Pessoa;
import brandao.android.salvarcomroom.roomDataBase.PessoaDataBase;

public class MainActivity extends AppCompatActivity {

    Button save, update, delete;
    EditText nameSave, addressSave, nameUpdate, idUpdate, idDelete;
    ListView personList;

    PessoaDataBase pessoaDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.buttonSave);
        update = findViewById(R.id.buttonUpdate);
        delete = findViewById(R.id.buttonDelete);

        nameSave = findViewById(R.id.personNameSave);
        addressSave = findViewById(R.id.personAddressSave);
        nameUpdate = findViewById(R.id.namePersonUpdate);
        idUpdate = findViewById(R.id.idPersonUpdate);
        idDelete = findViewById(R.id.idPersonDelete);

        personList = findViewById(R.id.personList);




        pessoaDataBase = PessoaDataBase.getInstance(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoaDataBase.pessoaDao().insertPessoa(new Pessoa(nameSave.getText().toString(),
                        addressSave.getText().toString()));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoaDataBase.pessoaDao().deletePessoa(new Pessoa(Integer.parseInt(idDelete.getText().toString())));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoaDataBase.pessoaDao().updatePessoa(nameUpdate.getText().toString(),
                        Integer.parseInt(idUpdate.getText().toString()));
            }
        });

        //select all person
        pessoaDataBase.pessoaDao().getPessoa().observe(this, new Observer<List<Pessoa>>() {
                    @Override
                    public void onChanged(List<Pessoa> pessoas) {

                        if(pessoas == null){
                            Toast.makeText(MainActivity.this,"Sem dados", Toast.LENGTH_LONG).show();
                        }
                        else{
                            ArrayList<String> personNames = new ArrayList<>();
                            for (Pessoa pessoa : pessoas){
                                personNames.add(pessoa.getId() +" : "+pessoa.getName());
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                    android.R.layout.simple_list_item_1);
                            personList.setAdapter(adapter);
                        }


                    }
                });

    }
  }