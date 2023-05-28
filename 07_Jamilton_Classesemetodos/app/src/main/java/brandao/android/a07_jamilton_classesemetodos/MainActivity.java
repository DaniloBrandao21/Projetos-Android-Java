package brandao.android.a07_jamilton_classesemetodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Funcionario funcionario = new Funcionario();
        
        funcionario.nome = "Danilo";
        funcionario.salario = 1200.21;

        //Retornou um valor do método recuperarSalario e jogou para a nova variavel salarioRecuperado
        double salarioRecuperado = funcionario.recuperarSalario(1000);

        System.out.println("O Salário do " + funcionario.nome + " é de:  " + salarioRecuperado + " Reais!");


        /*Casa minhaCasa = new Casa();
        //Também é possivel criar um objeto dessa forma
       Casa minhaCasa2;
        minhaCasa2 = new Casa();

        minhaCasa.cor = "Azul";

        minhaCasa2.cor = "Branca";

        System.out.println(minhaCasa.cor);

        minhaCasa.abrirPorta();*/




    }
}