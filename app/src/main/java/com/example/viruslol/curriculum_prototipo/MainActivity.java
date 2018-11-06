package com.example.viruslol.curriculum_prototipo;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Datos_Personales.OnFragmentInteractionListener,
        Referencias.OnFragmentInteractionListener,
        Nivel_Academico.OnFragmentInteractionListener,
       Conocimientos.OnFragmentInteractionListener,
        Cursos.OnFragmentInteractionListener

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Metodos
    /*
    public void datos_personales (View view){
        Intent datos_p = new Intent(this,Datos_Personales.class);
        startActivity(datos_p);
    }
    public void referencias (View view){
        Intent referencias = new Intent(this,Referencias.class);
        startActivity(referencias);
    }
    public void nivel_academico (View view){
        Intent nivel_a = new Intent(this,Nivel_Academico.class);
        startActivity(nivel_a);
    }
    public void cursos (View view){
        Intent cursos = new Intent(this,Cursos.class);
        startActivity(cursos);
    }
    */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        Boolean FragmentTransaction = false;
        Fragment fragment = null;




        if (id == R.id.nav_camera) {
            // Handle the camera action

            //LLAMADO A LAS CLASES
            fragment = new Datos_Personales();
            FragmentTransaction = true;

        } else if (id == R.id.nav_gallery) {

            fragment = new Referencias();
            FragmentTransaction = true;

        } else if (id == R.id.nav_slideshow) {

            fragment = new Nivel_Academico();
            FragmentTransaction = true;

        } else if (id == R.id.nav_manage) {
            fragment = new Cursos();
            FragmentTransaction = true;

        } else if (id == R.id.nav_share) {

            fragment = new Conocimientos();
            FragmentTransaction = true;


        }

        if (FragmentTransaction){

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor, fragment).commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
