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
			System.out.println("Handler 所处线程是：" + Thread.currentThread().getName());
//			updateBarHandler.post(updateBarTask);
			
		}

	};
	
	private Handler updateBarHandler = new UpdateBarHandler();
	*/
	//TODO 警告：可能发生内存泄漏
	private Handler updateBarHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			progressBar.setProgress(msg.arg1);

			Bundle bundle = msg.getData();
			System.out.println("test---->" + bundle.getString("test"));
			System.out.println("Handler 所处线程是：" + Thread.currentThread().getName());
			updateBarHandler.post(updateBarTask);
		}

	};
	
	private Runnable updateBarTask = new Runnable() {
		int i = 0;

		@Override
		public void run() {
			System.out.println("Handler处理的任务 所处线程是：" + Thread.currentThread().getName());
//			System.out.println("Begin Thread" + i);
			i = i + 10;
			// 得到一个消息对象，Message类是有Android操作系统提供
			Message msg = updateBarHandler.obtainMessage();

			// 将msg对象的arg1参数的值设置为i,用arg1和arg2这两个成员变量传递消息，优点是系统性能消耗较少
			msg.arg1 = i;
			Bundle bundle = new Bundle();
			bundle.putString("test", "test bundle");
			msg.setData(bundle);
			try {
				// 设置当前显示睡眠1秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 将msg对象加入到消息队列当中
			if (i > 100) {
				// 如果当i的值为100时，就将线程对象从handler当中移除
				updateBarHandler.removeCallbacks(updateBarTask);
				System.out.println(">>>>>>");
			} else {
				updateBarHandler.sendMessage(msg);
				System.out.println("<<<<<<");
			}
		}
	};

}
