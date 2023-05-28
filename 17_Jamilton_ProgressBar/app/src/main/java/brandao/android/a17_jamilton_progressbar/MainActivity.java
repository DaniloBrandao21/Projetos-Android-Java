package brandao.android.a17_jamilton_progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal, progressBarCicular;
    private int progresso = 0;
    //private Button btnCarregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCicular = findViewById(R.id.progressBarCircular);
       // btnCarregar = findViewById(R.id.btnCarregar);

        progressBarCicular.setVisibility(View.GONE);

    }


    public void carregarProgressBar(View View){

        //progressBarHorizontal


            this.progresso = this.progresso + 1;
            progressBarHorizontal.setProgress(this.progresso);

        if(this.progresso == 10){

            progressBarHorizontal.setVisibility(android.view.View.GONE);

        }


        //progressBarCircular
        progressBarCicular.setVisibility(android.view.View.VISIBLE);

        if(this.progresso == 10){

            progressBarCicular.setVisibility(android.view.View.GONE);

        }



    }
}