package com.blackmoon.camera;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.gps.AndroidGPSTrackingActivity;
import com.blackmoon.sensor_test.DirectionSensor;

public class CameraActivity extends Activity implements OnClickListener {

	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
	private Uri fileImageUri;
	private Uri fileVideoUri;

	Button btnTakePickture;
	Button btnTakeVideo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera_option);

		// find
		btnTakePickture = (Button) findViewById(R.id.btnTakePicture);
		btnTakeVideo = (Button) findViewById(R.id.btnTakeVideo);

		btnTakePickture.setOnClickListener(this);
		btnTakeVideo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnTakePicture:
			// create Intent to take a picture and return control to the calling
			// application
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

			intent.putExtra(MediaStore.EXTRA_OUTPUT, fileImageUri); // set the
																	// image
			// start the image capture Intent
			startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			break;

		case R.id.btnTakeVideo:
			// create new Intent
			Intent intentVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

			intentVideo.putExtra(MediaStore.EXTRA_OUTPUT, fileVideoUri);

			intentVideo.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

			// start the Video Capture Intent
			startActivityForResult(intentVideo,
					CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void onDestroy() {
		if(ConfigData.isTestAll){
			startActivity(new Intent(getApplicationContext(), AndroidGPSTrackingActivity.class));
		}
		super.onDestroy();
	}

}