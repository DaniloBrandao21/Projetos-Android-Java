package brandao.android.a38_jamilton_listadetaferas.Model;

import java.io.Serializable;

//Usamos o Serializable para transferir uma tarefa direto para outra tela

    public class Tarefas implements Serializable {

    public Long id;

    public String nomeTarefa;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {

        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {

        this.nomeTarefa = nomeTarefa;
        //nomeTarefa = nomeTarefa;
    }
}
