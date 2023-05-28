package brandao.android.mvvmexemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import brandao.android.mvvmexemplo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

        private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(R.layout.activity_main);


        final MainViewModel mV = new ViewModelProvider(this).get(MainViewModel.class);

        this.binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.email.getText().toString();
                mV.fazLogin(email);

            }
        });

        mV.mLogin.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(true){
                    Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}