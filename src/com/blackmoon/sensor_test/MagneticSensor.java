package com.blackmoon.sensor_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MagneticSensor extends Activity implements OnClickListener,
		SensorEventListener {

	ImageView ivSensorPhone;
	TextView tvSensorContentTest;
	TextView tvAxis_X;
	TextView tvAxis_Y;
	TextView tvAxis_Z;
	TextView tvSensorStatus;

	Button btnDoneTestSensor;

	// sensor
	private SensorManager sensorManager;
	private Sensor mCompassSensor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_magnetic_test);

		// find view
		findViewById();

		// set on Click listener
		setOnClickListener();

		// setData

		fillData();

		// handle event sensor
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		// get compass sensor (ie magnetic field)
		mCompassSensor = sensorManager
				.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

	}

	private void fillData() {

		tvSensorContentTest
				.setText(getString(R.string.content_sensor_acceleration_test));

	}

	private void setOnClickListener() {
		btnDoneTestSensor.setOnClickListener(this);
	}

	private void findViewById() {
		ivSensorPhone = (ImageView) findViewById(R.id.ivMagnetic);

		tvSensorContentTest = (TextView) findViewById(R.id.tvSensorMagneticContentTest);

		tvAxis_X = (TextView) findViewById(R.id.tvMagneticAxis_X);

		tvAxis_Y = (TextView) findViewById(R.id.tvMagneticAxis_Y);

		tvAxis_Z = (TextView) findViewById(R.id.tvMagneticAxis_Z);

		tvSensorStatus = (TextView) findViewById(R.id.tvResultMagneticTest);

		btnDoneTestSensor = (Button) findViewById(R.id.btnMagneticDone);
	}



	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnMagneticDone:
			finish();
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		// register this class as a listener for the orientation and
		// accelerometer sensors
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		// unregister listener
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			getMegnetic(event);
		}

	}

	private void getMegnetic(SensorEvent event) {
		float[] values = event.values;
		// Movement
		float x = values[0];
		float y = values[1];
		float z = values[2];

		tvAxis_X.setText(getString(R.string.x_axis_value)
				+ (float) (int) (x * 100) / 100.0);
		tvAxis_Y.setText(getString(R.string.x_axis_value)
				+ (float) (int) (y * 100) / 100.0);
		tvAxis_Z.setText(getString(R.string.x_axis_value)
				+ (float) (int) (z * 100) / 100.0);

		double mag = Math.sqrt(x*x + y*y + z*z);
		
		if (mag > 1.4*7.5 || mag < 0.6*7.5) {
			tvSensorStatus.setText(getString(R.string.detected));
			
		} else {
			tvSensorStatus.setText(getString(R.string.normal));
		}
	}
	
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), LightSensor.class));
		}
		super.onDestroy();
	}
}
