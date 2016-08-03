package com.example.webviewtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView webView;
	//private Device device;
	//private TextView myTextView;
	//private Button myButton;
	//private TextView titleview;
	//private Title activity; 
	//private Handler handler;
	//private Message msg;
	//private Dialog myDialog;
	//private Activity activity;
	//private Handler mHandler;
	//@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//让activity全屏显示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏显示
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
		//WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		//不全屏显示
		//getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.activity_main);
		//启动网页
		init();
		//获取信息
 
	//1"DEVICE_TYPE", "DEVICE_SYSTEM_NAME", "DEVICE_VERSION", "DEVICE_SYSTEM_VERSION", "DEVICE_TOKEN",
		Log.v("第一行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TYPE));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_SYSTEM_NAME));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_VERSION));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_SYSTEM_VERSION));
		Log.v("获取信息-->\n",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOKEN));
		
		Log.v("第二行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NAME));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_UUID));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_MANUFACTURE));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.IPHONE_TYPE));
		Log.v("获取信息--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_VERSION));
		
		Log.v("第三行信息-->",DeviceInfo.getDeviceInfo(this,Device.CONTACT_ID));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_LANGUAGE));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TIME_ZONE));
		Log.v("获取信息--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_LOCAL_COUNTRY_CODE));
		
	 //"DEVICE_CURRENT_YEAR", "DEVICE_CURRENT_DATE_TIME"," DEVICE_CURRENT_DATE_TIME_ZERO_GMT",
		Log.v("第四行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_CURRENT_YEAR));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_CURRENT_DATE_TIME));
		Log.v("获取信息--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_CURRENT_DATE_TIME_ZERO_GMT));
	
	//5 "DEVICE_HARDWARE_MODEL", "DEVICE_NUMBER_OF_PROCESSORS"," DEVICE_LOCALE, DEVICE_NETWORK", "DEVICE_NETWORK_TYPE",
		Log.v("第五行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_HARDWARE_MODEL));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NUMBER_OF_PROCESSORS));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_LOCALE));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NETWORK));
		Log.v("获取信息--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NETWORK_TYPE));
		
	//6  "DEVICE_IP_ADDRESS_IPV4", "DEVICE_IP_ADDRESS_IPV6", "DEVICE_MAC_ADDRESS", "DEVICE_TOTAL_CPU_USAGE",
		//Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_IP_ADDRESS_IPV4));
		//Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_IP_ADDRESS_IPV6));
		Log.v("第六行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_MAC_ADDRESS));
		Log.v("获取信息--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_USAGE));
	
	// 7 "DEVICE_TOTAL_MEMORY", "DEVICE_FREE_MEMORY", "DEVICE_USED_MEMORY",
		Log.v("第七行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_MEMORY));
		Log.v("获取信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_FREE_MEMORY));
		Log.v("获取信息--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_USED_MEMORY));
		
	// 8 "DEVICE_TOTAL_CPU_USAGE_USER"," DEVICE_TOTAL_CPU_USAGE_SYSTEM",	
		Log.v("第八行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_USAGE_USER));
		Log.v("获取信息-->\n",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_USAGE_SYSTEM));
		
	//9  "DEVICE_TOTAL_CPU_IDLE", "DEVICE_IN_INCH"
		Log.v("第九行信息-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_IDLE));
		Log.v("获取信息-->\n\n",DeviceInfo.getDeviceInfo(this,Device.DEVICE_IN_INCH));
		
		System.out.println("获取信息完毕");
		
		
		
		 
		 
		
		
		
		
		
		
		
		
		
		//Log.d("运行了获取信息的方法-->",getInfo());
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/example.html");
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("http://baidu.com");
        //自适应手机屏幕
        /*WebSettings webSettings = webView.getSettings();       
        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);*/
        
      /*  webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new Object() {       
            public void clickOnAndroid() {       
                mHandler.post(new Runnable() {       
                    public void run() {       
                        webView.loadUrl("javascript:wave()");    
                    }       
                });       
            }       
        }, "demo"); */
        
        webView.setDownloadListener(new MyDownloadListenter());
        
        //myTextView.setText("本机号:"+phoneNumber+"\n"+"本机型号:"+phoneModel+"\n"+"本机SDK版本:"+phoneSdkVersion+"\n"+"系统版本:"+phoneReleaseVersion);
        //myButton=(Button)findViewById(R.id.mButton);
        //myButton.setOnClickListener(new myButtonOnClickListener());
	}
	
	  
	
	//加入获取信息之前，7.25.19：20
	class myButtonOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, OtherActivity.class);
			MainActivity.this.startActivity(intent);
			}
		}
	 //@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
	@SuppressLint("SetJavaScriptEnabled")
	private void init(){
		 	
	        webView = (WebView) findViewById(R.id.webView);
	        //WebView加载web资源
	       webView.loadUrl("http://baidu.com");
	       //webView.addJavascriptInterface(this, "javatojs");//绑定
	       
	       //设置webView启动属性
	       WebSettings webSettings = webView.getSettings();       
	       webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
	       webSettings.setLoadWithOverviewMode(true);
	       webSettings.setJavaScriptEnabled(true);
	       webSettings.setSupportMultipleWindows(true);
	       //优先使用缓存
	       webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
	       //checkUPPay();//检测银联支付控件是否已添加
	       //WebViewClient方法，帮助WebView处理通知，请求事件
	       webView.setWebViewClient(new WebViewClient(){
	    	   @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
	             view.loadUrl(url);
	            return true;
	        }
	    	   @Override
	    	   public void onReceivedError(WebView view, int errorCode,
	    	   	String description, String failingUrl) {
	    	   	//用javascript隐藏系统定义的404页面信息
	    	   	String data = "Page NO FOUND！请检查您的网络连接";
	    	   	view.loadUrl("javascript:document.body.innerHTML=\"" + data + "\"");
	    	   }
	   });
	      
	       //WebChromeClient方法，解析渲染网页行为，帮助WebView处理Javascript对话框，网站图标，title,加载进度
	       webView.setWebChromeClient(new WebChromeClient(){
	    	   //获取当前页面的title的方法
	    	  /*@Override
	            public void onReceivedTitle(WebView view, String title) {
	    		   titleview=(TextView)findViewById(R.id.mTextView);
	    		   titleview.setText(title);//a TextView
	            }*/
	    	   
	    	  /* public void onProgressChanged(WebView view, int newProgress)//设置 加载进程
               {
	    		   
	    		   if (newProgress == 100) {
	                    // 网页加载完成
	    			   	//titleview.setText("页面加载完成"); //这么写程序闪退
	    			   System.out.println("页面加载完成");
	                } else {
	                    // 加载中
	                	//titleview.setText("页面加载中..");
	                	System.out.println("页面加载中");
	                }
             		MainActivity.this.setTitle("正在加载..Loading...");
             		}*/
	            /*@SuppressWarnings("deprecation")
				public void onProgressChanged(WebView view, int progress)//设置 加载进程
	                             {
	            					
	                           		MainActivity.this.setTitle("正在加载..Loading...");
	                                MainActivity.this.setProgress(progress * 100);
	                                if(progress >= 100){
	                                   new Thread(new Runnable() {
	                                       @Override
	                                        public void run() {
	                                           Message msg=handler.obtainMessage();//发送通知，加入线程
	                                           msg.what=2;//加载完成
	                                           handler.sendMessage(msg);//通知发送！
	                                       }              
	                                    }).start();  
	                                     MainActivity.this.setTitle(R.string.app_name);
	                                 }
	                            }*/

	        });
	       
	  }
	//改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();//返回上一页面
                return true;
            }
            else
            {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
	/* private void checkUPPay() {
		// TODO Auto-generated method stub
		
	}*/
	//创建DownloadListener (webKit包)
     class MyDownloadListenter implements DownloadListener{
       @Override
       public void onDownloadStart(String url, String userAgent,
         String contentDisposition, String mimetype, long contentLength) {
           System.out.println("url ==== >" + url);
           //new HttpThread(url).start();
           Uri uri=Uri.parse(url);
           Intent intent=new Intent(Intent.ACTION_VIEW,uri);
           startActivity(intent);
       }
     }
     //网页加载完提示
     /*protected Handler handler = new Handler(){
         public void handleMessage(Message message){
            String data="Page NO FOUND!";
            String success="loading success!";
         	switch (message.what) {
            case 0:
                 myDialog.show();
                break;
            case 1:
                webView.loadUrl("javascript:document.body.innerHTML=\""+data+"\"");
                 break;
             case 2:
            	 webView.loadUrl("javascript:document.body.innerHTML=\""+success +"\"");
                 break;
             }
         }
     };*/
}
