package com.mollocer.callbackassisstant;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;




public class CallReceiver extends BroadcastReceiver {
	
      private final String TAG = "CallReceiver";
      
      private CustomPhoneStateListener mPhoneStateListener;
      public static String originalPhoneNumber;
      
      
	  @Override
	  public void onReceive(Context context, Intent intent) {
	    // Extract phone number reformatted by previous receivers
		  
		  
	    
	    registerPhoneListener(context);
	    redirectPhoneNumber(context,intent);
	    
	  }
	  
	  void redirectPhoneNumber(Context context, Intent intent){
		  	String phoneNumber = getResultData();
		    
		    Log.d(TAG, phoneNumber);
		    if (phoneNumber == null) {
		      // No reformatted number, use the original
		      phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
		    }
		    
		    originalPhoneNumber = phoneNumber;
		    
		    // My app will bring up the call, so cancel the broadcast
		    //setResultData(null);
		    ///setResultData("+8613807683356,"+phoneNumber+"#");
		    setResultData("+8613807683356");//+phoneNumber+"#");
		    // Start my app to bring up the call
		      
	  }
	  
	  
	  void registerPhoneListener(Context context){
			TelephonyManager telephonyManager = (TelephonyManager) context
	                .getSystemService(Context.TELEPHONY_SERVICE);           
			mPhoneStateListener = new CustomPhoneStateListener(context);
	        telephonyManager.listen(mPhoneStateListener,
	                PhoneStateListener.LISTEN_CALL_STATE);
	  }
}