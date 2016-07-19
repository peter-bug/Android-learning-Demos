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
	 * 避免重复
	 * false 代表没有启动
	 * true 代表已启动
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
     * 触摸事件
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
