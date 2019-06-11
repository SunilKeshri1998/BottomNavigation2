package com.example.bottomnavigation;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager = null;
    MenuItem prevMenuItem = null;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //Fragment fragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_schedule:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.nav_hostel:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.nav_home:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.nav_mess:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.nav_medical:
                    viewPager.setCurrentItem(4);
                    break;
            }
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
    };

    public void onclick_schedule(View v) {
        Dialog student_dialog = new Dialog(MainActivity.this);
        student_dialog.setContentView(R.layout.schedule_student_dialog);
        TextView teacher_dialog, subject_dialog, room_dialog;
        teacher_dialog = student_dialog.getWindow().findViewById(R.id.dialog_teacher);
        subject_dialog = student_dialog.getWindow().findViewById(R.id.dialog_subject);
        room_dialog = student_dialog.getWindow().findViewById(R.id.dialog_room);
        if (v.getId() == R.id.b1) {
            teacher_dialog.setText("B.K.Singh");
            subject_dialog.setText("Operating Systems");
            room_dialog.setText("204");
        }
        else if (v.getId() == R.id.b2) {
            teacher_dialog.setText("R.R.Suman");
            subject_dialog.setText("ACOA");
            room_dialog.setText("202");
        }
        else if (v.getId() == R.id.b3) {
            teacher_dialog.setText("Rabi Shaw");
            subject_dialog.setText("DS");
            room_dialog.setText("201");
        }
        student_dialog.setCanceledOnTouchOutside(true);
        student_dialog.show();
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {

                case 0:
                    fragment = new ScheduleFragment();
                    break;
                case 1:
                    fragment = new HostelFragment();
                    break;
                case 2:
                    fragment = new HomeFragment();
                    break;
                case 3:
                    fragment = new MessFragment();
                    break;
                case 4:
                    fragment = new MedicalFragment();
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
