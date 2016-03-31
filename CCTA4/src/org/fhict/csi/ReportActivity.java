package org.fhict.csi;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by guushamm on 25-2-16.
 */
public class ReportActivity extends Activity {
	private boolean sca;
	private LocationManager locationManager;
	private LocationListener locationListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_layout);

		locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);


		CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());

		int postition = getIntent().getIntExtra("index", 0);

		Criminal criminal = criminalProvider.GetCriminal(postition);

		ImageView imageView = (ImageView) findViewById(R.id.imageView2);
		imageView.setForeground(criminal.mugshot);

		ListView criminalList = (ListView) findViewById(R.id.crimeList);

		CrimeListAdapter crimeListAdapter = new CrimeListAdapter(getApplicationContext(), criminal.crimes);

		criminalList.setAdapter(crimeListAdapter);

		Button backButton = (Button) findViewById(R.id.backButton);

		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();

			}
		});

		Button gpsButton = (Button) findViewById(R.id.gpsbutton);

		gpsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sca = !sca;

				if (sca) {
					Toast toast = Toast.makeText(getApplicationContext(),"Sca on",Toast.LENGTH_SHORT);
					toast.show();
					if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
						// TODO: Consider calling
						//    Activity#requestPermissions
						// here to request the missing permissions, and then overriding
						//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
						//                                          int[] grantResults)
						// to handle the case where the user grants the permission. See the documentation
						// for Activity#requestPermissions for more details.
						return;
					}
					Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					toast = Toast.makeText(getApplicationContext(),String.format("Your location is %s %s",location.getLongitude(),location.getLatitude()),Toast.LENGTH_SHORT);
					toast.show();
					locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 25, locationListener = new LocationListener() {
						@Override
						public void onLocationChanged(Location location) {
							if (criminal.lastKnownLocation.distanceTo(location) < 100){
								Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(VIBRATOR_SERVICE);
								vibrator.vibrate(50);
							}
						}

						@Override
						public void onStatusChanged(String provider, int status, Bundle extras) {

						}

						@Override
						public void onProviderEnabled(String provider) {

						}

						@Override
						public void onProviderDisabled(String provider) {

						}
					});
				}else {
					Toast toast = Toast.makeText(getApplicationContext(),"Sca off",Toast.LENGTH_SHORT);
					toast.show();
					locationManager.removeUpdates(locationListener);
				}
			}
		});


	}
}