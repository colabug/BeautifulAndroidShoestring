package com.colabug.chiuki;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class BeautifulIconsActivity extends Activity
{
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.icons );
    }

    public static Intent createIntent( Context context )
    {
        return new Intent( context, BeautifulIconsActivity.class );
    }
}
