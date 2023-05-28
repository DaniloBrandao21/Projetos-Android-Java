package brandao.android.a34_jamilton_aprendaingles.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import brandao.android.a34_jamilton_aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageViewNumber1,imageViewNumber2,imageViewNumber3,
                        imageViewNumber4,imageViewNumber5,imageViewNumber6;

    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
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
       View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageViewNumber1 = view.findViewById(R.id.imageViewNumber1);
        imageViewNumber2 = view.findViewById(R.id.imageViewNumber2);
        imageViewNumber3 = view.findViewById(R.id.imageViewNumber3);
        imageViewNumber4 = view.findViewById(R.id.imageViewNumber4);
        imageViewNumber5 = view.findViewById(R.id.imageViewNumber5);
        imageViewNumber6 = view.findViewById(R.id.imageViewNumber6);

        imageViewNumber1.setOnClickListener(this);
        imageViewNumber2.setOnClickListener(this);
        imageViewNumber3.setOnClickListener(this);
        imageViewNumber4.setOnClickListener(this);
        imageViewNumber5.setOnClickListener(this);
        imageViewNumber6.setOnClickListener(this);
       return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.imageViewNumber1:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audio1);
                tocarSom();
                break;

            case R.id.imageViewNumber2:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audio2);
                tocarSom();
                break;

            case R.id.imageViewNumber3:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.audio3);
                tocarSom();
                break;

            case R.id.imageViewNumber4:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.audio4);
                tocarSom();
                break;

            case R.id.imageViewNumber5:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.audio5);
                tocarSom();
                break;

            case R.id.imageViewNumber6:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.audio6);
                tocarSom();
                break;


        }

    }
    public void tocarSom(){

        if (mediaPlayer != null){

            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });

        }

    }
    //limpando dados da memória
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}