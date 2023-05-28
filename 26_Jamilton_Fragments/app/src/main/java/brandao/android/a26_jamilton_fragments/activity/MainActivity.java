package brandao.android.a26_jamilton_fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import brandao.android.a26_jamilton_fragments.R;
import brandao.android.a26_jamilton_fragments.fragment.ContatosFragment;
import brandao.android.a26_jamilton_fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContato;

    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContato = findViewById(R.id.buttonContato);
        buttonConversa = findViewById(R.id.buttonConversas);


        //Remover a sombra da actionBar

        getSupportActionBar().setElevation(0);


    //Configurando botãoConversas

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();                                                   
            }
        });


        //Configurando botãoContato
        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frameConteudo, contatosFragment);

                transaction.commit();

            }
        });
    }
}