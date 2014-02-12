package com.blackmoon.sound_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;
import com.blackmoon.sensor_test.DirectionSensor;
import com.blackmoon.vibration.VibrationActivity;

public class SoundTestActivity extends Activity implements OnClickListener {

	LinearLayout layoutPhoneRingtone;
	LinearLayout layoutNotificationSound;
	LinearLayout layoutAlarm;
	LinearLayout layoutMicrophone;

	TextView tvPhoneRingtone;
	TextView tvNotificationSound;
	TextView tvAlarm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_option);

		findViewById();

		setOnclickListener();

		fillData();
	}

	private void fillData() {
		try {
			Uri uriPhoneRingtone = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

			ConfigData.phoneRingtone = RingtoneManager.getRingtone(
					getApplicationContext(), uriPhoneRingtone);

			String titlePhoneRingtone = ConfigData.phoneRingtone.getTitle(this);
			ConfigData.titlePhone = titlePhoneRingtone.subSequence(18,
					titlePhoneRingtone.length() - 1);
			tvPhoneRingtone.setText(ConfigData.titlePhone);

			// notification sound

			Uri uriNotificationSound = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

			ConfigData.notificationSound = RingtoneManager.getRingtone(
					getApplicationContext(), uriNotificationSound);

			String titleNotificationSound = ConfigData.notificationSound
					.getTitle(this);
			ConfigData.titleNotification = titleNotificationSound.subSequence(
					18, titleNotificationSound.length() - 1);
			tvNotificationSound.setText(ConfigData.titleNotification);

			// Alarm sound

			Uri uriAlarmSound = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_ALARM);

			ConfigData.alarmSound = RingtoneManager.getRingtone(
					getApplicationContext(), uriAlarmSound);
			String titleAlrmSound = ConfigData.alarmSound.getTitle(this);
			ConfigData.titleAlarm = titleAlrmSound.subSequence(18,
					titleAlrmSound.length() - 1);
			tvAlarm.setText(ConfigData.titleAlarm);
		} catch (NullPointerException e) {

		}

	}

	private void setOnclickListener() {
		layoutAlarm.setOnClickListener(this);
		layoutMicrophone.setOnClickListener(this);
		layoutNotificationSound.setOnClickListener(this);
		layoutPhoneRingtone.setOnClickListener(this);
	}

	private void findViewById() {
		layoutAlarm = (LinearLayout) findViewById(R.id.layoutAlarm);
		layoutMicrophone = (LinearLayout) findViewById(R.id.layoutMicrophone);
		layoutNotificationSound = (LinearLayout) findViewById(R.id.layoutNotificationSound);
		layoutPhoneRingtone = (LinearLayout) findViewById(R.id.layoutPhoneRingtone);

		// textview
		tvAlarm = (TextView) findViewById(R.id.tvAlarm);
		tvNotificationSound = (TextView) findViewById(R.id.tvNotificationSound);
		tvPhoneRingtone = (TextView) findViewById(R.id.tvPhoneRingtone);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layoutAlarm:
			ConfigData.soundType = 3;
			startActivity(new Intent(getApplicationContext(),
					PlaySoundActivity.class));
			break;
		case R.id.layoutPhoneRingtone:

			ConfigData.soundType = 1;

			startActivity(new Intent(getApplicationContext(),
					PlaySoundActivity.class));

			break;
		case R.id.layoutNotificationSound:
			ConfigData.soundType = 2;

			startActivity(new Intent(getApplicationContext(),
					PlaySoundActivity.class));

			break;
		case R.id.layoutMicrophone:

			break;

		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {
		if (ConfigData.isTestAll) {
			startActivity(new Intent(getApplicationContext(),
					VibrationActivity.class));
		}
		super.onDestroy();
	}
}
