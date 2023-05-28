package brandao.android.a36_jamilton_minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {

    //Criando um atributo do tipo Context
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";

    //Criamos um construtor para recuperar o contexto e podermos usar o getSharedPreferences dentro da classe
    public AnotacoesPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarANotacao(String anotacao){

        editor.putString(CHAVE_NOME, anotacao);
        editor.commit(); 

    }
    public String  recuperarAnotacao(){

        return "";
    }
}
