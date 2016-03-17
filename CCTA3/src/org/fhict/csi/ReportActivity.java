package org.fhict.csi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by guushamm on 25-2-16.
 */
public class ReportActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_layout);


		CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());

		int postition = getIntent().getIntExtra("index",0);

		Criminal criminal = criminalProvider.GetCriminal(postition);

		ImageView imageView = (ImageView) findViewById(R.id.imageView2);
		imageView.setForeground(criminal.mugshot);

		ListView criminalList = (ListView) findViewById(R.id.crimeList);

		CrimeListAdapter crimeListAdapter = new CrimeListAdapter(getApplicationContext(),criminal.crimes);

		criminalList.setAdapter(crimeListAdapter);

		Button backButton = (Button) findViewById(R.id.backButton);

		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();

			}
		});
	}
}