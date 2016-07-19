package com.example.videodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				 startVideoList();
			}
		}, 5000);
//		startVideoList();
	}
	/**
	 * �����ظ�
	 * false ����û������
	 * true ����������
	 */
	private boolean isstartVideoList = false;
    public void startVideoList(){
    	if(!isstartVideoList){
    		isstartVideoList=true;
	    	Intent intent = new Intent();
	    	intent.setClass(WelcomeActivity.this, VideoListActivity.class);
	    	startActivity(intent);
	    	finish();
    	}
    	
    }
    /*
     * �����¼�
     * 
     *      
     *      */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	startVideoList();
    	return super.onTouchEvent(event);
    }
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
