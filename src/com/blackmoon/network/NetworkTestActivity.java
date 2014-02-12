package com.blackmoon.network;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NetworkTestActivity extends Activity implements OnClickListener {

	Button btnWifi;
	Button btn3G;
	Button btnBluetooth;
	Button btnNFC;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network_option);

		// findView
		findViewById();

		// setOnClick
		setOnClickListener();

	}

	private void setOnClickListener() {
		btn3G.setOnClickListener(this);
		btnBluetooth.setOnClickListener(this);
		btnNFC.setOnClickListener(this);
		btnWifi.setOnClickListener(this);

	}

	private void findViewById() {
		btn3G = (Button) findViewById(R.id.btn3G);
		btnBluetooth = (Button) findViewById(R.id.btnBluetooth);
		btnNFC = (Button) findViewById(R.id.btnNFC);
		btnWifi = (Button) findViewById(R.id.btnWifi);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnWifi:
			try {
				startActivity(new Intent(
						android.provider.Settings.ACTION_WIFI_SETTINGS));
			} catch (Exception e) {
				Toast.makeText(this, getString(R.string.not_supported), 0)
						.show();
			}

			break;

		case R.id.btn3G:
			try {
				startActivity(new Intent(
						android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
			} catch (Exception e) {
				Toast.makeText(this, getString(R.string.not_supported), 0)
						.show();
			}

			break;

		case R.id.btnBluetooth:
			try {
				startActivity(new Intent(
						android.provider.Settings.ACTION_BLUETOOTH_SETTINGS));
			} catch (Exception e) {
				Toast.makeText(this, getString(R.string.not_supported), 0)
						.show();
			}

			break;

		case R.id.btnNFC:
			try {
				startActivity(new Intent(
						android.provider.Settings.ACTION_NFCSHARING_SETTINGS));

			} catch (Exception e) {
				Toast.makeText(this, getString(R.string.not_supported), 0)
						.show();
			}

			break;

		default:
			break;
		}
	}
	
	@Override
	protected void onDestroy() {
		ConfigData.isTestAll = false;
		super.onDestroy();
	}

}
