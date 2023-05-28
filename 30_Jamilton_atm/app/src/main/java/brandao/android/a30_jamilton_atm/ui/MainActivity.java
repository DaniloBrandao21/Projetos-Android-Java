package brandao.android.a30_jamilton_atm.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import brandao.android.a30_jamilton_atm.R;
import brandao.android.a30_jamilton_atm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();

            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre
               )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

       // String celular = "tel:41996465661";
       // String imagem = "https://ciclovivo.com.br/wp-content/uploads/2018/10/iStock-536613027.jpg";

        //Como fazer uma ligação
        //ACTION_DIAL abre a opção pra fazer ligaçõe, mas não faz diretamente. Outras opções realizam a ligação automaticamente
        /*parametros --> 1º declara a action dial ---> intenção de ligar pra alguém
                         2º declara o número de telefone para qual quero ligar/ o parte vai converter uma String
                         para um objeto do tipo URI

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        startActivity(intent);
        */

        /*Abrindo uma imagem no google
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        startActivity(intent);
        //O android vai abrir o app que faz ligações

         */

        //Para ACTION_SEND eu posso configurar os paramentros no próprio objeto intent

        Intent intent = new Intent(Intent.ACTION_SEND);
        //Define pra qual ou quais email vc vai mandar
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        //Define o assunto do email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo APP");
        //Define a mensagem q será enviada
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automatica");


        intent.setType("message/rfc822"); // tipo para envio de email


        // intent.setType("text/plain"); tipo para envio de email



        startActivity(Intent.createChooser(intent, "Compartilhar")); //titulo do SNACKBAR que vai aparecer

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}