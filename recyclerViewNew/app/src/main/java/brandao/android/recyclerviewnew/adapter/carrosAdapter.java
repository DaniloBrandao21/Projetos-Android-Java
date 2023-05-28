package brandao.android.recyclerviewnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import brandao.android.recyclerviewnew.model.Carro;
import brandao.android.recyclerviewnew.viewHolder.CarroViewHolder;
import brandao.android.recyclerviewnew.R;

public class carrosAdapter extends RecyclerView.Adapter<CarroViewHolder> {

    private List<Carro> listaCarros;
    public carrosAdapter(List<Carro> lista){
        listaCarros = lista;

    }
    @NonNull
    @Override
    public CarroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View carroView = inflater.inflate(R.layout.carro_list, parent, false);
        return new CarroViewHolder(carroView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarroViewHolder holder, int position) {

        Carro carro = listaCarros.get(position);
        holder.bindData(carro);


    }

    @Override
    public int getItemCount() {
        return listaCarros.size();
    }

}
