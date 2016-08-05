/**
 * 项目名：BinderService
 * 包名：com.Jack.binderservice.activity
 * 文件名：BinderService.java
 * 日期：2015-8-20-上午10:00:31
 * Copyright (c) 2015陈培达-版权所有
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
