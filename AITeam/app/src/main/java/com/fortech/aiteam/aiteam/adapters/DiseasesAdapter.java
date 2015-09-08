package com.fortech.aiteam.aiteam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fortech.aiteam.aiteam.R;
import com.fortech.aiteam.aiteam.callbacks.DiseaseSelectionListener;
import com.fortech.aiteam.aiteam.callbacks.SymptomSelectionListener;
import com.fortech.aiteam.aiteam.model.Disease;
import com.fortech.aiteam.aiteam.model.Symptom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DiseasesAdapter extends ApplicationAdapter<Disease> {
    private final LayoutInflater mInflater;
    private final List<Disease> allItems;
    private DiseaseSelectionListener mDiseaseSelectionListener;

    public DiseasesAdapter(Context context, List<Disease> objects, DiseaseSelectionListener diseaseSelectionListener) {
        super(context, objects);
        mInflater = LayoutInflater.from(context);
        allItems = new ArrayList<>();
        mDiseaseSelectionListener = diseaseSelectionListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final Disease diseaseRowItem = getItem(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.disease_list_row, parent, false);
            viewHolder.diseaseTextView = (TextView) convertView.findViewById(R.id.disease_editText);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.diseaseTextView.setText(diseaseRowItem.getName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDiseaseSelectionListener.onDieseaseSelected(diseaseRowItem);
            }
        });

        return convertView;
    }

    @Override
    public void clear() {
        super.clear();
        allItems.clear();
    }

    @Override
    public void addAll(Collection<? extends Disease> collection) {
        super.addAll(collection);
        allItems.addAll(collection);
    }

    @Override
    public void add(Disease object) {
        super.add(object);
        allItems.add(object);
    }

    private static class ViewHolder {
        private TextView diseaseTextView;
    }
}
