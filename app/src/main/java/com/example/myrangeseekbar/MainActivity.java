package com.example.myrangeseekbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;
import com.jaygoo.widget.SeekBar;
import com.jaygoo.widget.Utils;
import com.jaygoo.widget.VerticalRangeSeekBar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    VerticalRangeSeekBar timeRange;
    int value1= 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeRange = findViewById(R.id.timeRange);
        timeRange.setIndicatorTextDecimalFormat("0.00 am");

        timeRange.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {

                DecimalFormat df = new DecimalFormat("0.00");
                String lValue = df.format(leftValue);
                String rValue = df.format(rightValue);
                String[] convertLeftValue = lValue.split("\\.");
                String[] convertRightValue = rValue.split("\\.");

                try {
                    value1=Integer.parseInt(convertLeftValue[0]);
                    value2=Integer.parseInt(convertLeftValue[1]);
                    value3=Integer.parseInt(convertRightValue[0]);
                    value4=Integer.parseInt(convertRightValue[1]);
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
                changeSeekbarIndicator(timeRange.getLeftSeekBar(),value1,value2);
                changeSeekbarIndicator(timeRange.getRightSeekBar(),value3,value4);

            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });

    }

    public void changeSeekbarIndicator(SeekBar seekBar,float v1,float v2) {
        seekBar.showIndicator(true);
        String period;
        if (v1 >= 12 && v1 < 24){
            v1 = v1 - 12;
            if (v1 == 0){
                v1 = 12;
                period = "am";
            }else {
                period = "am";
            }
        }else{
            v1 = v1 - 24;
            if (v1 == 0){
                v1 = 12;
                period = "pm";
            }else {
                period = "pm";
            }
        }

        if (v2 > 0 && v2 < 8) {
            seekBar.setIndicatorText(Math.round(v1)+":00 "+ period);
        } else if (v2 > 8 && v2 < 16) {
            seekBar.setIndicatorText(Math.round(v1)+":05 "+ period);
        } else if (v2 > 16 && v2 < 24) {
            seekBar.setIndicatorText(Math.round(v1)+":10 "+ period);
        } else if (v2 > 24 && v2 < 32) {
            seekBar.setIndicatorText(Math.round(v1)+":15 "+ period);
        } else if (v2 > 32 && v2 < 40) {
            seekBar.setIndicatorText(Math.round(v1)+":20 "+ period);
        } else if (v2 > 40 && v2 < 48) {
            seekBar.setIndicatorText(Math.round(v1)+":25 "+ period);
        } else if (v2 > 48 && v2 < 56) {
            seekBar.setIndicatorText(Math.round(v1)+":30 "+ period);
        } else if (v2 > 56 && v2 < 64) {
            seekBar.setIndicatorText(Math.round(v1)+":35 "+ period);
        } else if (v2 > 64 && v2 < 73) {
            seekBar.setIndicatorText(Math.round(v1)+":40 "+ period);
        } else if (v2 > 73 && v2 < 82) {
            seekBar.setIndicatorText(Math.round(v1)+":45 "+ period);
        } else if (v2 > 82 && v2 < 91) {
            seekBar.setIndicatorText(Math.round(v1)+":50 "+ period);
        } else if (v2 > 91 && v2 < 100) {
            seekBar.setIndicatorText(Math.round(v1)+":55 "+ period);
        }else{
            seekBar.showIndicator(true);
        }
    }

}
