package com.blackmoon.button_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.functiontest.R.drawable;
import com.blackmoon.functiontest.R.id;
import com.blackmoon.functiontest.R.layout;
import com.blackmoon.functiontest.R.string;
import com.blackmoon.screen_test.ScreenTestActivity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ButtonTestActivity extends Activity implements OnClickListener {
	// ======================================
	// VARIABLES
	// ======================================

	ImageView ivBack;
	ImageView ivHome;
	ImageView ivMenu;
	ImageView ivVolumeHigh;
	ImageView ivVolumeLow;
	ImageView ivPower;

	Button btnTestButtonStart;
	TextView tvContentButtonTest;
	TextView tvTimeButtonTest;

	boolean isFirstPressOk = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_test);

		// findView
		findViewById();

		// setOnClick
		setOnClick();

	}

	private void setOnClick() {
		btnTestButtonStart.setOnClickListener(this);

	}

	private void findViewById() {
		ivBack = (ImageView) findViewById(R.id.ivback);
		ivHome = (ImageView) findViewById(R.id.ivHome);
		ivMenu = (ImageView) findViewById(R.id.ivMenu);
		ivPower = (ImageView) findViewById(R.id.ivPower);
		ivVolumeHigh = (ImageView) findViewById(R.id.ivVolumeHigh);
		ivVolumeLow = (ImageView) findViewById(R.id.ivVolumeLow);

		btnTestButtonStart = (Button) findViewById(R.id.btnStart);

		tvContentButtonTest = (TextView) findViewById(R.id.tvContentTest);
		tvTimeButtonTest = (TextView) findViewById(R.id.tvTimeTest);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnStart:
			if (isFirstPressOk) {
				finish();
			}
			// change test for button
			isFirstPressOk = true;
			btnTestButtonStart.setText(getString(R.string.lablel_done));
			ivBack.setImageResource(R.drawable.back_picked);
			tvTimeButtonTest.setVisibility(View.GONE);
			tvContentButtonTest
					.setText(getString(R.string.test_button_back_tap));

			break;

		default:
			break;
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(!isFirstPressOk){
			return true;
		}
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			ivBack.setImageResource(R.drawable.back);
			ivMenu.setImageResource(R.drawable.menu_picked);
			tvContentButtonTest
					.setText(getString(R.string.test_button_menu_tap));

			/*
			 * ivHome.setImageResource(R.drawable.home_picked);
			 * tvContentButtonTest
			 * .setText(getString(R.string.test_button_home_tap));
			 */
			return true;
			/*
			 * case KeyEvent.KEYCODE_HOME:
			 * ivHome.setImageResource(R.drawable.home);
			 * ivMenu.setImageResource(R.drawable.menu_picked);
			 * tvContentButtonTest
			 * .setText(getString(R.string.test_button_menu_tap)); return false;
			 */
		case KeyEvent.KEYCODE_MENU:
			ivMenu.setImageResource(R.drawable.menu);
			ivVolumeHigh.setImageResource(R.drawable.volume_high_picked);
			tvContentButtonTest
					.setText(getString(R.string.test_button_volume_up_tap));
			return true;
		case KeyEvent.KEYCODE_VOLUME_UP:
			ivVolumeHigh.setImageResource(R.drawable.volume_high);
			ivVolumeLow.setImageResource(R.drawable.volume_low_picked);
			tvContentButtonTest
					.setText(getString(R.string.test_button_volume_down_tap));
			return true;

		case KeyEvent.KEYCODE_VOLUME_DOWN:
			ivVolumeLow.setImageResource(R.drawable.volume_low);
			finish();
			//ivPower.setImageResource(R.drawable.power_picked);
			//tvContentButtonTest.setText(getString(R.string.test_button_power_tap));
			return true;

		case KeyEvent.KEYCODE_POWER:
			return true;
			// finish();

		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), ScreenTestActivity.class));
		}
		super.onDestroy();
	}

	
	
}
