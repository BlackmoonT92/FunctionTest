package com.blackmoon.sensor_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.screen_test.ScreenTestActivity;

import android.app.Activity;
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

public class AccelerationSensor extends Activity implements OnClickListener,
		SensorEventListener {

	ImageView ivSensorPhone;
	TextView tvSensorContentTest;
	TextView tvAxis;
	TextView tvAxis_X;
	TextView tvAxis_Y;
	TextView tvAxis_Z;
	TextView tvSensorStatus;

	Button btnNextSensor;

	// sensor
	private SensorManager sensorManager;
	private long lastUpdate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_acceleration_test);

		// find view
		findViewById();

		// set on Click listener
		setOnClickListener();

		// setData

		fillData();

		// handle event sensor
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		lastUpdate = System.currentTimeMillis();

	}

	private void fillData() {

		ivSensorPhone.setImageResource(R.drawable.acceleration_x);
		tvSensorContentTest
				.setText(getString(R.string.content_sensor_acceleration_test));
		tvAxis.setText(getString(R.string.x_axis));

	}

	private void setOnClickListener() {
		btnNextSensor.setOnClickListener(this);
	}

	private void findViewById() {
		ivSensorPhone = (ImageView) findViewById(R.id.ivSensorPhone);

		tvSensorContentTest = (TextView) findViewById(R.id.tvSensorContentTest);

		tvAxis = (TextView) findViewById(R.id.tvAxis);

		tvAxis_X = (TextView) findViewById(R.id.tvAxis_X);

		tvAxis_Y = (TextView) findViewById(R.id.tvAxis_Y);

		tvAxis_Z = (TextView) findViewById(R.id.tvAxis_Z);
		
		tvSensorStatus = (TextView) findViewById(R.id.tvResultTest);

		btnNextSensor = (Button) findViewById(R.id.btnSensorNext);
	}

	// reset value of axis x,y,z
	private void resetAxisValue() {
		tvAxis_X.setText(getString(R.string.x_axis_value));
		tvAxis_Y.setText(getString(R.string.y_axis_value));
		tvAxis_Z.setText(getString(R.string.z_axis_value));
		tvSensorStatus.setVisibility(View.GONE);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnSensorNext:
			ConfigData.accelerationSensorType++;
			resetAxisValue();
			switch (ConfigData.accelerationSensorType) {
			case 2:
				ivSensorPhone.setImageResource(R.drawable.acceleration_y);
				tvSensorContentTest
						.setText(getString(R.string.content_sensor_acceleration_test));
				tvAxis.setText(getString(R.string.y_axis));
				break;
			case 3:
				ivSensorPhone.setImageResource(R.drawable.acceleration_z);
				tvSensorContentTest
						.setText(getString(R.string.content_sensor_acceleration_test));
				tvAxis.setText(getString(R.string.z_axis));

				btnNextSensor.setText(getString(R.string.lablel_done));
				break;

			case 4:
				ConfigData.accelerationSensorType = 1;
				finish();
				break;

			}

			break;

		default:
			break;
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
			getAccelerometer(event);
		}

	}

	private void getAccelerometer(SensorEvent event) {
		float[] values = event.values;
		// Movement
		float x = values[0];
		float y = values[1];
		float z = values[2];

		
		tvAxis_X.setText(getString(R.string.x_axis_value) + (float)(int)(x*100)/100.0);
		tvAxis_Y.setText(getString(R.string.x_axis_value) + (float)(int)(y*100)/100.0);
		tvAxis_Z.setText(getString(R.string.x_axis_value) + (float)(int)(z*100)/100.0);

		float accelationSquareRoot = (x * x + y * y + z * z)
				/ (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
		long actualTime = System.currentTimeMillis();
		if (accelationSquareRoot >= 2) //
		{
			if (actualTime - lastUpdate < 100) {
				return;
			}
			lastUpdate = actualTime;
			
			tvSensorStatus.setVisibility(View.VISIBLE);
			
		}
	}
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), DirectionSensor.class));
		}
		super.onDestroy();
	}
}
