package brandao.android.a01_componentes_toastnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener
        , TimePickerDialog.OnTimeSetListener{

    ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       // this.showDatePicker();
        this.showTimePicker();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {


    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }

    private void showDatePicker(){

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, this, year, month, dayOfMonth ).show();
    };
    private void showTimePicker(){

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
       new TimePickerDialog(this, this, hour, minute, true).show();
    };



    private static class ViewHolder{
        
    }
}