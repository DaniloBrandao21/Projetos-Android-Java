package brandao.android.a09_jamilton_modificadores;

public class Conta
{
    protected int numeroConta;
    protected double saldo = 300;

    public double recuperarSaldo(){
        return this.saldo;
    }

    public void depositar(double valorDeposito){

        this.saldo = this.saldo + valorDeposito;

    }

    public void sacar(double valorSaque){

        this.saldo = this.saldo - valorSaque;
}



}
