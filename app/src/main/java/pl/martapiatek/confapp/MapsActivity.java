package pl.martapiatek.confapp;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btnNavigation, btnBuildingPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btnNavigation = (Button) findViewById(R.id.btnNavigation);
        btnNavigation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    Uri gmmIntentUri = Uri.parse("google.navigation:q=Politechnika+Wrocławska,+Wrocław+Polska");
                   Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                 mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        btnBuildingPlan = (Button) findViewById(R.id.btnBuildingPlan);
        btnBuildingPlan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MapsActivity.this,PlanActivity.class);
                startActivity(myIntent);
            }
        });




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

        // Add a marker in Sydney and move the camera
        LatLng pwr = new LatLng(51.107138, 17.062453);
        mMap.addMarker(new MarkerOptions().position(pwr).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pwr));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pwr,16));



    }
}
