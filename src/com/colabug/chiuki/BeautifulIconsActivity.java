package com.colabug.chiuki;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BeautifulIconsActivity extends Activity
{
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.icons );
        setUpIconClickListeners();
    }

    private void setUpIconClickListeners()
    {
        View android = findViewById( R.id.android_icon );
        android.setOnClickListener( createIconOnClickListener() );

        View camera = findViewById( R.id.camera_icon );
        camera.setOnClickListener( createIconOnClickListener() );

        View music = findViewById( R.id.music_icon );
        music.setOnClickListener( createIconOnClickListener() );

        View leaf = findViewById( R.id.leaf_icon );
        leaf.setOnClickListener( createIconOnClickListener() );
    }

    private View.OnClickListener createIconOnClickListener()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                TextView textView = (TextView) view;
                String toastText = "Icon font text: " + textView.getText();
                Toast.makeText( BeautifulIconsActivity.this,
                                toastText,
                                Toast.LENGTH_SHORT ).show();
            }
        };
    }

    public static Intent createIntent( Context context )
    {
        return new Intent( context, BeautifulIconsActivity.class );
    }
}
