package com.Yoo.lifecycletracker;

import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends TraceActivity {
	
	static final String My_Intent = "com.Yoo.lifecycletracker.show_message";
	private final SecondActivity myReceiver = new SecondActivity();
	IntentFilter newIntFilter = new IntentFilter(My_Intent);
	private LocalBroadcastManager myManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		myManager = LocalBroadcastManager.getInstance(getApplicationContext());
		myManager.registerReceiver(myReceiver, newIntFilter);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				myManager.sendBroadcast(new Intent(My_Intent));
		}
	});
	}
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(myReceiver);
		super.onDestroy();
	}


}
