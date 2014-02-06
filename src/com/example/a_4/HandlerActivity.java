package com.example.a_4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerActivity extends Activity {

	private ProgressBar progressBar;
	private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		super.setContentView(R.layout.handler);
		progressBar = (ProgressBar) super
				.findViewById(R.id.progressBarForHandler);
		startButton = (Button) super.findViewById(R.id.startButtonForHandler);
		startButton.setOnClickListener(new ButtonListener());
	}

	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			progressBar.setVisibility(View.VISIBLE);
			updateBarHandler.post(updateBarTask);
		}
	}

	/*
	private static class UpdateBarHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
//			progressBar.setProgress(msg.arg1);

			Bundle bundle = msg.getData();
			System.out.println("test---->" + bundle.getString("test"));
			System.out.println("Handler �����߳��ǣ�" + Thread.currentThread().getName());
//			updateBarHandler.post(updateBarTask);
			
		}

	};
	
	private Handler updateBarHandler = new UpdateBarHandler();
	*/
	//TODO ���棺���ܷ����ڴ�й©
	private Handler updateBarHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			progressBar.setProgress(msg.arg1);

			Bundle bundle = msg.getData();
			System.out.println("test---->" + bundle.getString("test"));
			System.out.println("Handler �����߳��ǣ�" + Thread.currentThread().getName());
			updateBarHandler.post(updateBarTask);
		}

	};
	
	private Runnable updateBarTask = new Runnable() {
		int i = 0;

		@Override
		public void run() {
			System.out.println("Handler��������� �����߳��ǣ�" + Thread.currentThread().getName());
//			System.out.println("Begin Thread" + i);
			i = i + 10;
			// �õ�һ����Ϣ����Message������Android����ϵͳ�ṩ
			Message msg = updateBarHandler.obtainMessage();

			// ��msg�����arg1������ֵ����Ϊi,��arg1��arg2��������Ա����������Ϣ���ŵ���ϵͳ�������Ľ���
			msg.arg1 = i;
			Bundle bundle = new Bundle();
			bundle.putString("test", "test bundle");
			msg.setData(bundle);
			try {
				// ���õ�ǰ��ʾ˯��1��
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ��msg������뵽��Ϣ���е���
			if (i > 100) {
				// �����i��ֵΪ100ʱ���ͽ��̶߳����handler�����Ƴ�
				updateBarHandler.removeCallbacks(updateBarTask);
				System.out.println(">>>>>>");
			} else {
				updateBarHandler.sendMessage(msg);
				System.out.println("<<<<<<");
			}
		}
	};

}
