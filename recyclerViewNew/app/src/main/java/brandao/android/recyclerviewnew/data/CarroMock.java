package brandao.android.recyclerviewnew.data;

import java.util.ArrayList;
import java.util.List;

import brandao.android.recyclerviewnew.model.Carro;

public class CarroMock {

    private List<Carro> listaCarros;

    public CarroMock(){
        listaCarros = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            listaCarros.add(new Carro(i,String.valueOf(i)));
        }
    }

    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }
}
