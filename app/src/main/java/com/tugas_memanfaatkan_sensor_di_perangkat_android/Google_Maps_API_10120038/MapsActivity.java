package com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.Manifest;
import android.widget.TextView;

public class MapsActivity extends FragmentActivity {
    //Nim   : 10120038
    //Nama  : Randi Hardiansyah
    //Kelas : IF-1

    private GoogleMap mMap;
    ArrayList<LatLng>arrayList= new ArrayList<LatLng>();
    ArrayList<String> label = new ArrayList<>();
    LatLng Spg = new LatLng(-6.886359561542663, 107.61494006385954);
    LatLng Padang = new LatLng(-6.882874847606876, 107.61491158264347);
    LatLng Seblak = new LatLng(-6.899918149242705, 107.63822942144972);
    LatLng Warkop = new LatLng(-6.88613278039245, 107.6162159807961);
    LatLng Sukarasa = new LatLng(-6.887709408903895, 107.61541379680611);

    private SupportMapFragment supportMapFragment;
    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient fusedLocationProviderClient;

    TextView lat, lng, alamat;
    private Boolean oke = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        lat = findViewById(R.id.latmap);
        lng = findViewById(R.id.longmap);
        alamat = findViewById(R.id.alamatmap);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        arrayList.add(Spg);
        arrayList.add(Padang);
        arrayList.add(Seblak);
        arrayList.add(Warkop);
        arrayList.add(Sukarasa);

        label.add("Warung Nasi Spg DU");
        label.add("Warung Nasi Padang Bahagia");
        label.add("Si Pangsit & Seblak");
        label.add("Wakop 99");
        label.add("Sukarasa");

        getCurrentLocation();

    }

    List<Address> addressList = null;
    private void getCurrentLocation() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {

                            googleMap.getUiSettings().setZoomControlsEnabled(true);
                            googleMap.getUiSettings().setCompassEnabled(true);
                            googleMap.getUiSettings().setZoomGesturesEnabled(true);
                            googleMap.getUiSettings().setScrollGesturesEnabled(true);
                            googleMap.getUiSettings().setRotateGesturesEnabled(false);

                            googleMap.setMyLocationEnabled(true);


                            try {
                                addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                if (addressList !=null){
                                    Address returnAdd = addressList.get(0);
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int i = 0; i < returnAdd.getMaxAddressLineIndex(); i++){
                                        stringBuilder.append(returnAdd.getAddressLine(i)).append("\n");
                                    }
                                    Log.w("My location Address", stringBuilder.toString());
                                }else{
                                    Log.w("My location Address","No address!");
                                }
                            }catch (IOException e){
                                e.printStackTrace();
                            }

                            String addressLines = addressList.get(0).getAddressLine(0);

                            LatLng lokasi = new LatLng(location.getLatitude(), location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(lokasi).title(addressLines);
                            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 17));
                            googleMap.addMarker(options);

                            lat.setText(String.valueOf(location.getLatitude()));
                            lng.setText(String.valueOf(location.getLongitude()));

                            alamat.setText(addressLines);

                            for (int i=0; i<arrayList.size(); i++){
                                if (i == 0){
                                    googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Warung Nasi Spg DU"));
                                } else if (i == 1) {

                                    googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Warung Nasi Padang Bahagia"));
                                } else if (i == 2) {

                                    googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Si Pangsit & Seblak"));
                                } else if (i == 3) {

                                    googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Wakop 99"));
                                } else {

                                    googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Sukarasa"));
                                }
                                googleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
                                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                                googleMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
                            }

                        }
                    });
                }
            }
        });
    }

}
