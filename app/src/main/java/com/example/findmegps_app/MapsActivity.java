package com.example.findmegps_app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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

        //Change exibition the map
        mMap.setMapType( GoogleMap.MAP_TYPE_NORMAL);
        // Add a marker in IBM and move the camera
            LatLng IBM = new LatLng(43.649698, -79.396189);
        //Add the títle of the locate

        //Adicionando evento de clique no mapa
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this,
                        "onClick Lat: " + latitude + "long: " + longitude,
                        Toast.LENGTH_SHORT).show();


                mMap.addMarker(
                        new MarkerOptions()
                                .position( latLng )
                                .title("IBM")
                                .snippet("Descricao")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map))
                );

            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {

                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this,
                        "onLong Lat: " + latitude + "long: " + longitude,
                        Toast.LENGTH_SHORT).show();


                mMap.addMarker(
                        new MarkerOptions()
                                .position( latLng )
                                .title("IBM")
                                .snippet("Descricao")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map))
                );
            }
        });

        mMap.addMarker(
                new MarkerOptions()
                        .position( IBM )
                        .title("IBM")
                        /*.icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
                        )*/
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map))
        );
        //Zoom da câmera
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(IBM, 2)
        );
    }
}
