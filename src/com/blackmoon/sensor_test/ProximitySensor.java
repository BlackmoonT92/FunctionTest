package com.blackmoon.sensor_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class ProximitySensor extends Activity implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mSensor;
	ImageView iv;
	TextView tvStatusProximity;
	private Button btnDone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_proximity);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		iv = (ImageView) findViewById(R.id.ivProximity);
		tvStatusProximity = (TextView) findViewById(R.id.tvStatusProximity);

		// button done
		btnDone = (Button) findViewById(R.id.btnSensorProximityDone);

		btnDone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mSensor,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	public void onSensorChanged(SensorEvent event) {
		if (event.values[0] == 0) {
			tvStatusProximity.setText(getString(R.string.status_near));
			// iv.setScaleX(1.5f);
			// iv.setScaleY(1.5f);
			iv.setScaleType(ScaleType.CENTER_CROP);

		} else {
			iv.setScaleType(ScaleType.CENTER_INSIDE);
			// iv.setScaleX(1f);
			// iv.setScaleY(1f);
			tvStatusProximity.setText(getString(R.string.status_far));
		}
	}

	@Override
	protected void onDestroy() {
		if (ConfigData.isTestAll) {
			startActivity(new Intent(getApplicationContext(),
					MagneticSensor.class));
		}
		super.onDestroy();
	}
}