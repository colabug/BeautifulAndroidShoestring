package com.colabug.chiuki;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;

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

        // Set typeface on button
        Button button = (Button) findViewById( R.id.button );
        Typeface typeface = Typeface.createFromAsset( getAssets(), "Chunkfive.otf" );
        button.setTypeface( typeface );
    }
}
