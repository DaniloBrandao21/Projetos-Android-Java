package brandao.android.a34_jamilton_aprendaingles.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import brandao.android.a34_jamilton_aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mediaPlayer;

    private ImageButton imageViewCachorro;
    private ImageButton imageViewGato;
    private ImageButton imageViewLeao;
    private ImageButton imageViewMacaco;
    private ImageButton imageViewOvelha;
    private ImageButton imageViewVaca;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);


        imageViewCachorro =  view.findViewById(R.id.imageViewCachorro);
        imageViewGato = view.findViewById(R.id.imageViewGato);
        imageViewLeao =view.findViewById(R.id.imageViewLeao);
        imageViewMacaco = view.findViewById(R.id.imageViewMacaco);
        imageViewOvelha = view.findViewById(R.id.imageViewOvelha);
        imageViewVaca = view.findViewById(R.id.imageViewVaca);


        //Aplica eventos de click em todos os botões
        imageViewCachorro.setOnClickListener(this);
        imageViewLeao.setOnClickListener(this);
        imageViewGato.setOnClickListener(this);
        imageViewMacaco.setOnClickListener(this);
        imageViewVaca.setOnClickListener(this);
        imageViewOvelha.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        //Recuperando o Id do item que foi clicado e depois verifica o item
        switch (view.getId()){
            case R.id.imageViewCachorro:

                /*Para passar o contexto correto precisamos do getActivity, já recuperarmos o contexto
                da nossa getActivity principal, não vamos utilizar o contexto do Fragment*/

                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audiocachorro);
                tocarSom();
                break;

            case R.id.imageViewGato:

                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audiogato);
                tocarSom();
                break;

            case R.id.imageViewLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audioleao);
                tocarSom();
                break;

            case R.id.imageViewMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audiomacaco);
                tocarSom();
                break;

            case R.id.imageViewOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audioovelha);
                tocarSom();
                break;

            case R.id.imageViewVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audiovaca);
                tocarSom();
                break;
        }

    }
    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            //Ação para quando o som terminar ele limpar a memória
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}