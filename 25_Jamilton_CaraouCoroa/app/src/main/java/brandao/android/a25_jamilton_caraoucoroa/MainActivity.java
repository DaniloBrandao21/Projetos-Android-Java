package brandao.android.a25_jamilton_caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonJogar = findViewById(R.id.imageButtonJogar);

        imageButtonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Pasaar dados para próxima tel

                Intent intent= new Intent(getApplicationContext(), ResultadoActivity.class);

                int random = new Random().nextInt(2);//0 1
                intent.putExtra("resultado", random);

                startActivity(intent);

            }
        });
    }
}