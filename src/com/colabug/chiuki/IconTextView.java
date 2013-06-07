package com.colabug.chiuki;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class IconTextView extends TextView
{
    private static final String ICON_FONT = "icomoon.ttf";

    public IconTextView( Context context, AttributeSet attrs )
    {
        super( context, attrs );
        setTypeface( getTypefaceFromAsset() );
        setShader();
    }

    private void setShader()
    {
        Shader shader = getGrayLinearGradient( Color.LTGRAY, Color.DKGRAY );
        getPaint().setShader( shader );
    }

    private LinearGradient getGrayLinearGradient( int startColor, int endColor )
    {
        return new LinearGradient( 0, 0, 0,
                                   getTextSize(),
                                   startColor,
                                   endColor,
                                   Shader.TileMode.CLAMP );
    }

    private Typeface getTypefaceFromAsset()
    {
        return Typeface.createFromAsset( getContext().getAssets(), ICON_FONT );
    }
}
