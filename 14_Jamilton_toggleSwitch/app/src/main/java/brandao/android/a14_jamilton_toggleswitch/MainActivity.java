package brandao.android.a14_jamilton_toggleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleSenha;
    private Switch switchSenha;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        resultado = findViewById(R.id.textResultado);
        adicionarListener();
    }
    public void adicionarListener(){
        toggleSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    resultado.setText("ligado ");
                }else{
                    resultado.setText("desligado ");
                }

            }
        });
    }

    public void enviar(View View){
        if(switchSenha.isChecked()){
            resultado.setText("switchligado ");
        }else{
            resultado.setText("switch desligado ");
        }

    }
}