package edu.elon.cs.mobile.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends Activity {
	
	private Button mShowButton;
	private TextView mAnswerText;
	public static final String ANSWER = "theAnswer";
	
	private boolean mAnswerIsTrue;
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_cheat);
	        mAnswerIsTrue = getIntent().getBooleanExtra(ANSWER, false);
	        mAnswerText = (TextView)findViewById(R.id.answer);
	        mShowButton = (Button)findViewById(R.id.show_button);
	        mShowButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					mAnswerText.setText(mAnswerIsTrue + "");
				}
			});
	 }

}
