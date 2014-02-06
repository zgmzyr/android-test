package com.example.a_4.broadcast._2_code;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.a_4.R;

public class BroadcastActivity extends Activity {
	private Button registerButton = null;
	private Button unregisterButton = null;
	private SMSReceiver smsReceiver = null;

	private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast_2_code);
		registerButton = (Button) findViewById(R.id.register);
		registerButton.setOnClickListener(new RegisterReceiverListener());
		unregisterButton = (Button) findViewById(R.id.unregister);
		unregisterButton.setOnClickListener(new UnRegisterReceiverListener());
	}

	class RegisterReceiverListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// ����һ��BroiadcastReceiver����
			smsReceiver = new SMSReceiver();
			// ����һ��IntentFilter����
			IntentFilter filter = new IntentFilter();
			// ΪIntentFilter���һ��Action
			filter.addAction(SMS_ACTION);
			// ��BroadcastReceiver����ע�ᵽϵͳ����
			BroadcastActivity.this.registerReceiver(smsReceiver, filter);
		}

	}

	class UnRegisterReceiverListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// ���BroadcastReceiver�����ע��
			BroadcastActivity.this.unregisterReceiver(smsReceiver);
		}

	}
}
