package com.fortech.aiteam.aiteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fortech.aiteam.aiteam.model.Disease;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolaes on 9/8/15.
 */
public class PosibileBoliActivity extends Activity {
    private List<Disease> mDiseaseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posibile_boli_layout);

        Intent intent = getIntent();
        //mDiseaseList = intent.getParcelableArrayExtra("ListaBoli");
    }
}
