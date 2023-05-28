package brandao.android.a22_jamilton_cardview.model;

public class Postagem {
    private String nome;
    private String postagem;
    private int imagem;


    //posso instanciar uma postagem, mas não preciso passar os parametros
    public Postagem() {


    }
    //Construtor com parametros
    public Postagem(String nome, String postagem, int imagem) {
        this.nome = nome;
        this.postagem = postagem;
        this.imagem = imagem;
    }

    //Construtor com getter and setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
