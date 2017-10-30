package jp.techacademy.kumiko.shima.aisatsuapp;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Log.d("UI_PARTS", "ボタンをタップしました");


        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            Log.d("UI_PARTS", "おはよう");
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
                            Log.d("UI_PARTS", "こんにちは");
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんにちは");
                        } else if (hourOfDay <= 1 || hourOfDay >= 18) {
                            Log.d("UI_PARTS", "こんばんは");
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんばんは");
                        }
                    }
                },
                hour,
                minute,
                true);
        dialog.show();
    }
}
