package ekart.job_mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mapbox.mapboxsdk.geometry.LatLng;

import ekart.job_mint.models.JobModel;

public class CreateJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Post a New Job");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button postJobButton = (Button) findViewById(R.id.btn_submit_new_job);
        postJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText company_text = (EditText) findViewById(R.id.job_company_name_text);
                EditText desc_text = (EditText) findViewById(R.id.job_desc_text);
                Constants.jobModelList8HourAdmin.add(new JobModel(company_text.getText().toString(), desc_text.getText().toString(),
                        new LatLng(12.9272542, 77.6327877)));
                CreateJob.this.finish();
            }
        });
    }

}
