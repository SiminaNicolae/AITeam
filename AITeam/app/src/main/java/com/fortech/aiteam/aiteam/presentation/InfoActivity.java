package com.fortech.aiteam.aiteam.presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fortech.aiteam.aiteam.R;

/**
 * Created by Andrei on 9/7/2015.
 */
public class InfoActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.info_layout,
                container, false);
        return view;
    }
}
