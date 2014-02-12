package com.blackmoon.touch_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.screen_test.ScreenTestActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MultitouchActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multitouch_test);
	}

	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), PinchZoomActivity.class));
		}
		super.onDestroy();
	}
}
