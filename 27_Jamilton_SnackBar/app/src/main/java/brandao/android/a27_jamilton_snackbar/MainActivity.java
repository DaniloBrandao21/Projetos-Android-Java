package brandao.android.a27_jamilton_snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Podemos declarar assim Snackbar snackbar =  Snackbar.make ou assim...
                //A diferença é que podemos chamar a snakbar pelo snackbar.show;
            Snackbar.make(
                        view,
                        "Botão pressionado",
                        Snackbar.LENGTH_LONG
                )
                        /*Para definir uma ação para o SnackBar, no caso muda o botão de Abrir Snackbar para Botão alterado
                        Apartir do confirmar */
                        .setAction("Confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonAbrir.setText("Botão abrir Alterado");
                    }
                })
                    //Ação para definir a cor do botão confirmar

                    .setActionTextColor(getResources().getColor(R.color.purple_200))
                    .show();

            }
        });
    }
}