package com.example.helloandroid.fragment_data;

/*
 * $filename: MyFragment.java,v $
 * $Date: 2014-5-16  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.helloandroid.MainActivity;
import com.example.helloandroid.R;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-5-16  Nanjing,njupt,China
 */
public class MyFragment1 extends Fragment {
	
	FragmentCallBack fragmentCallBack = null;
	Button btn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment1, container,
				false);
		btn = (Button)rootView.findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fragmentCallBack.callbackFun1(null);
			}
		});
		return rootView;
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		fragmentCallBack = (FragmentDateActivity)activity;
	}
}
