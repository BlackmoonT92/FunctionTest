package com.blackmoon.sound_test;

import com.blackmoon.functiontest.ConfigData;
import com.blackmoon.functiontest.R;

import android.app.Activity;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlaySoundActivity extends Activity implements OnClickListener {

	ImageView ivVolumeToggle;
	ImageView ivVolumeIcon;
	SeekBar sbVolumeValue;
	TextView tvTitleSound;
	Button btnDone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_detail);

		// findViewById
		findViewById();

		// setOnclick
		setOnClickListener();

		// fillData
		fillData();

	}

	private void fillData() {
		ivVolumeIcon.setImageResource(R.drawable.volume);

		switch (ConfigData.soundType) {
		case 1:
			// phone ringtone
			tvTitleSound.setText(ConfigData.titlePhone);
			try {
				ConfigData.phoneRingtone.play();
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case 2:
			// notification

			tvTitleSound.setText(ConfigData.titleNotification);
			try {
				ConfigData.notificationSound.play();
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;
		case 3:
			// alarm
			tvTitleSound.setText(ConfigData.titleAlarm);

			try {
				ConfigData.alarmSound.play();
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;

		}

	}

	private void setOnClickListener() {
		btnDone.setOnClickListener(this);
		ivVolumeToggle.setOnClickListener(this);

	}

	public void findViewById() {
		ivVolumeToggle = (ImageView) findViewById(R.id.ivVolumeToggle);
		ivVolumeIcon = (ImageView) findViewById(R.id.ivVolumeIcon);
		tvTitleSound = (TextView) findViewById(R.id.tvTitleSound);
		sbVolumeValue = (SeekBar) findViewById(R.id.sbVolumeValue);
		btnDone = (Button) findViewById(R.id.btnSoundDone);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSoundDone:

			finish();

		case R.id.ivVolumeToggle:
			try {

				switch (ConfigData.soundType) {
				case 1:
					// phone ringtone
					if (ConfigData.phoneRingtone.isPlaying()) {
						ConfigData.phoneRingtone.stop();
						ivVolumeIcon.setImageResource(R.drawable.mute);
					} else {
						ConfigData.phoneRingtone.play();
						ivVolumeIcon.setImageResource(R.drawable.volume);

					}

					break;
				case 2:
					// notification
					if (ConfigData.notificationSound.isPlaying()) {
						ConfigData.notificationSound.stop();
						ivVolumeIcon.setImageResource(R.drawable.mute);

					} else {
						ConfigData.notificationSound.play();
						ivVolumeIcon.setImageResource(R.drawable.volume);

					}
					break;
				case 3:
					// alarm
					if (ConfigData.alarmSound.isPlaying()) {
						ConfigData.alarmSound.stop();
						ivVolumeIcon.setImageResource(R.drawable.mute);

					} else {
						ConfigData.alarmSound.play();
						ivVolumeIcon.setImageResource(R.drawable.volume);

					}
					break;

				}
				break;

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	protected void onPause() {
		try {
			ConfigData.phoneRingtone.stop();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		try {
			ConfigData.notificationSound.stop();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		try {
			ConfigData.alarmSound.stop();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		fillData();
		super.onResume();
	}

}
