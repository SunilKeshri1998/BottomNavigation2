package com.example.bottomnavigation;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import Adapters.ScheduleStudentRecyclerViewAdapter;
import DataClass.ScheduleStudentListItemDataClass;

public class ScheduleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_schedule, container, false);

        /*Dialog fbDialogue = new Dialog(getActivity(), android.R.style.Theme_Black_NoTitleBar);
        fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
        fbDialogue.setContentView(R.layout.schedule_student_dialog);
        fbDialogue.setCancelable(true);
        fbDialogue.show();*/
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
