package ekart.job_mint;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.List;

import ekart.job_mint.models.JobModel;

/**
 * Created by shah.aagam on 25/02/16.
 */
public class Constants {

    public static List<JobModel> jobModelList8Hour = new ArrayList<JobModel>() {{
        add(new JobModel("Ekart","adasd ads ad a s asd asssssss",new LatLng(12.9272542, 77.6327877)));
        add(new JobModel("Swiggy","adasd ads ad a s asd asssssss",new LatLng(12.941844, 77.617249)));
        add(new JobModel("Blue Dart","adasd ads ad a s asd asssssss",new LatLng(12.933805, 77.632291)));
    }};


    public static List<JobModel> myJobModelList8Hour = new ArrayList<JobModel>();

    public static List<JobModel> jobModelList8HourAdmin = new ArrayList<JobModel>() {{
        add(new JobModel("E-Kart","Delivery Boy for 8 hours",new LatLng(12.9272542, 77.6327877)));
        add(new JobModel("E-Kart","Mother Hub Sorter",new LatLng(12.9272542, 77.6327877)));
    }};


 }
