package org.fhict.csi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by GuusHamm on 3-3-2016.
 */
public class CriminalListActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.criminallist);

		ListView criminalList = (ListView) findViewById(R.id.criminalList);


		CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());
		CriminalListAdapter criminalListAdapter = new CriminalListAdapter(getApplicationContext(),criminalProvider.GetCriminals());

		criminalList.setAdapter(criminalListAdapter);

		criminalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String name = criminalProvider.GetCriminal(position).name;

				Intent intent = new Intent(getApplicationContext(), CCTAActivity.class).putExtra("index",position);
				startActivity(intent);
			}
		});

	}
}