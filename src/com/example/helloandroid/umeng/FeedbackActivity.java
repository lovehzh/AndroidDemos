package com.example.helloandroid.umeng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloandroid.R;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.fragment.FeedbackFragment;
import com.umeng.message.PushAgent;

public class FeedbackActivity extends FragmentActivity{
	FeedbackAgent fb;
	private static final String TAG = FeedbackActivity.class.getName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		if (savedInstanceState == null) {
//          getFragmentManager().beginTransaction()
//                  .add(R.id.container, new PlaceholderFragment())
//                  .commit();
          getSupportFragmentManager().beginTransaction()
                  .add(R.id.container, new PlaceholderFragment())
                  .commit();
      }
      com.umeng.fb.util.Log.LOG = true;
      setUpUmengFeedback();
	}
	
	private void setUpUmengFeedback() {
        fb = new FeedbackAgent(this);
        // check if the app developer has replied to the feedback or not.
        fb.sync();
        fb.openAudioFeedback();
        fb.openFeedbackPush();
        PushAgent.getInstance(this).setDebugMode(true);
        PushAgent.getInstance(this).enable();

		//fb.setWelcomeInfo();
        //  fb.setWelcomeInfo("Welcome to use umeng feedback app");
//        FeedbackPush.getInstance(this).init(true);
//        PushAgent.getInstance(this).setPushIntentServiceClass(MyPushIntentService.class);


        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = fb.updateUserInfo();
            }
        }).start();
    }
	
	/**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_main, container, false);

            root.findViewById(R.id.fb_fragment_activity_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), ConversationDetailActivity.class);
                    String id = new FeedbackAgent(getActivity()).getDefaultConversation().getId();
                    intent.putExtra(FeedbackFragment.BUNDLE_KEY_CONVERSATION_ID, id);
                    startActivity(intent);
                	
                }
            });

            root.findViewById(R.id.fb_help_activity_btn).setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new FeedbackAgent(getActivity()).startFeedbackActivity2();
                }
            });
            root.findViewById(R.id.sdk_fb_activity_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new FeedbackAgent(getActivity()).startFeedbackActivity();
                }
            });
            root.findViewById(R.id.multi_conversation_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), ConversationListActivity.class);
                    startActivity(intent);
                }
            });


            return root;
        }
    }
}
