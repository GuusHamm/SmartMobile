package org.fhict.csi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

@SuppressLint("InflateParams")  // See: https://code.google.com/p/android-developer-preview/issues/detail?id=1203
public class CrimeListAdapter extends ArrayAdapter<Crime> {

	private Context context;
	private List<Crime> crimes;

	public CrimeListAdapter(Context context, List<Crime> crimes) {
		super(context, R.layout.criminallistitem, crimes);

		this.context = context;
		this.crimes = crimes;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Crime crime = crimes.get(position);

		View view = convertView;

		if(view == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view  = inflater.inflate(R.layout.crimelistitem, null);
		}


		TextView textView = (TextView) view.findViewById(R.id.crimeName);
		textView.setText(crime.name);

		textView = (TextView) view.findViewById(R.id.crimeBounty);
		textView.setText(String.valueOf(String.valueOf(crime.bountyInDollars)));

		textView = (TextView) view.findViewById(R.id.crimeDescription);
		textView.setText(String.valueOf(crime.description));

		return view;
	}

}
