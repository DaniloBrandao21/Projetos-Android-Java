package brandao.android.binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button buttonMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonMostrar = findViewById(R.id.buttonMostrar);

        Bundle dados = getIntent().getExtras();

        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");

        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Nome " + nome + "e idade " + idade, Toast.LENGTH_LONG).show();
            }
        });


    }
}