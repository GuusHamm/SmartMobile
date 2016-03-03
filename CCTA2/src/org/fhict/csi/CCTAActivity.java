package org.fhict.csi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CCTAActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView criminalNameTextView = (TextView) findViewById(R.id.nameValue);

		criminalNameTextView.setText(getIntent().getStringExtra("CriminalName"));

		Button reportButton = (Button) findViewById(R.id.reportButton);

		reportButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
				startActivity(intent);

			}
		});
	}
}
