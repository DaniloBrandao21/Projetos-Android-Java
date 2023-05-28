package brandao.android.a23_jamilton_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Primeiro método do ciclo de vida da activity
        Toast.makeText(
                this,
                "Oncreate Ativo",
                Toast.LENGTH_SHORT

        ).show();
    }
    //Segundo método do ciclo de vida da activity
    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(
                this,
                "onStart Ativo",
                Toast.LENGTH_SHORT

        ).show();
    }
    //Terceiro método do ciclo de vida da activity
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(
                this,
                "onResume Ativo",
                Toast.LENGTH_SHORT

        ).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(
                this,
                "onPause Ativo",
                Toast.LENGTH_SHORT

        ).show();

    }
    /*Chamado qando a atividade esta parada, o usuário já fechou essa atividade, mas não encerrou
    * Ela está em background parada esperando o retorno do usuario*/
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(
                this,
                "onStop Ativo",
                Toast.LENGTH_SHORT

        ).show();

    }
    /*Ao chamar esse método o processo é reiniciado  desde o onStart*/
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(
                this,
                "onRestart Ativo",
                Toast.LENGTH_SHORT

        ).show();
    }
    /*Sempre que o usuario encerrar a activity o osDestroy é chamado*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(
                this,
                "onDestroy Ativo",
                Toast.LENGTH_SHORT

        ).show();
    }
}