package brandao.android.a07_jamilton_classesemetodos;

 class Funcionario {

     //Propriedades

     String nome;
     double salario;


     //Métodos


     //Método Sem RETORNO
    /* void recuperSalario(){

         //Pegou o salario, fez um calculo e jogou para outra variavel
         double salarioReajustado = this.salario - (this.salario * 0.1);

         System.out.println("Salário Inicial: " + this.salario);



        System.out.println("Salário com descontos: " + salarioReajustado);
        }
    */

     //Método Com RETORNO
     double recuperarSalario(double bonus){

         this.salario = this.salario - (this.salario * 0.1);

         return this.salario + bonus;
     }


}
