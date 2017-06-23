package com.example.helloandroid;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 使用自定义字体
 * @author Administrator
 *
 */
public class CustomFontActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.custom_font_activity);
		
		Typeface fontFace = Typeface.createFromAsset(getAssets(),
                "DS-DIGIB.TTF");
		
		TextView tvHello = (TextView)findViewById(R.id.tv_title);
		tvHello.setText("13");
		
		tvHello.setTypeface(fontFace);
		
	}
}
