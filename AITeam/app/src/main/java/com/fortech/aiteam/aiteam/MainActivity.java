package com.fortech.aiteam.aiteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fortech.aiteam.aiteam.model.Diseases;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    //03.06.15
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button v = (Button) findViewById(R.id.button_next);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavDrawerActivity.class);
                startActivity(intent);
            }
        });
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Ou87H1hk6IKbI6Nm8gDrts56o6vjfHagXBQDfXZS", "KKwhLiOG0mm7St1QbHCLhoRhRLo4qwt5N7yvDKFt");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Diseases");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {
                List<Diseases> diseasesList = new ArrayList<Diseases>();

                for(ParseObject diseases: list)
                {
                    Diseases obj = new Diseases();

                    obj.setName((String) diseases.get("name"));
                    obj.setIdDiseases((Integer) diseases.get("idDisease"));
                    obj.setTreatment((String) diseases.get("treatment"));

                    diseasesList.add(obj);
                }

                String s = new String();
            }
        });
    }
}

