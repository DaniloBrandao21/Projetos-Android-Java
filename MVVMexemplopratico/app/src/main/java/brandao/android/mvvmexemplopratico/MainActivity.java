package brandao.android.mvvmexemplopratico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditEmail;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mEditEmail = findViewById(R.id.editEmail);
        this.mButtonLogin = findViewById(R.id.buttonLogin);

        final MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

        this.mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEditEmail.getText().toString();
                vm.doLogin(email);
            }
        });
        vm.login.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean sucess) {
                if(sucess){
                    Toast.makeText(getApplicationContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Erro!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}