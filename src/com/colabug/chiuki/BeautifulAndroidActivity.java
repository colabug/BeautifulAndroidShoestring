package com.colabug.chiuki;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BeautifulAndroidActivity extends Activity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        View button = findViewById( R.id.text_button );
        button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                startTextActivity();
            }
        } );
    }

    private void startTextActivity()
    {
        this.startActivity( BeautifulTextActivity.createIntent( this ) );
    }
}
