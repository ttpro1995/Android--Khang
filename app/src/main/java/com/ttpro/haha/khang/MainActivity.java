package com.ttpro.haha.khang;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    list = (ListView) findViewById(R.id.DrawerListViewMain);
        ArrayList<Drawable> arr = new ArrayList<Drawable>() ;
        Drawable agenda = getResources().getDrawable(R.drawable.menu_agenda);
        Drawable attendess = getResources().getDrawable(R.drawable.menu_attendess);
        Drawable excursion = getResources().getDrawable(R.drawable.menu_excursion);
        Drawable home = getResources().getDrawable(R.drawable.menu_home);
        Drawable partners = getResources().getDrawable(R.drawable.menu_partners);
        Drawable speaker = getResources().getDrawable(R.drawable.menu_speakers);
        Drawable venues = getResources().getDrawable(R.drawable.menu_venue);

       arr.add(home);
       arr.add(agenda);
        arr.add(venues);
        arr.add(speaker);
        arr.add(attendess);
        arr.add(partners);
        arr.add(excursion);

        CustomMenuAdapter adapter = new CustomMenuAdapter(this,R.layout.drawer_item,arr);
        list.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
