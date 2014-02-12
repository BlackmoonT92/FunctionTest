package com.blackmoon.sensor_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.touch_test.MultitouchActivity;
import com.blackmoon.touch_test.PinchZoomActivity;
import com.blackmoon.touch_test.SingleTouchActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SensorTestActivity extends Activity implements OnClickListener {

	// ==========================================
	// VARIABLES
	// ==========================================

	Button btnSensorAcceleration;
	Button btnSensorDirection;
	Button btnSensorProximity;
	Button btnSensorMagnetic;
	Button btnSensorLight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_test);

		// findView
		findViewById();

		// setOnClick
		setOnClick();

	}

	private void setOnClick() {
		btnSensorAcceleration.setOnClickListener(this);
		btnSensorDirection.setOnClickListener(this);
		btnSensorLight.setOnClickListener(this);
		btnSensorMagnetic.setOnClickListener(this);
		btnSensorProximity.setOnClickListener(this);
	}

	private void findViewById() {
		btnSensorAcceleration = (Button) findViewById(R.id.btnSensorAcceleration);
		btnSensorDirection = (Button) findViewById(R.id.btnSensorDirection);
		btnSensorLight = (Button) findViewById(R.id.btnSensorLight);
		btnSensorMagnetic = (Button) findViewById(R.id.btnSensorMagnetic);
		btnSensorProximity = (Button) findViewById(R.id.btnSensorProximity);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnSensorAcceleration:
			ConfigData.flagScreen = 1;
			startActivity(new Intent(getApplicationContext(),
					HelloScreenSensorTest.class));

			break;

		case R.id.btnSensorDirection:
			ConfigData.flagScreen = 2;
			startActivity(new Intent(getApplicationContext(),
					HelloScreenSensorTest.class));

			break;
		case R.id.btnSensorProximity:
			ConfigData.flagScreen = 3;
			startActivity(new Intent(getApplicationContext(),
					HelloScreenSensorTest.class));

			break;

		case R.id.btnSensorMagnetic:
			ConfigData.flagScreen = 4;
			startActivity(new Intent(getApplicationContext(),
					HelloScreenSensorTest.class));

			break;
		case R.id.btnSensorLight:
			ConfigData.flagScreen = 5;
			startActivity(new Intent(getApplicationContext(),
					HelloScreenSensorTest.class));

			break;

		default:
			break;
		}

	}

}
