package com.blackmoon.touch_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.screen_test.ScreenTestActivity;
import com.blackmoon.sensor_test.AccelerationSensor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PinchZoomActivity extends Activity {

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ImageViewWithZoom(this));
	}
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), AccelerationSensor.class));
		}
		super.onDestroy();
	}
}