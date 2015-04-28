package com.Yoo.lifecycletracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends BroadcastReceiver {

	private final String TAG = "Receiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "Intent received");
		Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
	}
}
