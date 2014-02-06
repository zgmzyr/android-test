package com.example.a_4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class RadioActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_radio);
		
		RadioGroup radioGroup = (RadioGroup) super.findViewById(R.id.sex);
		radioGroup.setOnCheckedChangeListener(new RadioGroupListener());
		
		RadioButton maleRadioButton = (RadioButton) super.findViewById(R.id.male);
		RadioButton femaleRadioButton = (RadioButton) super.findViewById(R.id.female);
		RadioButtonListener radioButtonListener = new RadioButtonListener();
		maleRadioButton.setOnCheckedChangeListener(radioButtonListener);
		femaleRadioButton.setOnCheckedChangeListener(radioButtonListener);
	}
	
	
	private static class RadioGroupListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
			CompoundButton compoundButton = (CompoundButton) radioGroup.findViewById(checkedId);
			if (compoundButton.isChecked()) {
				System.out.println(compoundButton.getText() + " 被选中了---1");
			} else {
				System.out.println(compoundButton.getText() + " 被取消了---1");
			}
		}
	}
	
	private static class RadioButtonListener implements android.widget.CompoundButton.OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
			if (checked) {
				System.out.println(compoundButton.getText() + " 被选中了---2");
			} else {
				System.out.println(compoundButton.getText() + " 取消了---2");
			}
			
		}
	}

}
