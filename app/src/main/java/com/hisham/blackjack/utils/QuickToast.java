package com.hisham.blackjack.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hisham.blackjack.R;

public class QuickToast {

    private static ToastDuration mDuration;
    private final LayoutInflater inflater;
    private final View inflatedView;

    /**
     * An enum with custom values is defined like this
     */
    public enum ToastDuration {
        SHORT(0), LONG(1);
        private int value;
        private ToastDuration(int value) {
            this.value = value;
        }
    }

    private static Context mContext;

    public QuickToast(Context context, ToastDuration duration){ //}, ViewGroup parent){
        mContext = context;
        mDuration = duration;
        // get layout inflater
        inflater = LayoutInflater.from(mContext);
        // get the desired layout for toast
        inflatedView = inflater.inflate(R.layout.layout_toast, null);//  parent);
    }
    public static void displayToast(Context c, String text, int duration) {
        Toast.makeText(c, text, duration).show();
    }
 
    public static void displayToast(Context c, int id, int duration) {
        Toast.makeText(c, id, duration).show();
    }
 
    public static void displayToast(Context c, String text, int duration, int gravity) {
        Toast t = Toast.makeText(c, text, duration);
        t.setGravity(gravity, 0, 0);
        t.show();
    }
 
    public static void displayToast(Context c, String text, int duration, int gravity, int[] offset) {
        Toast t = Toast.makeText(c, text, duration);
        t.setGravity(gravity, offset[0], offset[1]);
        t.show();
    }
 
    public void displayToastFromResource(String title, String message) {

        // get image view control
       // ImageView ivIcon = (ImageView)view.findViewById(R.id.ivIcon);
        // set icon to image view
       // ivIcon.setImageResource(R.drawable.icon);
        // get title text view
        TextView tvTitle = (TextView) inflatedView.findViewById(R.id.tvTitle);
        // set title content
        tvTitle.setText(title);
        // get description text view
        TextView tvDesc = (TextView) inflatedView.findViewById(R.id.tvDesc);
        // set description content
        tvDesc.setText(message);
 
        // create toast from context
        Toast t = new Toast(mContext);
        // set center
        t.setGravity(Gravity.CENTER, 0, 0);
        // set display duration
        t.setDuration(mDuration.value);
        // set view layout to toast
        t.setView(inflatedView);
        // display toast message
        t.show();
    }
}