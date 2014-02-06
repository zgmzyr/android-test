package com.example.a_4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class HandlerActivity2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler2);
		// ��ӡ�˵�ǰ�̵߳�IDq
		System.out.println("Activity-->" + Thread.currentThread().getId());
		// ����һ��HandlerThread����ʵ����ʹ��Looper��������Ϣ���еĹ��ܣ��������AndroidӦ�ó������ṩ
		HandlerThread handlerThread = new HandlerThread("handler_thread");
		// ��ʹ��HandlerThread��getLooper()����֮ǰ�������ȵ��ø����start();
		handlerThread.start();
		MyHandler myHandler = new MyHandler(handlerThread.getLooper());
		Message msg = myHandler.obtainMessage();
		// ��msg���͵�Ŀ�������ν��Ŀ����󣬾������ɸ�msg�����handler����
		Bundle b = new Bundle();
		b.putInt("age", 20);
		b.putString("name", "Jhon");
		msg.setData(b);
		msg.sendToTarget();
	}

	class MyHandler extends Handler {
		public MyHandler() {

		}

		public MyHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			Bundle b = msg.getData();
			int age = b.getInt("age");
			String name = b.getString("name");
			System.out.println("age is " + age + ", name is" + name);
			System.out.println("Handler--->" + Thread.currentThread().getId());
			System.out.println("handlerMessage");
		}
	}
}
