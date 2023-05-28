package brandao.android.a13_jamilton_alcoolougasolina;

import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
//Adicionar depois, quantos Km o carro faz com gasolina e com alcool para fazer um calculo mais preciso
public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;

    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);

        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);

        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View View){

        //Recuperar os valores digitados pelo usuário
        String precoAlcool = editPrecoAlcool.getText().toString();

        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validação dos campos

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if(camposValidados){

            //converter String para número

            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            if(valorAlcool/valorGasolina >= 0.7){

                textResultado.setText("Melhor Utilizar gasolina ");
            }else{
                textResultado.setText("Melhor utilizar Alcool ");
            }


        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    private Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;


        //Pode ser utilizado os dois tipos de validação nesse caso
        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;


        } else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }

        return camposValidados;
    }


}