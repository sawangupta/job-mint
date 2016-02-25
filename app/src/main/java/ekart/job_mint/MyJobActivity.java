package ekart.job_mint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyJobActivity extends AppCompatActivity {

    private TextView title, descr;
    private RadioButton started, done;
    private boolean startedJob = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_job);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My Job");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        title = (TextView) findViewById(R.id.jobTitle);
        descr = (TextView) findViewById(R.id.jobDescr);

        title.setText(Constants.myJobModelList8Hour.get(0).getCompanyName());
        descr.setText(Constants.myJobModelList8Hour.get(0).getDescrp());

        final Button complete = (Button) findViewById(R.id.complete);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!startedJob) {
                    startedJob = true;
                    ((RadioButton) findViewById(R.id.jodStarted)).setChecked(true);
                    complete.setText("Complete Job");
                } else {
                    ((RadioButton) findViewById(R.id.jobDone)).setChecked(true);
                    complete.setVisibility(View.GONE);

                    new AlertDialog.Builder(new ContextThemeWrapper(MyJobActivity.this, R.style.myDialog))
                            .setTitle("Job completed")
                            .setMessage("Congrats on completion of your job. Your payment will be done after confirmation from the" +
                                    " vendor")
                            .setPositiveButton("OK", null)
                            .setCancelable(false)
                            .show();
                }
            }
        });
    }

}
