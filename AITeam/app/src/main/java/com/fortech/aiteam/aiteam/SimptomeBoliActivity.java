package com.fortech.aiteam.aiteam;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fortech.aiteam.aiteam.callbacks.SymptomSelectionListener;
import com.fortech.aiteam.aiteam.model.Diseases;
import com.fortech.aiteam.aiteam.model.Symptom;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 9/4/2015.
 */
public class SimptomeBoliActivity extends Fragment implements SymptomSelectionListener {
    private List<Symptom> mSymptomList = new ArrayList<>();
    private ChooseSymptomAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.enableLocalDatastore(getActivity());
        Parse.initialize(getActivity(), "Ou87H1hk6IKbI6Nm8gDrts56o6vjfHagXBQDfXZS", "KKwhLiOG0mm7St1QbHCLhoRhRLo4qwt5N7yvDKFt");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Diseases");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {
                List<Diseases> diseasesList = new ArrayList<>();

                for (ParseObject diseases : list) {
                    Diseases obj = new Diseases();

                    obj.setName((String) diseases.get("name"));
                    obj.setIdDiseases((Integer) diseases.get("idDisease"));
                    obj.setTreatment((String) diseases.get("treatment"));

                    diseasesList.add(obj);
                }

            }
        });

        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Symptoms");
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {

                for (ParseObject symptom : list) {
                    Symptom obj = new Symptom();

                    obj.setName((String) symptom.get("name"));
                    obj.setIdSymptom((Integer) symptom.get("idSymptom"));

                    mSymptomList.add(obj);
                }

                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.simptome_boli_layout,
                container, false);

        ListView symptomsListView = (ListView) view.findViewById(R.id.listaboli);

        mAdapter = new ChooseSymptomAdapter(getActivity(), mSymptomList, this);
        symptomsListView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onSymptomSelected(int simptomId) {
        for (Symptom symptom : mSymptomList) {
            if (symptom.getIdSymptom() == simptomId) {
                symptom.setSelected(!symptom.isSelected());
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
