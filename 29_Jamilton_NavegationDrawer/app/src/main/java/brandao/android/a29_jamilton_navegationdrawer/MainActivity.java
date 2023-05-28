package brandao.android.a29_jamilton_navegationdrawer;

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

import brandao.android.a29_jamilton_navegationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Configura barra de navegação
        setSupportActionBar(binding.appBarMain.toolbar);

        //Cria referencia para toda area do NavigationDrawer
        DrawerLayout drawer = binding.drawerLayout;

        //Cria referencia para area de navegação
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //Configura os itens de navegação NavigationDrawer
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_contato)
                .setOpenableLayout(drawer)
                .build();

        //Configura a area que ira carregar os fragments
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        //Configura a opção que da acesso ao NavigationView || Permita que exiga o NavigationDrawer
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //Configura a navegação para o NavigationView || Permite a mudanção de fragments
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    //Cria o menu de opções
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    */

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}