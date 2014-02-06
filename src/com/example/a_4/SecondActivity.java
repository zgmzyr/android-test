package com.example.a_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SecondActivity extends Activity {
	private CheckBox eatCheckBox;
	private CheckBox sleepCheckBox;
	private CheckBox playCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//TODO
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_second);
		
		eatCheckBox = (CheckBox) super.findViewById(R.id.eatId);
		sleepCheckBox = (CheckBox) super.findViewById(R.id.sleepId);
		playCheckBox = (CheckBox) super.findViewById(R.id.playId);
		
		CheckBoxOnClickListener checkBoxOnClickListener = new CheckBoxOnClickListener();
		eatCheckBox.setOnClickListener(checkBoxOnClickListener);
		sleepCheckBox.setOnClickListener(checkBoxOnClickListener);
		playCheckBox.setOnClickListener(checkBoxOnClickListener);
		
		CheckBoxOnCheckedChangeListener checkBoxOnCheckedChangeListener = new CheckBoxOnCheckedChangeListener();
		eatCheckBox.setOnCheckedChangeListener(checkBoxOnCheckedChangeListener);
		sleepCheckBox.setOnCheckedChangeListener(checkBoxOnCheckedChangeListener);
		playCheckBox.setOnCheckedChangeListener(checkBoxOnCheckedChangeListener);
	}
	
	private static class CheckBoxOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			CompoundButton compoundButton = (CompoundButton) v;
			if (v.getId() == R.id.eatId) {
				if (compoundButton.isChecked()) {
					System.out.println("ѡ�гԷ��ˣ�");
				} else {
					System.out.println("ȡ���Է��ˣ�");
				}
			} else if (v.getId() == R.id.sleepId) {
				if (compoundButton.isChecked()) {
					System.out.println("ѡ��˯���ˣ�");
				} else {
					System.out.println("ȡ��˯���ˣ�");
				}
			} else if (v.getId() == R.id.playId) {
				if (compoundButton.isChecked()) {
					System.out.println("ѡ���棡");
				} else {
					System.out.println("ȡ���棡");
				}
			}
		}
	}
	
	private static class CheckBoxOnCheckedChangeListener implements OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (isChecked) {
				System.out.println(buttonView.getText() + " ��ѡ����");
			} else {
				System.out.println(buttonView.getText() + " ȡ��ѡ����");
			}
		}
		
	}

}
