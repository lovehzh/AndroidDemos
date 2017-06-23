package com.example.helloandroid;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity{
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		
//		findViewById(R.id.btn_success).setOnClickListener(this);
//		findViewById(R.id.btn_error).setOnClickListener(this);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.btn_success:
//			new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
//            .setTitleText("Good job!")
//            .setContentText("You clicked the button!")
//            .show();
//			break;
//			
//		case R.id.btn_error:
//			new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
//            .setTitleText("Oops...")
//            .setContentText("Something went wrong!")
//            .show();
//			break;
//
//		default:
//			break;
//		}
//		
//	}
	
	private TextView tvTitle;
	private ListView mListView;
    private String[] mData = new String[] { "xxx", "yyy", "zzz", "aaa" };
    private BaseAdapter mAdapter;
    private int mLastCorrectPosition = -1;
    private int mButtonPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String html="<html><head><title></title></head><body><p>快递箱号：10-17</p><p>快递箱号：10-17</p><p>快递箱号：10-17</p><p><font color=\"#00bbaa\">快递箱号：10-17</p></body></html>";
        tvTitle = (TextView)findViewById(R.id.tv_title);
        tvTitle.setText(Html.fromHtml(html));

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        mAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_activated_1, mData);
        mListView.setAdapter(mAdapter);
        mListView.setSelector(new ColorDrawable(0));

        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                if (position == mButtonPosition) {
                    if (mLastCorrectPosition != -1) {
                        mListView.setItemChecked(mLastCorrectPosition, true);
                    }
                    else {
                        mListView.setItemChecked(mButtonPosition, false);
                    }
                    // here show dialog
                }
                else {
                    mLastCorrectPosition = position;
                    // here refresh fragment
                }
            }
        });
    }

}
