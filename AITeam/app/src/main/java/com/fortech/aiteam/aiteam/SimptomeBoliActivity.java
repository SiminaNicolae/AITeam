package com.fortech.aiteam.aiteam;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortech.aiteam.aiteam.model.Diseases;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 9/4/2015.
 */
public class SimptomeBoliActivity extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Ou87H1hk6IKbI6Nm8gDrts56o6vjfHagXBQDfXZS", "KKwhLiOG0mm7St1QbHCLhoRhRLo4qwt5N7yvDKFt");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Diseases");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {
                List<Diseases> diseasesList = new ArrayList<Diseases>();

                for (ParseObject diseases : list) {
                    Diseases obj = new Diseases();

                    obj.setName((String) diseases.get("name"));
                    obj.setIdDiseases((Integer) diseases.get("idDisease"));
                    obj.setTreatment((String) diseases.get("treatment"));

                    diseasesList.add(obj);
                }

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.simptome_boli_layout, container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
