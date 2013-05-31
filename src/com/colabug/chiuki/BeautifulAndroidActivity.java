package com.colabug.chiuki;

import android.app.Activity;
import android.os.Bundle;

public class BeautifulAndroidActivity extends Activity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );
    }
}
