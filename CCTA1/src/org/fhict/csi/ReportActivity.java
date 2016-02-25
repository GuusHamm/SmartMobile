package org.fhict.csi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by guushamm on 25-2-16.
 */
public class ReportActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_layout);

		Button backButton = (Button) findViewById(R.id.backButton);

		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();

			}
		});
	}
}