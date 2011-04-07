package myactivity.activity01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Activity_01 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		TextView tv = (TextView) findViewById(R.id.myTextView);
		tv.setText("my first text view");
		Button bt1 = (Button) findViewById(R.id.myButton1);
		bt1.setText("my first button");

	}
}