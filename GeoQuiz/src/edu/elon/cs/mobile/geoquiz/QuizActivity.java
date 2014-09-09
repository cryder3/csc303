package edu.elon.cs.mobile.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private Button mCheatButton;
	
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_mideast, false),
			new TrueFalse(R.string.question_africa, false),
			new TrueFalse(R.string.question_americas, true),
			new TrueFalse(R.string.question_cake, false)
	};
	
	private int mCurrentIndex = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        
        mQuestionTextView = (TextView)findViewById(R.id.question_text);
        updateQuestion();
        
        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				checkAnswer(true);
				
			}
		});
        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				checkAnswer(false);
			}
		});
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;
				updateQuestion();
				
			}
		});
        
        //cheat button...how dumb are you? 
        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(QuizActivity.this, CheatActivity.class);
				boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
				i.putExtra(CheatActivity.ANSWER, answerIsTrue);
				startActivity(i);
			}
		});
    }
    
    private void checkAnswer(boolean userPressedTrue){
    	boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
    	
    	int messageResId = 0;
    	if(userPressedTrue == answerIsTrue){
    		messageResId = R.string.correct_toast;
    	}
    	else{
    		messageResId = R.string.incorrect_toast;
    	}
    	Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
    }
    private void updateQuestion(){
    	int question = mQuestionBank[mCurrentIndex].getQuestion();
    	mQuestionTextView.setText(question);
    }
}
