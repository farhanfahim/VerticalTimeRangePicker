package com.example.myrangeseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import com.example.verticalrangeseekbar.VerticalTimeRangePicker;
import com.example.verticalrangeseekbar.widget.OnRangeChangedListener;
import com.example.verticalrangeseekbar.widget.RangeSeekBar;
import com.example.verticalrangeseekbar.widget.VerticalRangeSeekBar;


public class MainActivity extends AppCompatActivity implements CallbackListener{
    VerticalRangeSeekBar timeRange;
    DatePicker datePicker;

    int day, month, year;
    VerticalTimeRangePicker verticalTimeRangePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeRange = findViewById(R.id.timeRange);


        verticalTimeRangePicker = new VerticalTimeRangePicker(timeRange, datePicker, MainActivity.this);
        verticalTimeRangePicker.timeRangeInit(timeRange);

        datePicker = findViewById(R.id.datePicker);
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth() + 1;
        year = datePicker.getYear();

        String date = (day + "/" + month + "/" + year);
        verticalTimeRangePicker.getDate(date);


        dateChanged();

        timeRange.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {

                verticalTimeRangePicker.onRangeChangedValue(leftValue, rightValue);

            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });

    }

    public void dateChanged(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    String date = (dayOfMonth + "/" + monthOfYear + "/" + year);
                    getDate(date);
                }
            });
        }
    }
    @Override
    public String getDate(String date) {
        return date;
    }
}
