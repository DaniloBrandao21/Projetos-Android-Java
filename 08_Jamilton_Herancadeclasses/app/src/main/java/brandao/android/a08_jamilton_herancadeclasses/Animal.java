package brandao.android.a08_jamilton_herancadeclasses;

class Animal {
    int tamanho;
    String cor;
    double peso;

    //método getter and setter

    // É possivel gerar os métodos get and set automaticamente, clicando com o botão direito e ir em generate

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTamanho() {
        return tamanho;
    }

    public double getPeso() {
        return peso;
    }

    void setCor(String cor){
        this.cor = cor;
    }

    String getCor(){
        return this.cor;
    }

    void dormir(){

        System.out.println("ZzzZzzz");
    }
    void correr(){
        System.out.println("Correndo como um ");
    }
}
