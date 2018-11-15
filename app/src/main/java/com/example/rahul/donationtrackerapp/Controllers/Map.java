package com.example.rahul.donationtrackerapp.Controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.example.rahul.donationtrackerapp.Model.Location;
import com.example.rahul.donationtrackerapp.Model.Model;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Adds map functionality to the app. All donation locations are added to the map and displayed
 * as pins. The user has the option to select a pin and view additional location details.
 */
public class Map extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        FragmentManager fragManager = getSupportFragmentManager();

        SupportMapFragment mapFragment = (SupportMapFragment) fragManager
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        //Objects.requireNonNull(mapFragment).getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);

        List<Location> locations = Model.INSTANCE.getLocations();

        for (Location location: locations) {
            LatLng coordinates = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions marker = new MarkerOptions();
            marker.position(coordinates);
            marker.title(location.getName());
            marker.snippet("Phone number: " + location.getPhone());

            googleMap.addMarker(marker);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates));
        }
    }

}
