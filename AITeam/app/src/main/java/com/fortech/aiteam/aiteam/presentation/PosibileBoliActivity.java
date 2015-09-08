package com.fortech.aiteam.aiteam.presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fortech.aiteam.aiteam.R;
import com.fortech.aiteam.aiteam.adapters.DiseasesAdapter;
import com.fortech.aiteam.aiteam.callbacks.DiseaseSelectionListener;
import com.fortech.aiteam.aiteam.model.Disease;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PosibileBoliActivity extends Activity implements DiseaseSelectionListener {
    private List<Disease> mDiseaseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posibile_boli_layout);

        getActionBar().setTitle("Personal Assistent");
        getActionBar().setIcon(null);

        ListView listView = (ListView) this.findViewById(R.id.diseases_listView);

        String listSerializedToJson = getIntent().getExtras().getString("ListaBoli");
        mDiseaseList = new Gson().fromJson(listSerializedToJson, new TypeToken<List<Disease>>() {
        }.getType());

        final DiseasesAdapter adapter = new DiseasesAdapter(this, mDiseaseList, this);
        listView.setAdapter(adapter);
    }


    @Override
    public void onDieseaseSelected(Disease disease) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("OK", null)
                .setTitle("Tratament orientativ")
                .setMessage(disease.getTreatment());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
