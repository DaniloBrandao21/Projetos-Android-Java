package brandao.android.a01_componentes_toastnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        , AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.buttonToast = findViewById(R.id.buttonToast);
        this.mViewHolder.buttonSnack = findViewById(R.id.buttonSnack);

        this.mViewHolder.linearRoot = findViewById(R.id.linearRoot);
        this.mViewHolder.spinnerDynamic = findViewById(R.id.spinnerDynimic);

        this.mViewHolder.buttonGetSpinner = findViewById(R.id.buttonGetSpinner);
        this.mViewHolder.buttonSetSpinner = findViewById(R.id.buttonSetSpinner);

        this.mViewHolder.buttonSetSeek = findViewById(R.id.buttonSetSeek);
        this.mViewHolder.buttonGetSeek = findViewById(R.id.buttonGetSeek);
        this.mViewHolder.textSeekBarValue = findViewById(R.id.textSeekBarValue);
        this.mViewHolder.seekBar = findViewById(R.id.seekBar);

        this.mViewHolder.switchOnOff = findViewById(R.id.switchOnOff);


        this.mViewHolder.checkBoxOnOff = findViewById(R.id.checkOnOff);

        this.mViewHolder.radioYes = findViewById(R.id.radioYes);
        this.mViewHolder.radioNo = findViewById(R.id.radioNo);


        //carregando o spinner
        this.loadSpinner();

        //Eventos
        this.setListeners();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.buttonToast){
            //Toast
            Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_LONG);

            //toast.setGravity(Gravity.TOP, 0, 200);
            toast.show();
        }else if(id == R.id.buttonSnack){

            //SnackBar
            Snackbar snackbar = Snackbar.make(this.mViewHolder.linearRoot, "Snack", Snackbar.LENGTH_LONG);

            snackbar.setAction("Desfazer", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(mViewHolder.linearRoot, "Desfeito", Snackbar.LENGTH_LONG).show();
                }
            });

            snackbar.setBackgroundTint(Color.GREEN);
            snackbar.setActionTextColor(Color.BLACK);
            snackbar.show();
        }
        else if(id == R.id.buttonGetSpinner){
          String selecte = this.mViewHolder.spinnerDynamic.getSelectedItem().toString();
          int position = this.mViewHolder.spinnerDynamic.getSelectedItemPosition();
          long itemId =this.mViewHolder.spinnerDynamic.getSelectedItemId();




        }
        else if(id == R.id.buttonSetSpinner){

            this.mViewHolder.spinnerDynamic.setSelection(0);
        }
        else if(id == R.id.buttonSetSeek){

            this.mViewHolder.seekBar.setProgress(12);

        }
        else if(id == R.id.buttonGetSeek){

            int progress = this.mViewHolder.seekBar.getProgress();

        }



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String s = adapterView.getItemAtPosition(i). toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        this.mViewHolder.textSeekBarValue.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        toast("Start tracking");

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        toast("Stop tracking");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.getId() == R.id.switchOnOff){
            this.mViewHolder.switchOnOff.isChecked();
            this.mViewHolder.switchOnOff.setChecked(false);
        } else if(compoundButton.getId() == R.id.checkOnOff){

            this.mViewHolder.checkBoxOnOff.isChecked();
            this.mViewHolder.checkBoxOnOff.setChecked(false);

        } else if(compoundButton.getId() == R.id.radioYes){

            this.mViewHolder.radioYes.isChecked();
            this.mViewHolder.radioYes.setChecked(false);

        } else if(compoundButton.getId() == R.id.radioNo){

            this.mViewHolder.radioNo.isChecked();
            this.mViewHolder.radioNo.setChecked(false);
        }
    }

    private void toast(String str){

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }


    private void loadSpinner(){
        //lista
        List<String> lst = Arrays.asList("Euro", "Real", "Dólar", "Libra");

        //adapter
        SpinnerAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lst);

        //elemento
        this.mViewHolder.spinnerDynamic.setAdapter(adapter);
    }

    private void setListeners(){
        this.mViewHolder.buttonToast.setOnClickListener(this);
        this.mViewHolder.buttonSnack.setOnClickListener(this);
        this.mViewHolder.buttonGetSpinner.setOnClickListener(this);
        this.mViewHolder.buttonSetSpinner.setOnClickListener(this);

        this.mViewHolder.spinnerDynamic.setOnItemSelectedListener(this);


        this.mViewHolder.buttonGetSeek.setOnClickListener(this);
        this.mViewHolder.buttonSetSeek.setOnClickListener(this);

        this.mViewHolder.seekBar.setOnSeekBarChangeListener(this);

        this.mViewHolder.switchOnOff.setOnCheckedChangeListener(this);

        this.mViewHolder.checkBoxOnOff.setOnCheckedChangeListener(this);

        this.mViewHolder.radioYes.setOnCheckedChangeListener(this);
        this.mViewHolder.radioNo.setOnCheckedChangeListener(this);
    }




    private static class ViewHolder{

        Button buttonToast;
        Button buttonSnack;
        LinearLayout linearRoot;
        Spinner spinnerDynamic;
        Button buttonGetSpinner;
        Button buttonSetSpinner;
        Button buttonGetSeek;
        Button buttonSetSeek;
        TextView textSeekBarValue;
        SeekBar seekBar;
        Switch switchOnOff ;
        CheckBox checkBoxOnOff;
        RadioButton radioYes;
        RadioButton radioNo;

    }
}