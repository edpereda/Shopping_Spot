package com.example.shopping_spot;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.shopping_spot.Fragments.Fragment_Configuracion;
import com.example.shopping_spot.Fragments.Fragment_Lista_productos;
import com.example.shopping_spot.Fragments.Fragment_Agregar_Producto;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Fragment_Lista_productos.OnFragmentInteractionListener,
                                                                    Fragment_Agregar_Producto.OnFragmentInteractionListener,
                                                                    Fragment_Configuracion.OnFragmentInteractionListener {

    Fragment_Lista_productos fragment_lista_productos;
    Fragment_Agregar_Producto fragment_agregar_producto;
    Fragment_Configuracion fragment_configuracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                fragment_agregar_producto = new Fragment_Agregar_Producto();
                Fragment miFragment;
                miFragment = new Fragment_Agregar_Producto();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_contenedor,miFragment).commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //iniciando los fragments
        fragment_lista_productos = new Fragment_Lista_productos();
        fragment_agregar_producto = new Fragment_Agregar_Producto();
        fragment_configuracion = new Fragment_Configuracion();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_contenedor,fragment_lista_productos).commit();

        //Poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo_ss);
    }

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
        if (id == R.id.action_manual) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment miFragment = null;
        boolean fragmentSeleccionado = false;

        if (id == R.id.nav_listap) {
            miFragment = new Fragment_Lista_productos();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_config) {
            miFragment = new Fragment_Configuracion();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_ayuda) {

        } else if (id == R.id.fab) {
            miFragment = new Fragment_Agregar_Producto();
            fragmentSeleccionado = true;
        }

        if (fragmentSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_contenedor,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
