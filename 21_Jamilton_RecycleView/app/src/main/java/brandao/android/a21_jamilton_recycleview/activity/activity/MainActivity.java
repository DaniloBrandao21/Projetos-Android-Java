package brandao.android.a21_jamilton_recycleview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import brandao.android.a21_jamilton_recycleview.R;
import brandao.android.a21_jamilton_recycleview.activity.RecyclerItemClickListener;
import brandao.android.a21_jamilton_recycleview.activity.adaptador.Adapter;
import brandao.android.a21_jamilton_recycleview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<Filme>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        //Listagem de filmes
        this.criarFilmes();

        //configurar adapter
        Adapter adapter = new Adapter(listaFilmes);



        //configurar RecycleView

        //LayoutManager = gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true); //Deixa um tamanho fixo para o recycleView/Otimiza o recycle
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));//Adicionando divisores
        recyclerView.setAdapter(adapter);

        //Evento de click

        recyclerView.addOnItemTouchListener(

                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item Pressionado: " + filme.tituloFilme,
                                        Toast.LENGTH_SHORT

                                ).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.tituloFilme,
                                        Toast.LENGTH_SHORT

                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );


    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao Lar", "Aventura", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Captão América - Guerra Civíl", "Aventura /Ficção", "2016");
        listaFilmes.add(filme);

        filme = new Filme("It: A coisa", "Drama/Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Pica-Pau", "Comédia/Animação", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A múmia", "Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A bela e fera", "Romance", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        listaFilmes.add(filme);


    }
}