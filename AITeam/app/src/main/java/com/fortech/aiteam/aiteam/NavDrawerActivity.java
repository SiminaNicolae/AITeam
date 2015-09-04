package com.fortech.aiteam.aiteam;


import java.util.Locale;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class NavDrawerActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mItemTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navdrawer_activity);

        String[] mItemTitles={"Selecteaza simptome","Sfaturi de prim ajutor","Setari","Detalii"};
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList=(ListView) findViewById(R.id.left_drawer);

        //Set adapter for list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mItemTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mDrawerToggle=new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close)
        {
            public void onDrawerClosed(View view)
            {
                getActionBar().setTitle(mTitle);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        if(savedInstanceState==null) {
            selectItem(0);
        }
    }



    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position)
    {
        Fragment newFragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch (position){
            case 0:
                //todo simpt;
                newFragment = new SimptomeBoliActivity();
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                break;
            case 1:
                //todo sfaturi
                newFragment = new PrimAjutorActivity();
                transaction.replace(R.id.content_frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 2:
                //todo detalii
                break;

        }

        mDrawerLayout.closeDrawer(mDrawerList);
    }

    public void setmTitle(CharSequence mTitle) {
        mTitle = mTitle;
        getActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
