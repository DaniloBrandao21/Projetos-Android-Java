package brandao.android.a34_jamilton_aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import brandao.android.a34_jamilton_aprendaingles.Fragment.BichosFragment;
import brandao.android.a34_jamilton_aprendaingles.Fragment.NumerosFragment;
import brandao.android.a34_jamilton_aprendaingles.Fragment.VogaisFragment;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    private ImageButton imageViewCachorro;
    private ImageButton imageViewGato;
    private ImageButton imageViewLeao;
    private ImageButton imageViewMacaco;
    private ImageButton imageViewOvelha;
    private ImageButton imageViewVaca;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.smartTabLayout);
        viewPager = findViewById(R.id.viewPager);


        getSupportActionBar().setElevation(0);




        //Configurando adapter

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                //passando o gerenciador de fragment
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Bichos", BichosFragment.class)
                        .add("Números", NumerosFragment.class)
                        .add("Vogais", VogaisFragment.class)

                    //Adicionando abas

                .create()
        );

        //Configuração do viewPager
        //settando adapter
        viewPager.setAdapter(adapter);
        //settando viewPager no smartTabLayout
        smartTabLayout.setViewPager(viewPager);





    }

}