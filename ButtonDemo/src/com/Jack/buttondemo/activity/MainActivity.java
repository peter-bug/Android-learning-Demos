package com.Jack.buttondemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button btn;
    private Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//方法一
	 /*	Button btnOpen=(Button)findViewById(R.id.btn);
		btnOpen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "你点击了按钮", Toast.LENGTH_LONG).show();
				}
	   }                          );*/           //这里是); 属于内部类
		//方法二 
		/* btn=(Button)findViewById(R.id.btn);
		 btn.setOnClickListener(new ButtonClick());*/
		
		 btn=(Button)findViewById(R.id.btn);
		 btn1=(Button)findViewById(R.id.btn1);
		 btn.setOnClickListener(listener);
		 btn.setOnClickListener(listener);
	}
	private OnClickListener listener=new OnClickListener(){
     	/**
		 * 名称：onClick <br/>
		 * 描述：TODO <br/>
		 * @param v
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		*/
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 Button button=(Button)v;
			 switch(button.getId()){
			 case R.id.btn:
			     Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_LONG).show();
			     break;
			 case R.id.btn1:
				 Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_LONG).show();
			     break;
			 }
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
