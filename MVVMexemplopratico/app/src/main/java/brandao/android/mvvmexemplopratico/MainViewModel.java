package brandao.android.mvvmexemplopratico;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Boolean> mlogin = new MutableLiveData<>();
    public LiveData<Boolean> login = mlogin;

    //Criando um método login

    public void doLogin(String email){
        if (email.equals("")){
            this.mlogin.setValue(false);
        }else {
            this.mlogin.setValue(true);
        }
    }
}
