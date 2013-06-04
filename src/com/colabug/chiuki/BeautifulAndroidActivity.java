package com.colabug.chiuki;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
        button.setTypeface( getTypefaceFromAsset() );

        // Text gradient
        TextView gradientTextView = (TextView) findViewById( R.id.gradient_text );
        gradientTextView.getPaint()
                        .setShader( getLinearGradient( gradientTextView ) );
    }

    private Typeface getTypefaceFromAsset()
    {
        return Typeface.createFromAsset( getAssets(), "Chunkfive.otf" );
    }

    private LinearGradient getLinearGradient( TextView textView )
    {
        return new LinearGradient( 0,
                                   0,
                                   0,
                                   textView.getTextSize(),
                                   Color.RED,
                                   Color.BLUE,
                                   Shader.TileMode.CLAMP );
    }
}
