package com.iignite.hackit;

//import com.iignite.hackit.DisplayMessageActivity;
import com.iignite.hackit.MainActivity;
import com.iignite.hackit.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String EXTRA_MESSAGE = "com.iigniteus.hicc.MESSAGE";;

	@Override
    public void onCreate(Bundle savedInstanceState) {
				
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView answer = (TextView) findViewById(R.id.textView1);
        final EditText username = (EditText) findViewById(R.id.editText1);
        //TextView password = (TextView) findViewById(R.id.editText1);
        Button updateText = (Button) findViewById(R.id.button1);
        Button newAccount = (Button) findViewById(R.id.button2);
        updateText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean logedin = false;
				String returnString = "";
				if (username.getText().toString().equals("bbdude95") || username.getText().toString().equals(""))// && password.getText() == "")
				{
					returnString = "Login successful";
					logedin  = true;
				}
				else
					returnString = "Login Failed!";
				answer.setText(returnString);
				//answer.setText(username.getText());
				if (logedin)
				{
					//Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
					
					String message = username.getText().toString();
					Bundle b = new Bundle();
					b.putString(MainActivity.EXTRA_MESSAGE, message);
					Intent nextActivity = new Intent(MainActivity.this, MainMenu.class); 
					nextActivity.putExtras(b);
					//intent.putExtra(EXTRA_MESSAGE, message);
					
					startActivity(nextActivity);
				}
			}
		});
        newAccount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context context = MainActivity.this;
				SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putInt(context.getResources().getString(R.string.hacking), 0);
				editor.putInt(context.getResources().getString(R.string.gatherintel), 0);
				editor.commit();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

