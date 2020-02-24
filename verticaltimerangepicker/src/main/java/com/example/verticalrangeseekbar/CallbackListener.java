package com.example.verticalrangeseekbar;

public interface CallbackListener {

    void getProgressValues(String minValue,String maxValue);
    int getStartHour(String value);
    int getEndHour(String value);
    int getStartMinutes(String value);
    int getEndMinutes(String value);
    String getDate(String date);
}