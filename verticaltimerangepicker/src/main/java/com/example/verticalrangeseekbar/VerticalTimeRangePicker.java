package com.example.verticalrangeseekbar;

import android.content.Context;
import android.os.Build;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.verticalrangeseekbar.widget.SeekBar;
import com.example.verticalrangeseekbar.widget.VerticalRangeSeekBar;

import java.text.DecimalFormat;

public class VerticalTimeRangePicker implements CallbackListener {

    private VerticalRangeSeekBar timeRange;
    private DatePicker datePicker;
    private int value1= 0;
    private int value2 = 0;
    private int value3 = 0;
    private int value4 = 0;
    private String startHour = "0:0";
    private String endHour = "0:0";
    private String startMin = "0:0";
    private String endMin = "0:0";

    private int day, month, year;
    private String date="";
    private Context context;

    public VerticalTimeRangePicker(VerticalRangeSeekBar timeRange, DatePicker datePicker, Context context) {
        this.timeRange = timeRange;
        this.datePicker = datePicker;
        this.context = context;
    }


    public void timeRangeInit( VerticalRangeSeekBar verticalRangeSeekBar){
        verticalRangeSeekBar.setIndicatorTextDecimalFormat("0.00 am");
        verticalRangeSeekBar.setProgress(12,12);
    }

    public void datePickerInit( DatePicker datePicker){
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth() + 1;
        year = datePicker.getYear();

        String currentDate = (day + "/" + month + "/" + year);
        date = currentDate;
        getDate();
    }

    public void onRangeChangedValue(float leftValue, float rightValue){
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
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
        }
        String minValue = changeSeekBarIndicator(timeRange.getLeftSeekBar(),value1,value2);

        String maxValue = changeSeekBarIndicator(timeRange.getRightSeekBar(),value3,value4);
        getProgressValues(minValue,maxValue);
        startHour = minValue;
        endHour = maxValue;
        startMin = minValue;
        endMin = maxValue;
    }

    private String changeSeekBarIndicator(SeekBar seekBar, float v1, float v2) {
        seekBar.showIndicator(true);
        String period;
        String value ="";
        int actualValue;
        if (v1 >= 12 && v1 < 24){
            v1 = v1 - 12;
            actualValue = (int) v1;
            if (v1 == 0){
                v1 = 12;
                actualValue = 0;
                period = "am";
            }else {
                period = "am";
            }
        }else{
            v1 = v1 - 24;
            actualValue = (int) v1+12;
            if (v1 == 0){
                v1 = 12;
                period = "pm";
            }else {
                period = "pm";
            }
        }

        if (v2 > 0 && v2 <= 8) {
            seekBar.setIndicatorText(Math.round(v1)+":00 "+ period);
            value = Math.round(actualValue)+":00";
        } else if (v2 > 8 && v2 <= 16) {
            seekBar.setIndicatorText(Math.round(v1)+":05 "+ period);
            value = Math.round(actualValue)+":05";
        } else if (v2 > 16 && v2 <= 24) {
            seekBar.setIndicatorText(Math.round(v1)+":10 "+ period);
            value = Math.round(actualValue)+":10";
        } else if (v2 > 24 && v2 <= 32) {
            seekBar.setIndicatorText(Math.round(v1)+":15 "+ period);
            value = Math.round(actualValue)+":15";
        } else if (v2 > 32 && v2 <= 40) {
            seekBar.setIndicatorText(Math.round(v1)+":20 "+ period);
            value = Math.round(actualValue)+":20";
        } else if (v2 > 40 && v2 <= 48) {
            seekBar.setIndicatorText(Math.round(v1)+":25 "+ period);
            value = Math.round(actualValue)+":25";
        } else if (v2 > 48 && v2 <= 56) {
            seekBar.setIndicatorText(Math.round(v1)+":30 "+ period);
            value = Math.round(actualValue)+":30";
        } else if (v2 > 56 && v2 <= 64) {
            seekBar.setIndicatorText(Math.round(v1)+":35 "+ period);
            value = Math.round(actualValue)+":35";
        } else if (v2 > 64 && v2 <= 73) {
            seekBar.setIndicatorText(Math.round(v1)+":40 "+ period);
            value = Math.round(actualValue)+":40";
        } else if (v2 > 73 && v2 <= 82) {
            seekBar.setIndicatorText(Math.round(v1)+":45 "+ period);
            value = Math.round(actualValue)+":45";
        } else if (v2 > 82 && v2 <= 91) {
            seekBar.setIndicatorText(Math.round(v1)+":50 "+ period);
            value = Math.round(actualValue)+":50";
        } else if (v2 > 91 && v2 <= 100) {
            seekBar.setIndicatorText(Math.round(v1)+":55 "+ period);
            value = Math.round(actualValue)+":55";
        }else{
            seekBar.showIndicator(true);
        }

        if (value.isEmpty()){
            value = "00:00";
        }
        return value;
    }

    public void dateChanged(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    date = (dayOfMonth + "/" + monthOfYear + "/" + year);
                    getDate();

                }
            });
        }
    }

    @Override
    public void getProgressValues(String minValue, String maxValue) {
        getStartHour();
        getEndHour();
        getEndMinutes();
        getStartMinutes();
        //Toast.makeText(context,getStartHour()+","+getStartMinutes()+","+getEndHour()+","+getEndMinutes(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getStartHour() {
        try {
            String[] arrOfStr = startHour.split(":");
            //Toast.makeText(context,startHour,Toast.LENGTH_SHORT).show();
            return Integer.parseInt(arrOfStr[0]);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    @Override
    public int getEndHour() {
        try {
            String[] arrOfStr = endHour.split(":");
            //Toast.makeText(context,endHour,Toast.LENGTH_SHORT).show();
            return Integer.parseInt(arrOfStr[0]);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    @Override
    public int getStartMinutes() {
        try {
            String[] arrOfStr = startMin.split(":");
            //Toast.makeText(context,startMin,Toast.LENGTH_SHORT).show();
            return Integer.parseInt(arrOfStr[1]);
        }catch (NumberFormatException e){
            return 0;
        }

    }

    @Override
    public int getEndMinutes() {

        try {
            String[] arrOfStr = endMin.split(":");
            //Toast.makeText(context,endMin,Toast.LENGTH_SHORT).show();
            return Integer.parseInt(arrOfStr[1]);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    @Override
    public String getDate() {
        //Toast.makeText(context,date,Toast.LENGTH_SHORT).show();
        return date;
    }
}
