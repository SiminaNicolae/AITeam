package com.fortech.aiteam.aiteam.presentation;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.fortech.aiteam.aiteam.R;
import com.fortech.aiteam.aiteam.adapters.ChooseSymptomAdapter;
import com.fortech.aiteam.aiteam.callbacks.SymptomSelectionListener;
import com.fortech.aiteam.aiteam.model.Disease;
import com.fortech.aiteam.aiteam.model.Symptom;
import com.fortech.aiteam.aiteam.model.DiseasesSymptoms;
import com.fortech.aiteam.aiteam.presentation.PosibileBoliActivity;
import com.google.gson.Gson;
import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 9/4/2015.
 */
public class SimptomeBoliActivity extends Fragment implements SymptomSelectionListener {
    private List<Symptom> mSymptomList = new ArrayList<>();
    private List<Symptom> mSelectedSymptomList = new ArrayList<>();
    private List<Disease> mDiseaseList = new ArrayList<>();
    private List<Disease> mProbableDiseases = new ArrayList<>();
    private List<DiseasesSymptoms> mDiseasesSymptomsList = new ArrayList<>();
    private ChooseSymptomAdapter mAdapter;
    private Button mContinueButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fetchDiseasesList();

        fetchSymptomsList();

        fetchDiseasesSymptomsList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.simptome_boli_layout,
                container, false);

        mContinueButton = (Button) view.findViewById(R.id.continue_button);
        ListView symptomsListView = (ListView) view.findViewById(R.id.listaboli);

        mAdapter = new ChooseSymptomAdapter(getActivity(), mSymptomList, this);
        symptomsListView.setAdapter(mAdapter);

        continueButtonPressListener();

        return view;
    }

    private void continueButtonPressListener() {
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedSymptomList.clear();
                mProbableDiseases.clear();

                for (Symptom symptom : mSymptomList) {
                    if (symptom.isSelected()) {
                        mSelectedSymptomList.add(symptom);
                    }
                }

                for (Symptom symptom : mSelectedSymptomList) {
                    for (DiseasesSymptoms diseasesSymptoms : mDiseasesSymptomsList) {
                        if (diseasesSymptoms.getIdSymptom() == symptom.getIdSymptom()) {
                            Disease disease = findDiseaseById(diseasesSymptoms.getIdDisease());
                            if (!mProbableDiseases.contains(disease)) {
                                mProbableDiseases.add(disease);
                            }
                        }
                    }
                }

                Intent intent = new Intent(getActivity(), PosibileBoliActivity.class);
                String listSerializedToJson = new Gson().toJson(mProbableDiseases);
                intent.putExtra("ListaBoli", listSerializedToJson);
                startActivity(intent);
            }
        });
    }

    private Disease findDiseaseById(int idDisease) {
        for (Disease disease : mDiseaseList) {
            if (disease.getIdDisease() == idDisease) {
                return disease;
            }
        }

        return null;
    }

    private void fetchDiseasesSymptomsList() {
        ParseQuery<ParseObject> query3 = ParseQuery.getQuery("DiseasesSymptoms");
        query3.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {

                for (ParseObject diseaseSymptom : list) {
                    DiseasesSymptoms obj = new DiseasesSymptoms();

                    obj.setIdSymptom((Integer) diseaseSymptom.get("idSymptom"));
                    obj.setIdDisease((Integer) diseaseSymptom.get("idDisease"));

                    mDiseasesSymptomsList.add(obj);
                }

                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void fetchSymptomsList() {
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

    private void fetchDiseasesList() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Diseases");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {

                for (ParseObject diseases : list) {
                    Disease obj = new Disease();

                    obj.setName((String) diseases.get("name"));
                    obj.setIdDisease((Integer) diseases.get("idDisease"));
                    obj.setTreatment((String) diseases.get("treatment"));

                    mDiseaseList.add(obj);
                }

            }
        });
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
