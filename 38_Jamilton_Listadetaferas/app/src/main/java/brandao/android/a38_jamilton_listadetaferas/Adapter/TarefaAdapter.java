package brandao.android.a38_jamilton_listadetaferas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import brandao.android.a38_jamilton_listadetaferas.Model.Tarefas;
import brandao.android.a38_jamilton_listadetaferas.R;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

    private List<Tarefas> listaTarefas;

    public TarefaAdapter(List<Tarefas> lista) {

        this.listaTarefas = lista;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemlLista = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MyViewHolder(itemlLista);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Tarefas tarefas = listaTarefas.get(position);
        holder.tarefa.setText(tarefas.getNomeTarefa());

    }

    @Override
    public int getItemCount() {

        return this.listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;


      public MyViewHolder(@NonNull View itemView) {
          super(itemView);

          tarefa = itemView.findViewById(R.id.textTarefa);
      }
  }
}
