package com.blackmoon.sensor_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.sound_test.PlaySoundActivity;
import com.blackmoon.sound_test.SoundTestActivity;

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

public class LightSensor extends Activity implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mSensor;
	TextView tvBrightnessIntentsity;
	private Button btnDone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_light_test);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		tvBrightnessIntentsity = (TextView) findViewById(R.id.tvLightIntensity);

		// button done
		btnDone = (Button) findViewById(R.id.btnSensorLightDone);

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
		if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
			tvBrightnessIntentsity
					.setText(getString(R.string.brightness_intensity)
							+ event.values[0] + "%");
		}
	}
	
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), SoundTestActivity.class));
		}
		super.onDestroy();
	}
}