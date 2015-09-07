package com.fortech.aiteam.aiteam.model;

/**
 * Created by nicolaes on 9/7/15.
 */
public class Symptom {
    private int idSymptom;
    private String name;
    private boolean selected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdSymptom() {
        return idSymptom;
    }

    public void setIdSymptom(int idSymptom) {
        this.idSymptom = idSymptom;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
