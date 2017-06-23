package com.example.helloandroid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.example.helloandroid.blur.BlurBehind;

public class BlurActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.blur_activity);
		
		BlurBehind.getInstance()//在你需要添加模糊或者透明的背景中只需要设置这几行简单的代码就可以了
        .withAlpha(50)
        .withFilterColor(Color.parseColor("#ffffff"))
        .setBackground(this);
	}
}
