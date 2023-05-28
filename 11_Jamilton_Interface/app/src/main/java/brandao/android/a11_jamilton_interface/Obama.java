package brandao.android.a11_jamilton_interface;

//implements ---> Para implementar uma interface

//Para o Obama ser presidente, ele precisa ganhar a eleição

public class Obama extends Cidadao implements Presidente{
    @Override
    public void ganharEleicao() {

        System.out.println("Ganhar uma eleição nos Estados Unidos ");

    }
}
