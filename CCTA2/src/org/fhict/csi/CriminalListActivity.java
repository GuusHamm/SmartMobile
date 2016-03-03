package org.fhict.csi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

		final String[] criminals = getResources().getStringArray(R.array.names);
		criminalList.setAdapter(new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1,
				criminals
				));

		criminalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String name = criminals[position];

				Intent intent = new Intent(getApplicationContext(), CCTAActivity.class).putExtra("CriminalName",name);
				startActivity(intent);
			}
		});

	}
}