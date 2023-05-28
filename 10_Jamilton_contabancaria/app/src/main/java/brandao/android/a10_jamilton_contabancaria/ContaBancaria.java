package brandao.android.a10_jamilton_contabancaria;

public class ContaBancaria {

    private int numeroConta;
    private double saldo;


    //método construtor --> não precisa de tipo, é o próprio da clase

    public ContaBancaria(){

        System.out.println("Configurações iniciais");
    }
    public ContaBancaria(int nConta){

        this.numeroConta = nConta;
        System.out.println("Construtor chamado " + nConta);
    }

}
