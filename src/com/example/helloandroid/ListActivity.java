package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.gridview.GridViewActivity;
import com.example.helloandroid.blur.BlurBehind;
import com.example.helloandroid.blur.OnBlurCompleteListener;
import com.example.helloandroid.umeng.FeedbackActivity;
import com.umeng.fb.FeedbackAgent;

public class ListActivity extends Activity implements OnClickListener{
	private Button btnGridviewDemo;
	private Button btnSpinnerDemo;
	private Button btnFeedbackDemo;
	private Button btnNumberPicker;
	private Button btnBlur;
	private Button btnCustomFont;
	
	private FeedbackAgent agent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		initComponent();
		
		agent = new FeedbackAgent(this);
		agent.sync();
	}
	
	
	private void initComponent() {
		btnGridviewDemo = (Button)findViewById(R.id.btn_gridview_demo);
		btnGridviewDemo.setOnClickListener(this);
		
		btnSpinnerDemo = (Button)findViewById(R.id.btn_spinner_demo);
		btnSpinnerDemo.setOnClickListener(this);
		
		btnFeedbackDemo = (Button)findViewById(R.id.btn_umeng_feedback_demo);
		btnFeedbackDemo.setOnClickListener(this);
		
		btnNumberPicker = (Button)findViewById(R.id.btn_number_picker);
		btnNumberPicker.setOnClickListener(this);
		
		btnBlur = (Button)findViewById(R.id.btn_blur);
		btnBlur.setOnClickListener(this);
		
		btnCustomFont = (Button)findViewById(R.id.btn_custom_font);
		btnCustomFont.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_gridview_demo:
			intent = new Intent(this, GridViewActivity.class);
			startActivity(intent);
			break;
			
		case R.id.btn_spinner_demo:
			intent = new Intent(this, SpinnerDemo.class);
			startActivity(intent);
			break;
			
		case R.id.btn_umeng_feedback_demo:
			intent = new Intent(this, FeedbackActivity.class);
			startActivity(intent);
			
//			agent.startFeedbackActivity();
			break;
			
			
		case R.id.btn_blur:
			BlurBehind.getInstance().execute(this, new OnBlurCompleteListener() {
                @Override
                public void onBlurComplete() {
                    Intent intent = new Intent(ListActivity.this, BlurActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                    startActivity(intent);
                }
            });
			break;
			
		case R.id.btn_custom_font:
			intent = new Intent(this, CustomFontActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
}
