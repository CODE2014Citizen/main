package com.parallelware.citizen;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.parallelware.citizen.*;

public class Splash extends Activity {

	private final int SLEEP_TIME = 5;
	private static String tag = Splash.class.getName();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Check Preferences
		if (doSplash()) {

			this.requestWindowFeature(Window.FEATURE_NO_TITLE);
			this.getWindow().setFlags(
					WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);

			setContentView(R.layout.fragment_splash);

			SplashLauncher intent = new SplashLauncher();
			intent.start();
		} else {
			NoSplashLauncher intent = new NoSplashLauncher();
			intent.start();

		}
	}

	public class SplashLauncher extends Thread {

		@Override
		public void run() {
			try {
				Thread.sleep(SLEEP_TIME * 1000);
			} catch (Exception ex) {
				Log.e(tag, ex.getMessage());
			}
			Intent mainIntent = new Intent(Splash.this, MainActivity.class);
			Splash.this.startActivity(mainIntent);
			Splash.this.finish();
		}
	}

	public class NoSplashLauncher extends Thread {

		@Override
		public void run() {
			Intent mainIntent = new Intent(Splash.this, MainActivity.class);
			Splash.this.startActivity(mainIntent);
			Splash.this.finish();
		}
	}

	private boolean doSplash() {
		boolean doSplash = true;
		SharedPreferences mySharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);

		doSplash = mySharedPreferences.getBoolean("checkbox_doSplash", true);
		return (doSplash);
	}

}