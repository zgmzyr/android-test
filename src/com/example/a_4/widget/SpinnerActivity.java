package com.example.a_4.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.a_4.R;

public class SpinnerActivity extends Activity {

	// ����Spinner����
	private Spinner spinner = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		// ͨ��ID���õ�Spinner����
		spinner = (Spinner) findViewById(R.id.spinnerId);
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		// ����ArrayAdapter�Ĺ��캯��������ArrayAdapter����
		// ��һ��������ָ�����Ķ���
		// �ڶ�������ָ���������˵�����ÿһ����Ŀ����ʽ
		// ����������ָ����TextView�ؼ���ID
		// ���ĸ�����Ϊ�����б��ṩ����
		ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item, R.id.textViewId, list);
		// ͨ��createFromResource��������һ��ArrayAdapter����
		// ��һ��������ָ�����Ķ���
		// �ڶ�������������strings.xml�ļ����ж����String����
		// ����������������ָ��Spinner����ʽ����һ�������ļ�ID���ò����ļ���Androidϵͳ�ṩ��Ҳ���滻Ϊ�Լ�����Ĳ����ļ�
		/*
		 * ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.planets_array,
		 * android.R.layout.simple_spinner_item);
		 */// ����Spinner����ÿ����Ŀ����ʽ��ͬ��������һ��Androidϵͳ�ṩ�Ĳ����ļ�
			// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);
		spinner.setPrompt("����");
		// Ϊspinner����󶨼�����
		spinner.setOnItemSelectedListener(new SpinnerOnSelectedListener());
	}

	// �����������Ҫ���������û�ѡ���б�Ķ���
	class SpinnerOnSelectedListener implements OnItemSelectedListener {

		// ���û�ѡ����һ����Ŀʱ���ͻ���ø÷���
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
			String selected = adapterView.getItemAtPosition(position).toString();
			System.out.println(selected);
		}

		@Override
		public void onNothingSelected(AdapterView<?> adapterView) {
			// TODO Auto-generated method stub
			System.out.println("nothingSelected");
		}

	}

}
