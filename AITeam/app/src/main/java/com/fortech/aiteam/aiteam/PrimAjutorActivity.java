package com.fortech.aiteam.aiteam;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Andrei on 7/16/2015.
 */
public class PrimAjutorActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.prim_ajutor_layout,
                container, false);
        Button button = (Button) view.findViewById(R.id.button_crucearosie);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri uri = Uri.parse("http://www.crucearosie.ro/activitati/prim-ajutor/sfaturi-de-prim-ajutor/cei-patru-pasi-in-acordarea-primului-ajutor.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return view;
    }

}