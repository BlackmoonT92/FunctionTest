package com.blackmoon.vibration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.blackmoon.camera.CameraActivity;
import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.sensor_test.DirectionSensor;

public class VibrationActivity extends Activity implements OnClickListener {
	Button btnDone;
	ImageView ivVibrationToogle;
	Vibrator mVibrator;
	boolean isVibrate = true;

	int dot = 200; // Length of a Morse Code "dot" in milliseconds
	int dash = 500; // Length of a Morse Code "dash" in milliseconds
	int short_gap = 200; // Length of Gap Between dots/dashes
	int medium_gap = 500; // Length of Gap Between Letters
	int long_gap = 1000; // Length of Gap Between Words

	long[] pattern = { 0, // Start immediately
			dot, short_gap, dot, short_gap, dot, // s
			medium_gap, dash, short_gap, dash, short_gap, dash, // o
			medium_gap, dot, short_gap, dot, short_gap, dot, // s
			long_gap };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vibration_test);

		// find view
		btnDone = (Button) findViewById(R.id.btnVibrationDone);
		ivVibrationToogle = (ImageView) findViewById(R.id.ivVibrationToggle);

		// setClickListener

		btnDone.setOnClickListener(this);
		ivVibrationToogle.setOnClickListener(this);

		// vibrate when app start
		// Create Vibrator instance for current context
		mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		mVibrator.vibrate(pattern, -1);

	}


	@Override
	protected void onPause() {
		if (mVibrator != null) {
			mVibrator.cancel();
		}

		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		mVibrator.vibrate(pattern, -1);
		isVibrate = true;
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnVibrationDone:
			isVibrate = false;
			finish();
			break;

		case R.id.ivVibrationToggle:
			
			if (isVibrate) {
				mVibrator.cancel();
				isVibrate = false;
			} else {
				mVibrator.vibrate(pattern, -1);
				isVibrate = true;
			}
			break;

		default:
			break;
		}

	}

	
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), CameraActivity.class));
		}
		super.onDestroy();
	}
}
