package com.example.a_4;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.a_4.utils.HttpDownloader;
import com.example.a_4.xml.MyContentHandler;

public class XMLActitity extends Activity {
	private Button parseButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xml);
		parseButton = (Button) findViewById(R.id.parseButton);
		parseButton.setOnClickListener(new ParseButtonListener());
	}

	class ParseButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			HttpDownloader hd = new HttpDownloader();
			//FIXME 暂时硬编码
			String resultStr = hd
					.download("http://192.168.1.107:8081/voa1500/test.xml");
			System.out.println(resultStr);
			try {
				// 创建一个SAXParserFactory
				SAXParserFactory factory = SAXParserFactory.newInstance();
				XMLReader reader = factory.newSAXParser().getXMLReader();
				// 为XMLReader设置内容处理器
				reader.setContentHandler(new MyContentHandler());
				// 开始解析文件
				reader.parse(new InputSource(new StringReader(resultStr)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
