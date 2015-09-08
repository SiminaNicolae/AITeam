package com.fortech.aiteam.aiteam;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by nick on 08.09.2015.
 */
public class PersonalAssistentApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "Ou87H1hk6IKbI6Nm8gDrts56o6vjfHagXBQDfXZS", "KKwhLiOG0mm7St1QbHCLhoRhRLo4qwt5N7yvDKFt");
    }
}
