package com.mollocer.callbackassisstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CallExtraInput extends Activity{
	
	private static final String TAG = "CallExtraInput";

	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		
		Intent intent = getIntent();
		
		final String action = intent.getAction();
		final String phone = intent.getDataString();
		
		Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
		
		Log.d(TAG, phone);
	}
}
