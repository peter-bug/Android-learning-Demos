package com.Jack.binderservice.activity;

import com.Jack.binderservice.activity.BinderService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BinderActivity extends Activity {
	   
	private Button binderbtn1;
	private Button binderbtn2;
	
	private Boolean isConnected=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_binder);
		
		binderbtn1=(Button)findViewById(R.id.binderbtn1);
		binderbtn2=(Button)findViewById(R.id.binderbtn2);
		
		binderbtn1.setOnClickListener(listener);
		binderbtn2.setOnClickListener(listener);
		
	}
    
	private OnClickListener listener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button=(Button)v;
			switch(button.getId()){
			case R.id.binderbtn1:
				onbind();
				break;
			case R.id.binderbtn2:
				unbind();
				break;
	   		}
		}
     };
        private void unbind() {
			if(isConnected){
			   unbindService(conn);
			}
		}

		private void onbind() {
			Intent intent=new Intent(BinderActivity.this,BinderService.class);
			bindService(intent,conn,Context.BIND_AUTO_CREATE);
			
		}
		private ServiceConnection conn=new ServiceConnection(){

			@Override
			public void onServiceConnected(ComponentName name, IBinder binder) {
				MyBinder mybinder=(MyBinder)binder;
				BinderService service=mybinder.getService();
				service.MyMethod();
				isConnected=true;
				
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
			
				isConnected=false;
			}
			
			
		};


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
   
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
