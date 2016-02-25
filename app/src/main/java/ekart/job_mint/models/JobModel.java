package ekart.job_mint.models;

import com.mapbox.mapboxsdk.geometry.LatLng;

/**
 * Created by shah.aagam on 25/02/16.
 */
public class JobModel {
    private String companyName;
    private LatLng latLng;
    private String descrp;

    public JobModel(String companyName,  String descrp, LatLng latLng) {
        this.companyName = companyName;
        this.latLng = latLng;
        this.descrp = descrp;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public String getDescrp() {
        return descrp;
    }
}
