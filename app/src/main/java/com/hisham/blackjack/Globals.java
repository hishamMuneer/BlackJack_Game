package com.hisham.blackjack;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Hisham on 6/30/2015.
 */
public class Globals {

    public final static String applicationId = "Lrz2nAw2fts8wWrwpYMaHWx2Ds9nFuK7Dym6pIjG";
    public final static String clientKey = "pyazIcfiUoemJbGvqb3iRRUns7MRXNuvMEK384Ks";

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else
            return false;
    }


}
