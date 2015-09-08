package com.fortech.aiteam.aiteam.model;

import com.google.gson.Gson;

/**
 * Created by Andrei on 9/2/2015.
 */
public class Disease extends GsonObject{

    private String name;
    private int idDisease;
    private String treatment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(int idDisease) {
        this.idDisease = idDisease;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
