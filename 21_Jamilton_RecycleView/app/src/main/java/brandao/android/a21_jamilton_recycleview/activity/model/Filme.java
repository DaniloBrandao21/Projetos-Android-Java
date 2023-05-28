package brandao.android.a21_jamilton_recycleview.activity.model;
//Usamos o model para armazenar classe que vão modelas o nosso sistema
public class Filme {

    public String tituloFilme;
    public String genero;
    public String ano;

    public Filme(){}



    //Criamos um construtor para passar o nosso filme
    public Filme(String tituloFilme, String genero, String ano) {
        this.tituloFilme = tituloFilme;
        this.genero = genero;
        this.ano = ano;
    }


}
