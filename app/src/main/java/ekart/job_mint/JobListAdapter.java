package ekart.job_mint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ekart.job_mint.models.JobModel;

/**
 * Created by shah.aagam on 25/02/16.
 */
public class JobListAdapter extends ArrayAdapter<JobModel> {

    private List<JobModel> jobModels;
    private  Context context;
    private  LayoutInflater inflater;


    public JobListAdapter(Context context, List<JobModel> objects) {
        super(context, -1, objects);
        this.context = context;
        this.jobModels = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = inflater.inflate(R.layout.job_list_item, parent, false);
        TextView brandView = (TextView) rowView.findViewById(R.id.brand);
        TextView descrView = (TextView) rowView.findViewById(R.id.descr);
        JobModel jobModel = jobModels.get(position);
        brandView.setText(jobModel.getCompanyName());
        descrView.setText(jobModel.getDescrp());
        return rowView;
    }
}
