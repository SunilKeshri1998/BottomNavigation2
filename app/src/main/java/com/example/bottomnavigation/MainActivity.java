package com.example.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager = null;
    MenuItem prevMenuItem = null;
    BottomNavigationView bottomNavigationView;
    Toolbar toolBar;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolBar,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HostelFragment()).commit();
        prevMenuItem = bottomNavigationView.getMenu().getItem(2).setChecked(false);
        viewPager.setCurrentItem(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bottomNavigationView.getMenu().getItem(0).setChecked(false);
                //Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //Fragment fragment = null;
            switch(menuItem.getItemId()){
                case R.id.nav_schedule: viewPager.setCurrentItem(0);
                                    break;
                case R.id.nav_hostel: viewPager.setCurrentItem(1);
                                    break;
                case R.id.nav_home: viewPager.setCurrentItem(2);
                                    break;
                case R.id.nav_mess: viewPager.setCurrentItem(3);
                                    break;
                case R.id.nav_medical: viewPager.setCurrentItem(4);
                                    break;
            }
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
    };
    class MyAdapter extends FragmentStatePagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch(i){

                case 0: fragment = new ScheduleFragment();
                    break;
                case 1: fragment = new HostelFragment();
                    break;
                case 2: fragment = new HomeFragment();
                    break;
                case 3: fragment = new MessFragment();
                    break;
                case 4: fragment = new MedicalFragment();
                    break;

            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
