package com.mollocer.callbackassisstant;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {
	
      private final String TAG = "CallReceiver";
      
	  @Override
	  public void onReceive(Context context, Intent intent) {
	    // Extract phone number reformatted by previous receivers
		  
		  
	    String phoneNumber = getResultData();
	    
	    Log.d(TAG, phoneNumber);
	    if (phoneNumber == null) {
	      // No reformatted number, use the original
	      phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	    }
	    // My app will bring up the call, so cancel the broadcast
	    setResultData(null);
	    // Start my app to bring up the call
	    
	  }
}