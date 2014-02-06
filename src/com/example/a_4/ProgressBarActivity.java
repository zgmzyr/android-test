package com.example.a_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ProgressBarActivity extends Activity {
	private ProgressBar progressBarHorizontal;
	private Button firstButton;
	private Button secondButton;
	
	private SeekBar seekBar;
	
	private RatingBar ratingBar;
	private Button ratingButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_bar);

		progressBarHorizontal = (ProgressBar) findViewById(R.id.progressBarHorizontal);
		firstButton = (Button) findViewById(R.id.firstButton);
		secondButton = (Button) findViewById(R.id.secondButton);
		progressBarHorizontal.setMax(100);
		firstButton.setOnClickListener(new FirstListener());
		secondButton.setOnClickListener(new SecondListener());
		
		
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		seekBar.setProgress(30);
		seekBar.setSecondaryProgress(50);
		SeekBarListener listener = new SeekBarListener();
		seekBar.setOnSeekBarChangeListener(listener);
		
		
		ratingBar = (RatingBar)findViewById(R.id.ratingBar);
		ratingButton = (Button)findViewById(R.id.button);
		
		RatingBarListener ratingBarListener = new RatingBarListener();
		ratingBar.setOnRatingBarChangeListener(ratingBarListener);
		
		ButtonListener buttonListener = new ButtonListener();
		ratingButton.setOnClickListener(buttonListener);

	}

	class FirstListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			progressBarHorizontal.incrementProgressBy(10);
		}

	}

	class SecondListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			progressBarHorizontal.incrementSecondaryProgressBy(20);
		}

	}
	
	class SeekBarListener implements OnSeekBarChangeListener{

		/**
		 * seekBar 该对象指的是触发了监听器的SeekBar对象
		 * progress 指的是当前SeekBar的进度
		 * fromUser 
		 */
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			System.out.println("progress:" + progress + ",fromUser:" + fromUser);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			System.out.println("onStart");
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			System.out.println("onStop");
		}
		
	}
	
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			ratingBar.setRating(ratingBar.getRating() + 1.0f);
		}
		
	}
	
	class RatingBarListener implements OnRatingBarChangeListener{

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
			System.out.println("rating:" + rating + ",fromUser:" + fromUser);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
