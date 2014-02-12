package com.blackmoon.touch_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.screen_test.ScreenTestActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SingleTouchActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(new SingleTouchEventView(this, null));

	}
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), MultitouchActivity.class));
		}
		super.onDestroy();
	}

}
