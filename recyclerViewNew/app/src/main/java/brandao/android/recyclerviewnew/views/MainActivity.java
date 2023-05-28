package brandao.android.recyclerviewnew.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import brandao.android.recyclerviewnew.R;
import brandao.android.recyclerviewnew.adapter.carrosAdapter;
import brandao.android.recyclerviewnew.data.CarroMock;
import brandao.android.recyclerviewnew.model.Carro;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.rv_carros = findViewById(R.id.rv_carros);

        CarroMock carroMock = new CarroMock();
        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.addAll(carroMock.getListaCarros());


        //adapter
        carrosAdapter carrosAdapter = new carrosAdapter(listaCarros);
        mViewHolder.rv_carros.setAdapter(carrosAdapter);

        //layout

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.rv_carros.setLayoutManager(linearLayoutManager);


    }

    private static class ViewHolder{
        RecyclerView rv_carros;
    }
}
