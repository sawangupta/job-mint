package ekart.job_mint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class JobCreatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_creator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Job Creation");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView lv = (ListView) findViewById(R.id.listview_admin_job_list) ;

        lv.setAdapter(new JobListAdapter(getApplicationContext(),Constants.jobModelList8HourAdmin));

        Button postJobButton = (Button) findViewById(R.id.post_job_btn);
        postJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JobCreatorActivity.this, CreateJob.class);
                JobCreatorActivity.this.startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ListView lv = (ListView) findViewById(R.id.listview_admin_job_list) ;
        lv.setAdapter(new JobListAdapter(getApplicationContext(),Constants.jobModelList8HourAdmin));

    }

}
