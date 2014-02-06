package com.example.a_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.a_4.broadcast._1_xml.BroadcastActivity;
import com.example.a_4.widget.SpinnerActivity;
import com.example.a_4.wifi.WifiActivity;

public class ZyrActivity extends Activity {

	private TextView zyrTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zyr);
		System.out.println("втсихк");

		// this.zyrTextView = (TextView) super.findViewById(R.id.zyrTextView);

		Button myButton = (Button) super.findViewById(R.id.myButton);
		myButton.setOnClickListener(new ButtonListener());

		Button myButton2 = (Button) super.findViewById(R.id.myButton2);
		myButton2.setOnClickListener(new Button2Listener());

		Button radioActivityButton = (Button) super.findViewById(R.id.radioActivityButton);
		radioActivityButton.setOnClickListener(new RadioActivityButtonListener());

		Button imageActivityButton = (Button) super.findViewById(R.id.imageButton);
		imageActivityButton.setOnClickListener(new ImageActivityButtonListener());

		Button timeButton = (Button) super.findViewById(R.id.openTimePickerButton);
		timeButton.setOnClickListener(new TimePickerButtonListener());

		Button openProgressBarButton = (Button) super.findViewById(R.id.openProgressBarButton);
		openProgressBarButton.setOnClickListener(new ProgressBarButtonListener());

		Button openHandlerTestButton = (Button) super.findViewById(R.id.openHandlerTestButton);
		openHandlerTestButton.setOnClickListener(new HandlerTestButtonListener());

		Button openHandlerTestButton2 = (Button) super.findViewById(R.id.openHandlerTestButton2);
		openHandlerTestButton2.setOnClickListener(new HandlerTestButtonListener2());

		Button sqliteTestButton = (Button) super.findViewById(R.id.sqlitelerTestButton);
		sqliteTestButton.setOnClickListener(new SQLiteButtonListener());

		Button openDownloadButton = (Button) super.findViewById(R.id.openDownloadButton);
		openDownloadButton.setOnClickListener(new DownloadButtonListener());

		Button openXmlParseButton = (Button) super.findViewById(R.id.openXmlParseButton);
		openXmlParseButton.setOnClickListener(new XmlButtonListener());

		Button openBroadcastButton = (Button) super.findViewById(R.id.openBroadcastButton);
		openBroadcastButton.setOnClickListener(new BroadcastButtonListener());

		Button openBroadcastButton2 = (Button) super.findViewById(R.id.openBroadcastButton2);
		openBroadcastButton2.setOnClickListener(new BroadcastButtonListener2());
		
		Button openWifiButton = (Button) super.findViewById(R.id.openWifiButton);
		openWifiButton.setOnClickListener(new WifiButtonListener());
		
		Button openSpinnerButton = (Button) super.findViewById(R.id.openSpinneriButton);
		openSpinnerButton.setOnClickListener(new SpinnerButtonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			ZyrActivity.this.zyrTextView.setText(R.string.zyr_2);
		}
	}

	private class Button2Listener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, SecondActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class RadioActivityButtonListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, RadioActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class ImageActivityButtonListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, ImageActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class TimePickerButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, TimePickerActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class ProgressBarButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, ProgressBarActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class HandlerTestButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, HandlerActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class HandlerTestButtonListener2 implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, HandlerActivity2.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class SQLiteButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, SQLiteActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class DownloadButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, DownloadActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class XmlButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, XMLActitity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class BroadcastButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, BroadcastActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class BroadcastButtonListener2 implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, com.example.a_4.broadcast._2_code.BroadcastActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}

	private class WifiButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, WifiActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}
	
	private class SpinnerButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ZyrActivity.this, SpinnerActivity.class);
			ZyrActivity.this.startActivity(intent);
		}
	}
}
