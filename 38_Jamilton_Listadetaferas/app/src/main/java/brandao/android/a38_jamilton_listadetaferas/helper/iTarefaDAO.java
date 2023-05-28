package brandao.android.a38_jamilton_listadetaferas.helper;

import java.util.List;

import brandao.android.a38_jamilton_listadetaferas.Model.Tarefas;

public interface iTarefaDAO {

    //Criando métodos para\
    public boolean salvar(Tarefas tarefa);
    public boolean atualizar(Tarefas tarefa);
    public boolean deletar(Tarefas tarefa);
    public List<Tarefas> listar();

}
