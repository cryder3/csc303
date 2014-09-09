package edu.elon.cs.mobile.challenge1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PasswordActivity extends Activity {
	TextView pass;
	String mPassword;
	public static final String PASSWORD = "thePassword";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        pass = (TextView)findViewById(R.id.correct_password);
        mPassword = getIntent().getStringExtra(PASSWORD);
        pass.setText("The password was "+ mPassword);
        
    }

}
