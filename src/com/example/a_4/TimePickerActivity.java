package com.example.a_4;

import org.apache.http.impl.cookie.DateParseException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class TimePickerActivity extends Activity {
	private TimePicker timePicker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		super.setContentView(R.layout.time_picker);
		
		DatePicker datePicker = (DatePicker) super.findViewById(R.id.datePicker);
		datePicker.updateDate(2013, 11, 15);
		
		this.timePicker = (TimePicker) super.findViewById(R.id.timePicker);
		this.timePicker.setIs24HourView(true);
		Button button = (Button) super.findViewById(R.id.timeButton);
		button.setOnClickListener(new ButtonListener());
	}
	
	
	private static class TimeListener implements OnTimeChangedListener {

		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			System.out.println("小时：" + hourOfDay + "; 分：" + minute);
		}
		
	}
	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			System.out.println("当前时间是：" + TimePickerActivity.this.timePicker.getDrawingTime());
		}
	}
}
