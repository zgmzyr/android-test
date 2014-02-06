package com.example.a_4.broadcast._1_xml;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {

	public Receiver() {
		System.out.println("TestReceiver");
	}
	@Override
	public void onReceive(Context paramContext, Intent paramIntent) {
		System.out.println("onReceive");

	}

}
