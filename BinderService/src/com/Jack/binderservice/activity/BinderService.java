/**
 * ��Ŀ����BinderService
 * ������com.Jack.binderservice.activity
 * �ļ�����BinderService.java
 * ���ڣ�2015-8-20-����10:00:31
 * Copyright (c) 2015�����-��Ȩ����
 */
package com.Jack.binderservice.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @author larry
 *
 */
public class BinderService extends Service {

	private static final String TAG = "BinderService";
	private MyBinder binder=new MyBinder();
	
	class MyBinder extends Binder{
		public BinderService getService(){
			
			return BinderService.this;
		}
	}
	
	public IBinder onBind(Intent intent) {
		
		return binder;
	}
    public void MyMethod(){
    	Log.i(TAG, "MyMethod");
    }
}
