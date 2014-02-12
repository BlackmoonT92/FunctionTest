package com.blackmoon.touch_test;

import com.blackmoon.functiontest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TouchTestActivity extends Activity implements OnClickListener {
	// ==========================================
	// VARIABLES
	// ==========================================

	Button btnSingleTouch;
	Button btnMultiTouch;
	Button btnPinchZoomTouch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touch_test);

		// findView
		findViewById();

		// setOnClick
		setOnClick();

	}

	private void setOnClick() {
		btnSingleTouch.setOnClickListener(this);
		btnMultiTouch.setOnClickListener(this);
		btnPinchZoomTouch.setOnClickListener(this);
	}

	private void findViewById() {
		btnSingleTouch = (Button) findViewById(R.id.btnSingleTouch);
		btnMultiTouch = (Button) findViewById(R.id.btnMultiTouch);
		btnPinchZoomTouch = (Button) findViewById(R.id.btnPinchZoomTouch);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnSingleTouch:
			startActivity(new Intent(getApplicationContext(), SingleTouchActivity.class));

			break;
		case R.id.btnMultiTouch:
			startActivity(new Intent(getApplicationContext(), MultitouchActivity.class));

			break;
		case R.id.btnPinchZoomTouch:
			startActivity(new Intent(getApplicationContext(), PinchZoomActivity.class));

			break;

		default:
			break;
		}

	}

}
