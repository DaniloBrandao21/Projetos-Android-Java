package brandao.android.mvvmexemplo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel {

    private MutableLiveData<Boolean> login = new MutableLiveData<>();
    public LiveData<Boolean> mLogin = login;

    public void fazLogin(String email){

        this.login.setValue(equals(email));
    }
}
