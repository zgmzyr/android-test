package com.example.a_4.broadcast._2_code;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("receive message");
		
		//����Intent�����е�����
		Bundle bundle = intent.getExtras();
		//��Bundle��������һ��������Ϊpdus��������Ե�ֵ��һ��Object����
		Object[] myOBJpdus = (Object[]) bundle.get("pdus"); 
		//����һ��SmsMessage���͵�����
        SmsMessage[] messages = new SmsMessage[myOBJpdus.length];  
        System.out.println(messages.length);
        for (int i = 0; i<myOBJpdus.length; i++) 
        {  
          //ʹ��Object���鵱�еĶ��󴴽�SmsMessage����
          messages[i] = SmsMessage.createFromPdu((byte[]) myOBJpdus[i]);  
          //����SmsMessage�����getDisppalyMessageBody()�������Ϳ��Եõ���Ϣ������
          System.out.println(messages[i].getDisplayMessageBody());
        }
        try {
			Thread.sleep(30 * 1000);
			System.out.println("-------------------------------");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
