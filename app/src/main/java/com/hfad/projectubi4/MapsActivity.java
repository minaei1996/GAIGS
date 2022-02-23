package com.hfad.projectubi4;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.content.ContextCompat;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        URL url = null;
//        try {
//            url = new URL("\n" +
//                    "https://drive.google.com/u/0/uc?id=1aifvWTwfYJiEkA71sOEWHYOrb9v99z6e&export=download");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            Scanner s = new Scanner(url.openStream());
//            Log.i("response",s.nextLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
        mMap = googleMap;

        // Add a marker in Tehran ps 1 and move the camera
        LatLng ps1 = new LatLng(35.700923, 51.383320);
        LatLng ps2 = new LatLng(35.696494, 51.387251);
        LatLng ps3 = new LatLng(35.705234, 51.390335);
        LatLng ps4 = new LatLng(35.701147, 51.394218);
        mMap.addMarker(new MarkerOptions().position(ps1).title("gas station 1").icon(BitmapFromVector(getApplicationContext(),R.drawable.white_station3)));
        mMap.addMarker(new MarkerOptions().position(ps2).title("gas station 2").icon(BitmapFromVector(getApplicationContext(),R.drawable.white_station3)));
        mMap.addMarker(new MarkerOptions().position(ps3).title("gas station 3").icon(BitmapFromVector(getApplicationContext(),R.drawable.white_station3)));
        mMap.addMarker(new MarkerOptions().position(ps4).title("gas station 4").icon(BitmapFromVector(getApplicationContext(),R.drawable.white_station3)));



        mMap.moveCamera(CameraUpdateFactory.newLatLng(ps1));
    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}