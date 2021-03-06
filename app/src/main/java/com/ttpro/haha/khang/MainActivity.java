package com.ttpro.haha.khang;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ListView list;
    private DrawerLayout drawerLayout;
    private LinearLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton agendaButton = (ImageButton) findViewById(R.id.agendaButton);
        agendaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Agenda.class);
                startActivity(intent);
            }
        });






        ///Drawer
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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerClickAndGo(position);


            }
        });

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
//done: set a button to open drawer
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (!drawerLayout.isDrawerOpen(drawer))
            drawerLayout.openDrawer(drawer);
            else
            drawerLayout.closeDrawers();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //click on drawer to go to specific activity
    //copy this into every activity
    public void drawerClickAndGo(int position)
    {
        Context a= MainActivity.this;
        Class b = Agenda.class ;//just init so there is no error


        if (position==0)
            //current position
            return;

        if (position==1)
            b = Agenda.class;


        Intent intent= new Intent(a,b);
        startActivity(intent);
    }

}
