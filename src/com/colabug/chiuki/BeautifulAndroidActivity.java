package com.colabug.chiuki;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BeautifulAndroidActivity extends Activity
{
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
        addGradientToTextView( gradientTextView );

        // Angled text gradient
        TextView angledGradientTextView = (TextView) findViewById( R.id.angled_gradient_text );
        addAngledGradientToTextView( angledGradientTextView );
    }

    private Typeface getTypefaceFromAsset()
    {
        return Typeface.createFromAsset( getAssets(), "Chunkfive.otf" );
    }

    private void addGradientToTextView( TextView textView )
    {
        textView.getPaint().setShader( getGradientShader( textView ) );
    }

    private void addAngledGradientToTextView( TextView textView )
    {
        textView.getPaint().setShader( getAngledGradientShader( textView ) );
    }

    private Shader getGradientShader( TextView textView )
    {
        return getShader( textView, Shader.TileMode.CLAMP );
    }

    private Shader getAngledGradientShader( TextView textView )
    {
        Shader shader = getShader( textView, Shader.TileMode.MIRROR );
        shader = addMatrixToShader( shader );
        return shader;
    }

    private Shader getShader( TextView textView, Shader.TileMode tileMode )
    {
        return new LinearGradient( 0, 0, 0,
                                   textView.getTextSize(),
                                   Color.RED, Color.BLUE,
                                   tileMode );
    }

    private Shader addMatrixToShader( Shader shader )
    {
        Matrix matrix = new Matrix();
        matrix.setRotate( 45 );
        shader.setLocalMatrix( matrix );
        return shader;
    }
}
