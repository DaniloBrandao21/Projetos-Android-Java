package brandao.android.a36_jamilton_minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import brandao.android.a36_jamilton_minhasanotacoes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private AnotacoesPreferencias preferencias;

    private EditText editAnotacao;

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



      editAnotacao = findViewById(R.id.editAnotacao);

        //Passando o contexto
        preferencias = new AnotacoesPreferencias( getApplication());


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();


     binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                                                                                                                                         String textoRecuperado = editAnotacao.getText().toString();
                //Verificando se o usuario digitou alguma coisa

                if(textoRecuperado.equals("")){

                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();

                }else{

                    preferencias.salvarANotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }


}