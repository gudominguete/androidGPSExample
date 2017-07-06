package br.ufla.lemaf.gps;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_FINE_LOCATION = 1;
    private static String[] PERMISSIONS_FINE_LOCATION = {Manifest.permission.ACCESS_FINE_LOCATION};
    private static final int REQUEST_COARSE_LOCATION = 1;
    private static String[] PERMISSIONS_COARSE_LOCATION = {Manifest.permission.ACCESS_COARSE_LOCATION};
    private double longitude;
    private double latitude;

    GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpsTracker = new GPSTracker(this);
    }

    public void atualizarGPS(View view) {

        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_FINE_LOCATION,
                    REQUEST_FINE_LOCATION
            );
        }

        //Location location = gpsTracker.getLocation();
        latitude = gpsTracker.getLatitude();
        longitude = gpsTracker.getLongitude();

        TextView longitudeValorView = (TextView) findViewById(R.id.longitude_value);
        TextView latitudeValorView = (TextView) findViewById(R.id.latitude_value);

        latitudeValorView.setText("" + latitude);
        longitudeValorView.setText("" + longitude);

    }




}
