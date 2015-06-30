package com.hisham.blackjack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;

public class Ladies extends Activity {

	Gallery galLadies;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.ladies);
	    
	    galLadies = (Gallery)findViewById(R.id.galLadies);
	    
	    
	    //galLadies.	
	    // TODO Auto-generated method stub
	}

}
