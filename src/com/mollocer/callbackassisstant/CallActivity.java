package com.mollocer.callbackassisstant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class CallActivity extends Activity {
	 
	private final static String TAG= "CallActivity"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		final Intent intent = getIntent();
		
		
		final String action = intent.getAction();
		
		final Uri uri = intent.getData();
		
		Log.d(TAG, action);
		Log.d(TAG, uri.toString() );
				
		
	}
	
//	@Override
//	public void onStart(Intent intent){
//		
//	}
}
