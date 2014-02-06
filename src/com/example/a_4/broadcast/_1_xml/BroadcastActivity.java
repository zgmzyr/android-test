package com.example.a_4.broadcast._1_xml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.a_4.R;

public class BroadcastActivity extends Activity {
	private Button sendButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_1_xml);
		sendButton = (Button) findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new BroadcastListener());
	}

	class BroadcastListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_EDIT);
			BroadcastActivity.this.sendBroadcast(intent);
		}

	}
}
