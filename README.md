# Vertical Time Range Picker

Vertical time Range picker is a unique Time picker with Date Picker.

## Android UI

Date Picker

#Date Picker Xml
'''
<DatePicker
            android:id="@+id/datePicker"
            android:layout_gravity="center"
            android:layout_marginTop="42dp"
            android:headerBackground="@color/colorBlue"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:scaleX="1.2"
            android:scaleY="1.2"
            android:layout_marginBottom="20dp"
            android:datePickerMode="calendar" />
'''
        
<img src='images/Capture.PNG' height=480 width=300 />

Time Range Pciker

#Time Range Picker Xml
'''
<com.example.verticalrangeseekbar.widget.VerticalRangeSeekBar
            android:id="@+id/timeRange"
            android:layout_width="380dp"
            android:layout_height="match_parent"
            android:paddingLeft="3dp"
            android:paddingRight="1dp"
            android:layout_marginBottom="30dp"
            app:rsb_indicator_background_color="#fff"
            app:rsb_indicator_height="60dp"
            app:rsb_indicator_padding_bottom="8dp"
            app:rsb_indicator_padding_left="8dp"
            app:rsb_indicator_padding_right="8dp"
            app:rsb_indicator_padding_top="8dp"
            app:rsb_indicator_show_mode="alwaysShowAfterTouch"
            app:rsb_indicator_text_color="@color/colorAccent"
            app:rsb_indicator_text_size="14sp"
            app:rsb_indicator_width="wrap_content"
            app:rsb_max="36.01"
            app:rsb_min="12"
            app:rsb_mode="range"
            app:rsb_orientation="right"
            app:rsb_progress_drawable="@drawable/foreground"
            app:rsb_progress_drawable_default="@drawable/background"
            app:rsb_progress_height="380dp"
            app:rsb_step_auto_bonding="false"
            app:rsb_step_color="#fff"
            app:rsb_step_height="380dp"
            app:rsb_step_width="0.7dp"
            app:rsb_steps="24"
            app:rsb_thumb_width="0dp"
            app:rsb_tick_mark_mode="other"
            app:rsb_tick_mark_number="24"
            app:rsb_tick_mark_text_array="@array/markArray"
            app:rsb_tick_mark_text_color="#000"
            app:rsb_tick_mark_text_margin="10dp"
            app:rsb_tick_mark_text_size="8sp" />
 '''           
<img src='images/Capture1.PNG' height=480 width=300 />


## Usage

The following snippet shows how you can use Vertical Time Range Picker in your project.
