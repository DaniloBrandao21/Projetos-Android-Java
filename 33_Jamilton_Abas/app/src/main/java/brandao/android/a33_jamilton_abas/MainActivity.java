package brandao.android.a33_jamilton_abas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import brandao.android.a33_jamilton_abas.Fragment.EmAltaFragment;
import brandao.android.a33_jamilton_abas.Fragment.HomeFragment;
import brandao.android.a33_jamilton_abas.Fragment.InscricoesFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        //Configura a sombra
        getSupportActionBar().setElevation(0);


        //Configurar Adapter para as abas
       FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
            //Passando o gerenciador de Fragment
               getSupportFragmentManager(),
               FragmentPagerItems.with(this)

                       //O método add adiciona as abas
                       .add("Home", HomeFragment.class)
                       .add("Incrições", InscricoesFragment.class)
                       .add("Em Alta", EmAltaFragment.class)
               .create()

       );

       //Configuração do ViewPager

            //configurando adapter no viewpager
        viewPager.setAdapter(adapter);
            //Configurando o viewPager no smartTabLayout
        smartTabLayout.setViewPager(viewPager);
    }
}