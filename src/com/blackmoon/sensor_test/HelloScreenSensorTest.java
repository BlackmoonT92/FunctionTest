package com.blackmoon.sensor_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HelloScreenSensorTest extends Activity implements OnClickListener {

	ImageView ivSensorPhone;
	TextView tvSensorContentTest;
	Button btnStartSensor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_sensor_test);

		// find view
		findViewById();

		// set on Click listener
		setOnClickListener();

		// setData

		fillData();

	}

	private void fillData() {
		switch (ConfigData.flagScreen) {
		case 1:
			ivSensorPhone.setImageResource(R.drawable.acceleration);
			tvSensorContentTest
					.setText(getString(R.string.content_sensor_acceleration_test));
			break;

		case 2:
			ivSensorPhone.setImageResource(R.drawable.direction);

			tvSensorContentTest
					.setText(getString(R.string.content_sensor_direction_test));
			break;
		case 3:
			ivSensorPhone.setImageResource(R.drawable.proximity);

			tvSensorContentTest
					.setText(getString(R.string.content_sensor_proximity_test));
			break;
		case 4:
			
			ivSensorPhone.setImageResource(R.drawable.magnetic);

			tvSensorContentTest
					.setText(getString(R.string.content_sensor_magnetic_test));
			break;
		case 5:
			ivSensorPhone.setImageResource(R.drawable.light);

			tvSensorContentTest
					.setText(getString(R.string.content_sensor_light_test));
			break;

		default:
			break;
		}

	}

	private void setOnClickListener() {
		btnStartSensor.setOnClickListener(this);
	}

	private void findViewById() {
		ivSensorPhone = (ImageView) findViewById(R.id.ivSensorPhone);
		tvSensorContentTest = (TextView) findViewById(R.id.tvSensorContentTest);
		btnStartSensor = (Button) findViewById(R.id.btnSensorStart);
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.btnSensorStart:
			switch (ConfigData.flagScreen) {
			case 1:
				startActivity(new Intent(getApplicationContext(),
						AccelerationSensor.class));
				break;
			
			case 2:
				startActivity(new Intent(getApplicationContext(),
						DirectionSensor.class));
				break;
			case 3:
				startActivity(new Intent(getApplicationContext(),
						ProximitySensor.class));
				break;
			case 4:
				startActivity(new Intent(getApplicationContext(),
						MagneticSensor.class));
				break;
			case 5:
				startActivity(new Intent(getApplicationContext(),
						LightSensor.class));
				break;

			default:
				break;
			}

			break;

		default:
			break;
		}
	}
}
