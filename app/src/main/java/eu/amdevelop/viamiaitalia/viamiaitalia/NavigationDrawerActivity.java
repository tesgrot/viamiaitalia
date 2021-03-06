package eu.amdevelop.viamiaitalia.viamiaitalia;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.concurrent.ExecutionException;

import eu.amdevelop.viamiaitalia.viamiaitalia.Fragments.AccommodationFragment;
import eu.amdevelop.viamiaitalia.viamiaitalia.Fragments.ContactFragment;
import eu.amdevelop.viamiaitalia.viamiaitalia.Fragments.OrderFragment;
import eu.amdevelop.viamiaitalia.viamiaitalia.Fragments.ServicesFragment;
import eu.amdevelop.viamiaitalia.viamiaitalia.Fragments.WineFragment;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.ConnectionCheck;
import io.paperdb.Paper;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    private ConnectionCheck connectionCheck = new ConnectionCheck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Paper.init(this);

        setContentView(R.layout.activity_navigation_drawer);

        OrderFragment orderFragment = new OrderFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, orderFragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_order) {
            OrderFragment orderFragment = new OrderFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, orderFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_accommodation) {
            try {
                Boolean connectionIsOn = connectionCheck.execute().get();
                if (connectionIsOn.booleanValue() || Paper.exist("Accommodation")) {
                    AccommodationFragment accommodationFragment = new AccommodationFragment();
                    Bundle bdl = new Bundle(1);
                    bdl.putInt("POSITION", 1); //TODO getnut index pre accommodation
                    accommodationFragment.setArguments(bdl);
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, accommodationFragment);
                    fragmentTransaction.commit();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            connectionCheck = null;
            connectionCheck = new ConnectionCheck();
        } else if (id == R.id.nav_services) {
            try {
                Boolean connectionIsOn = connectionCheck.execute().get();
                if (connectionIsOn.booleanValue() || Paper.exist("Services")) {
                    ServicesFragment servicesFragment = new ServicesFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, servicesFragment);
                    fragmentTransaction.commit();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            connectionCheck = null;
            connectionCheck = new ConnectionCheck();


        } else if (id == R.id.nav_wine) {
            try {
                Boolean connectionIsOn = connectionCheck.execute().get();
                if (connectionIsOn.booleanValue() || Paper.exist("ServiceElements_1")) {
                    WineFragment wineFragment = new WineFragment();
                    Bundle bdl = new Bundle(1);
                    bdl.putInt("POSITION", 1);
                    wineFragment.setArguments(bdl);
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, wineFragment);
                    fragmentTransaction.commit();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            connectionCheck = null;
            connectionCheck = new ConnectionCheck();
        } else if (id == R.id.nav_contacts) {
            try {
                Boolean connectionIsOn = connectionCheck.execute().get();
                if (connectionIsOn.booleanValue() || Paper.exist("Contact")) {
                    ContactFragment contactFragment = new ContactFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, contactFragment);
                    fragmentTransaction.commit();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            connectionCheck = null;
            connectionCheck = new ConnectionCheck();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
