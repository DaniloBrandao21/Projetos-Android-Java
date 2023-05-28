package brandao.android.a32_jamilton_executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconder a statusBar e a barra de navegação
        //Recuperamos um objeto que nos perminte fazer modificações na tela
        //getWindow() recupera um objeto de tela
        //getDecorView() reupera um objeto que nos permite manipular componentes de tela

        View decorView = getWindow().getDecorView();

        //Manipular componenter de tela
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN; // Colocar em tela cheia

        decorView.setSystemUiVisibility(uiOpcoes);

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Executar o video

        //Configurando os controllers do video
        videoView.setMediaController(new MediaController(this));

        //Definindo local do video
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videorick );

        //Iniciar o video
        videoView.start();
    }
}