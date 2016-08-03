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
		//��activityȫ����ʾ
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//ȫ����ʾ
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
		//WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		//��ȫ����ʾ
		//getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		setContentView(R.layout.activity_main);
		//������ҳ
		init();
		//��ȡ��Ϣ
 
	//1"DEVICE_TYPE", "DEVICE_SYSTEM_NAME", "DEVICE_VERSION", "DEVICE_SYSTEM_VERSION", "DEVICE_TOKEN",
		Log.v("��һ����Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TYPE));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_SYSTEM_NAME));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_VERSION));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_SYSTEM_VERSION));
		Log.v("��ȡ��Ϣ-->\n",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOKEN));
		
		Log.v("�ڶ�����Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NAME));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_UUID));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_MANUFACTURE));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.IPHONE_TYPE));
		Log.v("��ȡ��Ϣ--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_VERSION));
		
		Log.v("��������Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.CONTACT_ID));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_LANGUAGE));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TIME_ZONE));
		Log.v("��ȡ��Ϣ--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_LOCAL_COUNTRY_CODE));
		
	 //"DEVICE_CURRENT_YEAR", "DEVICE_CURRENT_DATE_TIME"," DEVICE_CURRENT_DATE_TIME_ZERO_GMT",
		Log.v("��������Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_CURRENT_YEAR));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_CURRENT_DATE_TIME));
		Log.v("��ȡ��Ϣ--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_CURRENT_DATE_TIME_ZERO_GMT));
	
	//5 "DEVICE_HARDWARE_MODEL", "DEVICE_NUMBER_OF_PROCESSORS"," DEVICE_LOCALE, DEVICE_NETWORK", "DEVICE_NETWORK_TYPE",
		Log.v("��������Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_HARDWARE_MODEL));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NUMBER_OF_PROCESSORS));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_LOCALE));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NETWORK));
		Log.v("��ȡ��Ϣ--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_NETWORK_TYPE));
		
	//6  "DEVICE_IP_ADDRESS_IPV4", "DEVICE_IP_ADDRESS_IPV6", "DEVICE_MAC_ADDRESS", "DEVICE_TOTAL_CPU_USAGE",
		//Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_IP_ADDRESS_IPV4));
		//Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_IP_ADDRESS_IPV6));
		Log.v("��������Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_MAC_ADDRESS));
		Log.v("��ȡ��Ϣ--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_USAGE));
	
	// 7 "DEVICE_TOTAL_MEMORY", "DEVICE_FREE_MEMORY", "DEVICE_USED_MEMORY",
		Log.v("��������Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_MEMORY));
		Log.v("��ȡ��Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_FREE_MEMORY));
		Log.v("��ȡ��Ϣ--\n>",DeviceInfo.getDeviceInfo(this,Device.DEVICE_USED_MEMORY));
		
	// 8 "DEVICE_TOTAL_CPU_USAGE_USER"," DEVICE_TOTAL_CPU_USAGE_SYSTEM",	
		Log.v("�ڰ�����Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_USAGE_USER));
		Log.v("��ȡ��Ϣ-->\n",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_USAGE_SYSTEM));
		
	//9  "DEVICE_TOTAL_CPU_IDLE", "DEVICE_IN_INCH"
		Log.v("�ھ�����Ϣ-->",DeviceInfo.getDeviceInfo(this,Device.DEVICE_TOTAL_CPU_IDLE));
		Log.v("��ȡ��Ϣ-->\n\n",DeviceInfo.getDeviceInfo(this,Device.DEVICE_IN_INCH));
		
		System.out.println("��ȡ��Ϣ���");
		
		
		
		 
		 
		
		
		
		
		
		
		
		
		
		//Log.d("�����˻�ȡ��Ϣ�ķ���-->",getInfo());
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/example.html");
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("http://baidu.com");
        //����Ӧ�ֻ���Ļ
        /*WebSettings webSettings = webView.getSettings();       
        webSettings.setUseWideViewPort(true);//���ô����ԣ��������������
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
        
        //myTextView.setText("������:"+phoneNumber+"\n"+"�����ͺ�:"+phoneModel+"\n"+"����SDK�汾:"+phoneSdkVersion+"\n"+"ϵͳ�汾:"+phoneReleaseVersion);
        //myButton=(Button)findViewById(R.id.mButton);
        //myButton.setOnClickListener(new myButtonOnClickListener());
	}
	
	  
	
	//�����ȡ��Ϣ֮ǰ��7.25.19��20
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
	        //WebView����web��Դ
	       webView.loadUrl("http://baidu.com");
	       //webView.addJavascriptInterface(this, "javatojs");//��
	       
	       //����webView��������
	       WebSettings webSettings = webView.getSettings();       
	       webSettings.setUseWideViewPort(true);//���ô����ԣ��������������
	       webSettings.setLoadWithOverviewMode(true);
	       webSettings.setJavaScriptEnabled(true);
	       webSettings.setSupportMultipleWindows(true);
	       //����ʹ�û���
	       webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
	       //checkUPPay();//�������֧���ؼ��Ƿ������
	       //WebViewClient����������WebView����֪ͨ�������¼�
	       webView.setWebViewClient(new WebViewClient(){
	    	   @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
	             view.loadUrl(url);
	            return true;
	        }
	    	   @Override
	    	   public void onReceivedError(WebView view, int errorCode,
	    	   	String description, String failingUrl) {
	    	   	//��javascript����ϵͳ�����404ҳ����Ϣ
	    	   	String data = "Page NO FOUND������������������";
	    	   	view.loadUrl("javascript:document.body.innerHTML=\"" + data + "\"");
	    	   }
	   });
	      
	       //WebChromeClient������������Ⱦ��ҳ��Ϊ������WebView����Javascript�Ի�����վͼ�꣬title,���ؽ���
	       webView.setWebChromeClient(new WebChromeClient(){
	    	   //��ȡ��ǰҳ���title�ķ���
	    	  /*@Override
	            public void onReceivedTitle(WebView view, String title) {
	    		   titleview=(TextView)findViewById(R.id.mTextView);
	    		   titleview.setText(title);//a TextView
	            }*/
	    	   
	    	  /* public void onProgressChanged(WebView view, int newProgress)//���� ���ؽ���
               {
	    		   
	    		   if (newProgress == 100) {
	                    // ��ҳ�������
	    			   	//titleview.setText("ҳ��������"); //��ôд��������
	    			   System.out.println("ҳ��������");
	                } else {
	                    // ������
	                	//titleview.setText("ҳ�������..");
	                	System.out.println("ҳ�������");
	                }
             		MainActivity.this.setTitle("���ڼ���..Loading...");
             		}*/
	            /*@SuppressWarnings("deprecation")
				public void onProgressChanged(WebView view, int progress)//���� ���ؽ���
	                             {
	            					
	                           		MainActivity.this.setTitle("���ڼ���..Loading...");
	                                MainActivity.this.setProgress(progress * 100);
	                                if(progress >= 100){
	                                   new Thread(new Runnable() {
	                                       @Override
	                                        public void run() {
	                                           Message msg=handler.obtainMessage();//����֪ͨ�������߳�
	                                           msg.what=2;//�������
	                                           handler.sendMessage(msg);//֪ͨ���ͣ�
	                                       }              
	                                    }).start();  
	                                     MainActivity.this.setTitle(R.string.app_name);
	                                 }
	                            }*/

	        });
	       
	  }
	//��д�������������ص��߼�
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();//������һҳ��
                return true;
            }
            else
            {
                System.exit(0);//�˳�����
            }
        }
        return super.onKeyDown(keyCode, event);
    }
	/* private void checkUPPay() {
		// TODO Auto-generated method stub
		
	}*/
	//����DownloadListener (webKit��)
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
     //��ҳ��������ʾ
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
