package org.fhict.csi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

@SuppressLint("InflateParams")  // See: https://code.google.com/p/android-developer-preview/issues/detail?id=1203
public class CriminalListAdapter extends ArrayAdapter<Criminal> {

	private Context context;
	private List<Criminal> criminals;

	public CriminalListAdapter(Context context, List<Criminal> criminals) {
		super(context, R.layout.criminallistitem, criminals);
		
		this.context = context;
		this.criminals = criminals;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Criminal criminal = criminals.get(position);
	
		//TOOD: replace this simple view by the layout as defined in criminallistitem.xml"
		View view = convertView;

		if(view == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view  = inflater.inflate(R.layout.criminallistitem, null);
		}

		ImageView imageView = (ImageView) view.findViewById(R.id.mugShot);
		imageView.setForeground(criminal.mugshot);

		TextView textView = (TextView) view.findViewById(R.id.criminalName);
		textView.setText(criminal.name);

		textView = (TextView) view.findViewById(R.id.criminalBounty);
		textView.setText(String.valueOf(criminal.getBountyInDollars()));

		return view;
	}

}
