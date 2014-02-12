package com.blackmoon.functiontest;


import com.blackmoon.button_test.ButtonTestActivity;
import com.blackmoon.camera.CameraActivity;
import com.blackmoon.gps.AndroidGPSTrackingActivity;
import com.blackmoon.network.NetworkTestActivity;
import com.blackmoon.screen_test.ScreenTestActivity;
import com.blackmoon.sensor_test.SensorTestActivity;
import com.blackmoon.sound_test.SoundTestActivity;
import com.blackmoon.touch_test.MultitouchActivity;
import com.blackmoon.touch_test.PinchZoomActivity;
import com.blackmoon.touch_test.SingleTouchActivity;
import com.blackmoon.touch_test.TouchTestActivity;
import com.blackmoon.vibration.VibrationActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class OptionTestActivity extends Activity implements OnClickListener, android.content.DialogInterface.OnClickListener {
	// ============================================
	// VARIABLES
	// ============================================
	private LinearLayout btnLayoutButton;
	private LinearLayout btnLayoutScreen;
	private LinearLayout btnLayoutTouch;
	private LinearLayout btnLayoutSensor;
	private LinearLayout btnLayoutSound;
	private LinearLayout btnLayoutVibration;
	private LinearLayout btnLayoutCamera;
	private LinearLayout btnLayoutGPS;
	private LinearLayout btnLayoutNetwork;

	private Button btnTestAll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_test);

		// config actionbar
		// getActionBar().setTitle(R.string.app_name);

		// findView
		findViewById();

		// setOnClick
		setOnClick();
	}

	private void setOnClick() {
		btnLayoutButton.setOnClickListener(this);
		btnLayoutCamera.setOnClickListener(this);
		btnLayoutGPS.setOnClickListener(this);
		btnLayoutNetwork.setOnClickListener(this);
		btnLayoutScreen.setOnClickListener(this);
		btnLayoutSensor.setOnClickListener(this);
		btnLayoutSound.setOnClickListener(this);
		btnLayoutTouch.setOnClickListener(this);
		btnLayoutVibration.setOnClickListener(this);
		btnTestAll.setOnClickListener(this);
	}

	private void findViewById() {
		btnLayoutButton = (LinearLayout) findViewById(R.id.btnLayoutButton);
		btnLayoutScreen = (LinearLayout) findViewById(R.id.btnLayoutScreen);
		btnLayoutTouch = (LinearLayout) findViewById(R.id.btnLayoutTouch);
		btnLayoutSensor = (LinearLayout) findViewById(R.id.btnLayoutSensor);
		btnLayoutSound = (LinearLayout) findViewById(R.id.btnLayoutSound);
		btnLayoutVibration = (LinearLayout) findViewById(R.id.btnLayoutVibration);
		btnLayoutCamera = (LinearLayout) findViewById(R.id.btnLayoutCamera);
		btnLayoutGPS = (LinearLayout) findViewById(R.id.btnLayoutGPS);
		btnLayoutNetwork = (LinearLayout) findViewById(R.id.btnLayoutNetwork);

		btnTestAll = (Button) findViewById(R.id.btnTestAll);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnLayoutButton:
			startActivity(new Intent(getApplicationContext(),
					ButtonTestActivity.class));
			break;
		case R.id.btnLayoutScreen:
			startActivity(new Intent(getApplicationContext(),
					ScreenTestActivity.class));
			break;
		case R.id.btnLayoutTouch:
			startActivity(new Intent(getApplicationContext(),
					TouchTestActivity.class));
			break;
		case R.id.btnLayoutSensor:
			startActivity(new Intent(getApplicationContext(),
					SensorTestActivity.class));

			break;
		case R.id.btnLayoutSound:
			startActivity(new Intent(getApplicationContext(),
					SoundTestActivity.class));

			break;
		case R.id.btnLayoutVibration:
			startActivity(new Intent(getApplicationContext(),
					VibrationActivity.class));

			break;
		case R.id.btnLayoutCamera:
			startActivity(new Intent(getApplicationContext(),
					CameraActivity.class));

			break;
		case R.id.btnLayoutGPS:
			startActivity(new Intent(getApplicationContext(),
					AndroidGPSTrackingActivity.class));

			break;
		case R.id.btnLayoutNetwork:
			startActivity(new Intent(getApplicationContext(),
					NetworkTestActivity.class));

			break;

		case R.id.btnTestAll:
			ConfigData.isTestAll = true;
			startActivity(new Intent(getApplicationContext(),
					ButtonTestActivity.class));

			break;

		default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		
			AlertDialog dialog = createAlertDialog();
			dialog.show();
	}
	
	public AlertDialog createAlertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.close_app));
		builder.setIcon(R.drawable.icon);

		builder.setPositiveButton(getString(R.string.yes), this);
		builder.setNeutralButton(getString(R.string.cancel), this);
		return builder.create();
	}

	public void onClick(DialogInterface dialog, int which) {
		if (which == AlertDialog.BUTTON_POSITIVE) {
			finish();

		} else if (which == AlertDialog.BUTTON_NEUTRAL) {

		}
	}
}
