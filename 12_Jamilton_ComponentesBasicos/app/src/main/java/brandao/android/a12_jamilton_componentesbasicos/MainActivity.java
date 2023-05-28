package brandao.android.a12_jamilton_componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Criando uma variavel EditText
    private EditText campoNome;
    private EditText campoEmail;
    private TextView resultado;

    //CheckBox
    private CheckBox checkVerde, checkVermelho, checkBranco;

    //RadioButton
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup opcaoSexo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionando as variaveis com os id
         campoNome       = findViewById(R.id.editNome);

         campoEmail      = findViewById(R.id.editEmail);

         resultado       = findViewById(R.id.textResultado);


         //Checkbox
         checkVerde      = findViewById(R.id.checkVerde);
         checkVermelho   = findViewById(R.id.checkVermelho);
         checkBranco     = findViewById(R.id.checkBranco);

         //RadioButton
        sexoMasculino    = findViewById(R.id.radioMasculino);
        sexoFeminino     = findViewById(R.id.radioFeminino);

        //RadioGroup
        opcaoSexo = findViewById(R.id.radioGrupoSexo);

        radioButton();

    }

    public void radioButton(){

       opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {

               //A condição do if funciona das duas maneiras, colococando a validação ou puxando qual foi marcada
               if(sexoFeminino.isChecked()){
                   resultado.setText( sexoFeminino.getText().toString());
               } else if(checkedId == R.id.radioMasculino){
                   resultado.setText( sexoMasculino.getText().toString());
               }



           }
       });

        /*

        if(sexoFeminino.isChecked()){

            resultado.setText("Feminino Selecionado");

        }
        else if(sexoMasculino.isChecked()){

            resultado.setText("Masculino Selecionado");
        }

         */

    }

    public void enviar(View View){

        //radioButton();
       // CheckBox();


/*
        //Capturando o que foi digitado no campo nome e jogando para uma nova variavel
        String nome = campoNome.getText().toString();

        //Capturando o que foi digitado no campo email e jogando para uma nova variavel
        String email = campoEmail.getText().toString();

        //Exibindo o nome na caixa resultado
        resultado.setText(nome + " \n" + email);*/

    }
    public void CheckBox(){

        //isChecked checa se o check está marcado ou não

        //Inicializa a variavel
        String texto = "";
        if(checkVerde.isChecked())
        {
            // texto = "Verde selecionado - ";

            String corSelecionada = checkVerde.getText().toString();
            texto = corSelecionada;

        }
        if(checkBranco.isChecked())
        {

            //texto =  + "\nBranco selecionado - ";

            String corSelecionada = checkBranco.getText().toString();
            texto = texto + corSelecionada;
        }
        if(checkVermelho.isChecked())
        {

            //texto = texto + "\nVermelho selecionado";

            String corSelecionada = checkVermelho.getText().toString();

            texto = texto + corSelecionada;


        }
        resultado.setText(texto);


    }

    public void limpar(View View){

        campoNome.setText("");
        campoEmail.setText("");

    }

}