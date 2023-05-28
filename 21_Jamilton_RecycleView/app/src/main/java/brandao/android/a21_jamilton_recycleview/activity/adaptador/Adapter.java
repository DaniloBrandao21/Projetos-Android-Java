package brandao.android.a21_jamilton_recycleview.activity.adaptador;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import brandao.android.a21_jamilton_recycleview.R;
import brandao.android.a21_jamilton_recycleview.activity.model.Filme;


//Adapter.MyViewHolder ---> Utilizando a classe MyViewHolder que está dentro da classe adapter
//RecyclerView.Adapter ---> Utilizando a classe Adapter que está dentro da classe RecycleView

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;
    //método construtos do adapter para receber a lista de filmes

    public Adapter(List<Filme> lista) {

        this.listaFilmes = lista;

    }

    @NonNull
    @Override
    /*Esse método é chamado para que possamos criar as nossas visualizações/
    chamado até criar as visualizações que serão exibidas para o usuário/
    Quando clicar e arrastar pra baixo, ele não vai mais criar visualizações, ele vai reciclar
     */
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /*Informações e parametros sobre o LayoutInflater
        primeiro -- converter o XML (adapter_lista.xml) para um objeto do tipo View
        Usamos a classe LayoutInflater para converter o XML em uma visualização (Infliar o XML)
        from(parent.getContext()) --> Recuperar o contexto baseado no componente que a nossa itemLista está dentro
        parent é o componente que a nossa itemLista está dentro

        Informações e parametros sobre o inflate

        Parametros 1 -- Escolher o Layout (adapter_lista) dentro do arquivo R
                   2 -- parent
                   3 -- boolean -- permite adicioar o itemLista ao elemento Root*/


        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        //O VH vai configurar os dados dentro da nossa visualização baseada no XML (itemLista)
        return new MyViewHolder(itemLista);

    }
    /*Exibição dos itens
    * O objeto MyViewHolder é passado para o método onBindViewHolder (holder)
    * Esse método será chamado a quantidade de vezes necessaárias para o nosso getItemCount (exibir 5 itens)*/
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get( position );
        holder.titulo.setText(filme.tituloFilme);
        holder.genero.setText(filme.genero);
        holder.ano.setText(filme.ano);

    }
    /*getItemCount retorna a quantidade de itens que serão exibidos*/
    @Override
    public int getItemCount() {
        //descobrir o tamanho da lista
        return listaFilmes.size();
    }


    // VH = ViewHolder --> Guardar itens para reaproveitar as Views e mudar apenas os dados

    //Cada um dos itens é um objeto da classe VH
    //Está classe é responsavel por guardar cada um dos dados antes deless serem exibidos na tela
    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Criando Atributos para guardar no VH

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /*Agora vamos localizar os componentes
            o item View é quem acessa o nosso objeto View (acessar os ID's
            * */
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}
