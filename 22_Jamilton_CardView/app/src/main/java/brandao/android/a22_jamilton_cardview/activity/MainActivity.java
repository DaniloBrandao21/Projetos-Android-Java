package brandao.android.a22_jamilton_cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import brandao.android.a22_jamilton_cardview.R;
import brandao.android.a22_jamilton_cardview.adapter.PostagemAdapter;
import brandao.android.a22_jamilton_cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerView);

        //Define Layout

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerPostagem.setLayoutManager(layoutManager);


        //Define o Adapter
        prepararPostagens();

        PostagemAdapter adapter = new PostagemAdapter(postagens);

        recyclerPostagem.setAdapter(adapter);
    }
    //Carregar as postagens de maneira mais simples
    public void prepararPostagens(){

        Postagem p = new Postagem("Maria Luiza", "#tbt viagem legal!", R.drawable.imagem_1_cardview);
        this.postagens.add(p);
         p = new Postagem("Hotel MJ", "Viaje, aproveite nossos descontos", R.drawable.imagem_2_cardview);
        this.postagens.add(p);
         p = new Postagem("Danilo", "Paris!", R.drawable.imagem_4_cardview);
        this.postagens.add(p);
         p = new Postagem("Marcão", "Que foto Linda!", R.drawable.imagem_3_cardview);
        this.postagens.add(p);



    }
}