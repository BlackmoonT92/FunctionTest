package com.blackmoon.gps;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.network.NetworkTestActivity;
import com.blackmoon.sensor_test.DirectionSensor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndroidGPSTrackingActivity extends Activity {

	Button btnShowLocation;

	// GPSTracker class
	GPSTracker gps;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps_option);

		btnShowLocation = (Button) findViewById(R.id.btnGPS);

		// show location button click event
		btnShowLocation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
				boolean enabled = mlocManager
						.isProviderEnabled(LocationManager.GPS_PROVIDER);
				// create class object
				gps = new GPSTracker(AndroidGPSTrackingActivity.this);
			
				
				// check if GPS enabled
				if (enabled) {

					double latitude = gps.getLatitude();
					double longitude = gps.getLongitude();

					// \n is for new line
					Toast.makeText(
							getApplicationContext(),
							"Your Location is - \nLat: " + latitude
									+ "\nLong: " + longitude, Toast.LENGTH_LONG)
							.show();
				} else {
					// can't get location
					// GPS or Network is not enabled
					// Ask user to enable GPS/network in settings
					gps.showSettingsAlert();
				}

			}
		});
	}
	
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), NetworkTestActivity.class));
		}
		super.onDestroy();
	}

}