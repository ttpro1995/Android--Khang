package com.ttpro.haha.khang;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class Agenda extends ActionBarActivity {

    private ListView listView;
    private ImageButton cancelButton;
    private ListView list;
    private DrawerLayout drawerLayout;
    private LinearLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        //content of activity
        listView = (ListView)findViewById(R.id.agenda_listView);
        cancelButton =(ImageButton)findViewById(R.id.agenda_cancelButton);
        ArrayList<Drawable> p_arr=new ArrayList<Drawable>();
        p_arr.add(getResources().getDrawable(R.drawable.agenda_season1));
        p_arr.add(getResources().getDrawable(R.drawable.agenda_season2));
        p_arr.add(getResources().getDrawable(R.drawable.agenda_season3));
        p_arr.add(getResources().getDrawable(R.drawable.agenda_season4));
        p_arr.add(getResources().getDrawable(R.drawable.agenda_season5));
        CustomMenuAdapter agendaListViewAdapter = new CustomMenuAdapter(this,R.layout.drawer_item,p_arr);
        listView.setAdapter(agendaListViewAdapter);


        //drawer
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

        drawerLayout = (DrawerLayout)findViewById(R.id.MainLayout);
        drawer = (LinearLayout)findViewById(R.id.drawer);
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
            //three line to open and close drawer
            if (!drawerLayout.isDrawerOpen(drawer))
                drawerLayout.openDrawer(drawer);
            else
                drawerLayout.closeDrawers();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
