package com.example.myrangeseekbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import com.example.verticalrangeseekbar.VerticalTimeRangePicker;
import com.example.verticalrangeseekbar.widget.OnRangeChangedListener;
import com.example.verticalrangeseekbar.widget.RangeSeekBar;
import com.example.verticalrangeseekbar.widget.VerticalRangeSeekBar;


public class MainActivity extends AppCompatActivity{
    VerticalRangeSeekBar timeRange;
    DatePicker datePicker;
    VerticalTimeRangePicker verticalTimeRangePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeRange = findViewById(R.id.timeRange);
        datePicker = findViewById(R.id.datePicker);


        verticalTimeRangePicker = new VerticalTimeRangePicker(timeRange, datePicker, MainActivity.this);

        verticalTimeRangePicker.timeRangeInit(timeRange);
        verticalTimeRangePicker.datePickerInit(datePicker);
        verticalTimeRangePicker.dateChanged();

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

}
