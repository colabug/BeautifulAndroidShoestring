package com.colabug.chiuki;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BeautifulTextActivity extends Activity
{
    private static final String CUSTOM_FONT_FILE = "KaushanScriptRegular.otf";

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.text );

        setCustomTypeface();
        setTextGradient();
        setAngledTextGradient();
        configureIconButton();
    }

    private void configureIconButton()
    {
        View button = findViewById( R.id.icon_button );
        button.setOnClickListener( new View.OnClickListener()
            {
                @Override
                public void onClick( View view )
                {
                    startIconActivity();
                }
            }
        );
    }

    private void startIconActivity()
    {
        this.startActivity( BeautifulIconsActivity.createIntent( this ) );
    }

    private void setCustomTypeface()
    {
        TextView textView = (TextView) findViewById( R.id.custom_font_text_view );
        textView.setTypeface( getTypefaceFromAsset() );
    }

    private Typeface getTypefaceFromAsset()
    {
        return Typeface.createFromAsset( getAssets(), CUSTOM_FONT_FILE );
    }

    private void setTextGradient()
    {
        TextView gradientTextView = (TextView) findViewById( R.id.gradient_text );
        addGradientToTextView( gradientTextView );
    }

    private void setAngledTextGradient()
    {
        TextView angledGradientTextView = (TextView) findViewById( R.id.angled_gradient_text );
        addAngledGradientToTextView( angledGradientTextView );
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

    public static Intent createIntent( Context context )
    {
        return new Intent( context, BeautifulTextActivity.class );
    }
}
