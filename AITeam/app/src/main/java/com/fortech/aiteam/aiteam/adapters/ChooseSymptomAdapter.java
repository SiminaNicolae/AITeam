package com.fortech.aiteam.aiteam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fortech.aiteam.aiteam.R;
import com.fortech.aiteam.aiteam.adapters.ApplicationAdapter;
import com.fortech.aiteam.aiteam.callbacks.SymptomSelectionListener;
import com.fortech.aiteam.aiteam.model.Symptom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChooseSymptomAdapter extends ApplicationAdapter<Symptom> {
    private final LayoutInflater mInflater;
    private final List<Symptom> allItems;
    private SymptomSelectionListener mSymptomSelectionListener;

    public ChooseSymptomAdapter(Context context, List<Symptom> objects, SymptomSelectionListener symptomSelectionListener) {
        super(context, objects);
        mInflater = LayoutInflater.from(context);
        allItems = new ArrayList<>();
        mSymptomSelectionListener = symptomSelectionListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final Symptom symptomRowItem = getItem(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.choose_symptom_list_row, parent, false);
            viewHolder.symptomTextView = (TextView) convertView.findViewById(R.id.symptom);
            viewHolder.checkImage = (ImageView) convertView.findViewById(R.id.check_button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.symptomTextView.setText(symptomRowItem.getName());

        if (symptomRowItem.isSelected()) {
            viewHolder.checkImage.setBackgroundResource(R.drawable.checked_button);
        } else {
            viewHolder.checkImage.setBackgroundResource(R.drawable.unchecked_button);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSymptomSelectionListener.onSymptomSelected(symptomRowItem.getIdSymptom());
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
    public void addAll(Collection<? extends Symptom> collection) {
        super.addAll(collection);
        allItems.addAll(collection);
    }

    @Override
    public void add(Symptom object) {
        super.add(object);
        allItems.add(object);
    }

    private static class ViewHolder {
        private TextView symptomTextView;
        private ImageView checkImage;
    }
}
