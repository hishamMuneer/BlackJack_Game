package com.hisham.blackjack;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Hisham on 6/30/2015.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, Globals.applicationId, Globals.clientKey);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
