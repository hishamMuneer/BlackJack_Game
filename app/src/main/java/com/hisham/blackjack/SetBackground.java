package com.hisham.blackjack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class SetBackground extends Activity implements OnClickListener {

	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11;

	/** Called when the activity is first created. */
	SharedPreferences prefs;
	SharedPreferences.Editor editor;
	Toast toast;
	AlphaAnimation animHigh;
	AlphaAnimation animLow;

	@SuppressWarnings("deprecation")
	@SuppressLint("ShowToast")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_background);
		setupVariables();
		// TODO Auto-generated method stub

		prefs = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		editor = prefs.edit();

		toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);

		animHigh = new AlphaAnimation(0.3f, 1.0f);
		animHigh.setDuration(800);
		animHigh.setFillAfter(true);

		animLow = new AlphaAnimation(1.0f, 0.3f);
		animLow.setDuration(800);
		animLow.setFillAfter(true);

		if (prefs.getBoolean("iv1", false)) {
			iv1.startAnimation(animHigh);
		} else {
			iv1.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv2", true)) {
			iv2.startAnimation(animHigh);
		} else {
			iv2.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv3", false)) {
			iv3.startAnimation(animHigh);
		} else {
			iv3.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv4", false)) {
			iv4.startAnimation(animHigh);
		} else {
			iv4.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv5", false)) {
			iv5.startAnimation(animHigh);
		} else {
			iv5.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv6", false)) {
			iv6.startAnimation(animHigh);
		} else {
			iv6.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv7", false)) {
			iv7.startAnimation(animHigh);
		} else {
			iv7.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv8", false)) {
			iv8.startAnimation(animHigh);
		} else {
			iv8.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv9", false)) {
			iv9.startAnimation(animHigh);
		} else {
			iv9.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv10", false)) {
			iv10.startAnimation(animHigh);
		} else {
			iv10.startAnimation(animLow);
		}
		if (prefs.getBoolean("iv11", false)) {
			iv11.startAnimation(animHigh);
		} else {
			iv11.startAnimation(animLow);
		}

	}

	private void setupVariables() {

		iv1 = (ImageView) findViewById(R.id.imageViewbg1);
		iv2 = (ImageView) findViewById(R.id.imageViewbg2);
		iv3 = (ImageView) findViewById(R.id.imageViewbg3);
		iv4 = (ImageView) findViewById(R.id.imageViewbg4);

		iv5 = (ImageView) findViewById(R.id.imageViewbg5);
		iv6 = (ImageView) findViewById(R.id.imageViewbg6);
		iv7 = (ImageView) findViewById(R.id.imageViewbg7);
		iv8 = (ImageView) findViewById(R.id.imageViewbg8);

		iv9 = (ImageView) findViewById(R.id.imageViewbg9);
		iv10 = (ImageView) findViewById(R.id.imageViewbg10);
		iv11 = (ImageView) findViewById(R.id.imageViewbg11);

		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		iv4.setOnClickListener(this);

		iv5.setOnClickListener(this);
		iv6.setOnClickListener(this);
		iv7.setOnClickListener(this);
		iv8.setOnClickListener(this);

		iv9.setOnClickListener(this);
		iv10.setOnClickListener(this);
		iv11.setOnClickListener(this);

	}

	void setTextColors(int red, int green, int blue) {
		// Text colors
		BJActivity.tvBet.setTextColor(Color.rgb(red, green, blue));
		BJActivity.tvBet.setTextColor(Color.rgb(red, green, blue));
		BJActivity.tvDealerScore.setTextColor(Color.rgb(red, green, blue));
		BJActivity.tvHighestScore.setTextColor(Color.rgb(red, green, blue));
		BJActivity.tvMoney.setTextColor(Color.rgb(red, green, blue));
		BJActivity.tvYourScore.setTextColor(Color.rgb(red, green, blue));

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.imageViewbg1:

			if (prefs.getBoolean("iv1", false)
					|| checkMoneyNUnlock(1000, iv1, "iv1")) {

				BJActivity.layout.setBackgroundResource(R.drawable.back1);
				setTextColors(255, 255, 255);
				finish();
			}

			break;
		case R.id.imageViewbg2:

			if (prefs.getBoolean("iv2", true)
					|| checkMoneyNUnlock(500, iv2, "iv2")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back2);
				setTextColors(255, 255, 255);
				finish();
			}

			break;
		case R.id.imageViewbg3:

			if (prefs.getBoolean("iv3", false)
					|| checkMoneyNUnlock(2000, iv3, "iv3")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back3);
				setTextColors(222, 14, 30);
				finish();
			}

			break;

		case R.id.imageViewbg4:

			if (prefs.getBoolean("iv4", false)
					|| checkMoneyNUnlock(3000, iv4, "iv4")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back4);
				setTextColors(0, 0, 0);
				finish();
			}

			break;

		case R.id.imageViewbg5:

			if (prefs.getBoolean("iv5", false)
					|| checkMoneyNUnlock(5000, iv5, "iv5")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back5);
				setTextColors(12, 45, 52);
				finish();
			}

			break;

		case R.id.imageViewbg6:

			if (prefs.getBoolean("iv6", false)
					|| checkMoneyNUnlock(10000, iv6, "iv6")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back6);
				setTextColors(0, 0, 0);
				finish();
			}

			break;
		case R.id.imageViewbg7:

			if (prefs.getBoolean("iv7", false)
					|| checkMoneyNUnlock(20000, iv7, "iv7")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back7);
				setTextColors(145, 0, 0);
				finish();
			}

			break;
		case R.id.imageViewbg8:

			if (prefs.getBoolean("iv8", false)
					|| checkMoneyNUnlock(50000, iv8, "iv8")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back8);
				setTextColors(0, 0, 150);
				finish();
			}

			break;
		case R.id.imageViewbg9:

			if (prefs.getBoolean("iv9", false)
					|| checkMoneyNUnlock(50000, iv9, "iv9")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back9);
				setTextColors(255, 255, 255);
				finish();
			}

			break;
		case R.id.imageViewbg10:

			if (prefs.getBoolean("iv10", false)
					|| checkMoneyNUnlock(100000, iv10, "iv10")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back10);
				setTextColors(255, 255, 255);
				finish();
			}

			break;
		case R.id.imageViewbg11:

			if (prefs.getBoolean("iv11", false)
					|| checkMoneyNUnlock(100000, iv11, "iv11")) {
				BJActivity.layout.setBackgroundResource(R.drawable.back11);
				setTextColors(255, 255, 255);
				finish();
			}

			break;

		default:
			break;
		}

	}

	@SuppressWarnings("deprecation")
	private Boolean checkMoneyNUnlock(int price, ImageView imageBack,
			String sharedPrefString) {

		if (BJActivity._money < price) {

			toast.setText("Price: $" + price + " | You need: $"
					+ (price - BJActivity._money)
					+ " more to unlock this screen.");
			toast.show();
			return false;
		} else {
			BJActivity._money -= price;
			imageBack.startAnimation(animHigh);
			editor.putBoolean(sharedPrefString, true);
			editor.commit();
			return true;
		}

	}

}
