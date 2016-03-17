package org.fhict.csi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CCTAActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */

	Criminal criminal;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());

		int postition = getIntent().getIntExtra("index",0);

		criminal = criminalProvider.GetCriminal(postition);

		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		imageView.setForeground(criminal.mugshot);

		TextView textView = (TextView) findViewById(R.id.nameValue);
		textView.setText(criminal.name);

		textView = (TextView) findViewById(R.id.genderValue);
		textView.setText(criminal.gender);

		textView = (TextView) findViewById(R.id.ageValue);
		textView.setText(String.valueOf(criminal.age));

		textView = (TextView) findViewById(R.id.bountyValue);
		textView.setText(String.valueOf(criminal.getBountyInDollars()));

		textView = (TextView) findViewById(R.id.description);
		textView.setText(criminal.description);

		Button reportButton = (Button) findViewById(R.id.reportButton);

		reportButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
				intent.putExtra("index",postition);
				startActivity(intent);

			}
		});
	}
}
