package com.example.verticalrangeseekbar;

public interface CallbackListener {

    void getProgressValues(String minValue,String maxValue);
    int getStartHour();
    int getEndHour();
    int getStartMinutes();
    int getEndMinutes();
    String getDate();
}