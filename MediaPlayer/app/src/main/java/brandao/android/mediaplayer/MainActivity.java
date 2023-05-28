package brandao.android.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Criando objeto do tipo MediaPlayer
    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;
    private TextView textVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVolume = findViewById(R.id.textVolume);


        //Executando o arquivo
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        inicializarSeekBar();

    }

    private void inicializarSeekBar(){
        seekVolume = findViewById(R.id.seekVolume);

        //Configura o audio mananger

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Recuperar os valores de volume MAX e o volume atual

        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //Configurar o volume máximo para o seekbar

        seekVolume.setMax(volumeMaximo);

        //Configurar o progresso atual do seekbar

        seekVolume.setProgress(volumeAtual);

        //Possibilitando que o usuario mude o volume atráves do seekbar
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, AudioManager.FLAG_SHOW_UI);

                textVolume.setText("Volume: "+ i + "/"+ volumeMaximo);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
    }

    public void executarSom(View view){

        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }
    public void pararSom(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    public void encerrarSom(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            /*A função stop encerra a execução do arquivo e remove a refencia que criamos para o arquivo
            logo, não é possível executar a música novamente, para isso precisamos criar novamente a referencia
            Configurando o objeto mediaPlayer com o arquivo que queremos executar
             */

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }
    }
    //Quando a activity for destruida vamos remover todos os recursos da memória
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){

            //Para a música
            mediaPlayer.stop();
            //Libera recursos de mídia que esteja executando com a classe
            mediaPlayer.release();
            //Configurar midiaplayer como null para não ocupar espaço de memória com a classe nem com a música
            mediaPlayer = null;

        }
    }

    //Pausar a música quando sai do app
    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
}