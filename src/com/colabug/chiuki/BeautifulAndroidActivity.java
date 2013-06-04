package com.colabug.chiuki;

import android.app.Activity;
import android.graphics.*;
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

        // Angled text gradient
        TextView angledGradientTextView = (TextView) findViewById( R.id.angled_gradient_text );
        angledGradientTextView.getPaint()
                              .setShader( getAngledShader(
                              angledGradientTextView ) );
    }

    private Typeface getTypefaceFromAsset()
    {
        return Typeface.createFromAsset( getAssets(), "Chunkfive.otf" );
    }

    private Shader getAngledShader( TextView angledGradientTextView )
    {
        Shader shader = new LinearGradient( 0,
                                            0,
                                            0,
                                            angledGradientTextView.getTextSize(),
                                            Color.RED,
                                            Color.BLUE,
                                            Shader.TileMode.MIRROR );
        Matrix matrix = new Matrix();
        matrix.setRotate( 45 );
        shader.setLocalMatrix( matrix );
        return shader;
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
