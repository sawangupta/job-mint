package ekart.job_mint;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import ekart.job_mint.models.JobModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private MapView mapView = null;

    private View jobListViewContainer, buttonView;
    private Button eightHourButton, fourHourButton, singleButton;
    private SlidingUpPanelLayout slidingPaneLayout;
    private ListView jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        init();




        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setStyleUrl(Style.MAPBOX_STREETS);
//        mapView.setLatLng();
        mapView.setCenterCoordinate(new LatLng(12.9272542, 77.6327877));
//        mapView.setZoomLevel(12);
        mapView.setZoom(12);
        mapView.onCreate(savedInstanceState);
        mapView.setAccessToken(getString(R.string.mapboxtoken));
//        mapView.setZoomControlsEnabled(true);
        mapView.addMarker(new MarkerOptions()
                .position(new LatLng(12.9272542, 77.6327877))
                .title("Hello World!")
                .snippet("Welcome to my marker."));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapView.setLatLng(new LatLng(12.9272542, 77.6327877), true);
            }
        });
    }

    private void init() {
        buttonView = findViewById(R.id.buttonContainer);
        slidingPaneLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        jobListViewContainer = findViewById(R.id.dragView);
        jobList = (ListView)findViewById(R.id.jobList);
        jobList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.myDialog))
                        .setTitle("Apply at " + Constants.jobModelList8Hour.get(position).getCompanyName())
                        .setMessage(Constants.jobModelList8Hour.get(position).getDescrp())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Constants.myJobModelList8Hour.add(Constants.jobModelList8Hour.get(position));
                                Toast.makeText(getApplicationContext(),"Job added successfully",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", null)
                        .setCancelable(false)
                        .show();
            }
        });
        eightHourButton = (Button) findViewById(R.id.eightHourButton);
        eightHourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonView.setVisibility(View.GONE);
                jobList.setAdapter(new JobListAdapter(getApplicationContext(),Constants.jobModelList8Hour));
                slidingPaneLayout.setPanelHeight(getResources().getDimensionPixelSize(R.dimen.job_list_margin));

                for(JobModel jobModel : Constants.jobModelList8Hour) {
                    mapView.addMarker(new MarkerOptions()
                            .position(jobModel.getLatLng())
                            .title(jobModel.getCompanyName())
                            .snippet(jobModel.getDescrp()));
                }
            }
        });
        fourHourButton = (Button) findViewById(R.id.fourHourButton);
        singleButton = (Button) findViewById(R.id.singleButton);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, MyJobActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
