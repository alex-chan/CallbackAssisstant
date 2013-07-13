package com.mollocer.callbackassisstant;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;


	
public class CustomPhoneStateListener extends PhoneStateListener {

    // private static final String TAG = "PhoneStateChanged";
    Context context; // Context to make Toast if required
    private AudioManager amanager;
    Intent i1;

    public CustomPhoneStateListener(Context context) {
        super();
        this.context = context;
//	        i1 = new Intent(context, YourActivity.class);       
//	        i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//	        i1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);

        switch (state) {
        case TelephonyManager.CALL_STATE_IDLE:
        	
//            Toast.makeText(context, "Phone state Idle", Toast.LENGTH_LONG)
//                    .show();

            break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
        	String phone = CallReceiver.originalPhoneNumber ;        	
            Toast toast = Toast.makeText(context, "Phone:"+phone, Toast.LENGTH_LONG);            
            toast.show();

            break;
        case TelephonyManager.CALL_STATE_RINGING:           
            try {
                Thread.sleep(3000);
//	                context.startActivity(i1);              
            } catch (Exception e) {
                e.getLocalizedMessage();
            }

        default:
            break;
        }
    }	
}





