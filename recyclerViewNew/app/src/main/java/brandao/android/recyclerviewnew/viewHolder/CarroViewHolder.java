package brandao.android.recyclerviewnew.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import brandao.android.recyclerviewnew.R;
import brandao.android.recyclerviewnew.model.Carro;


public class CarroViewHolder extends RecyclerView.ViewHolder {

    private TextView tvModelo;


    public CarroViewHolder(@NonNull View itemView) {
        super(itemView);

        tvModelo = itemView.findViewById(R.id.tvModelo);
    }

    public void bindData(Carro carro) {

        tvModelo.setText(carro.getModelo());
    }
}
