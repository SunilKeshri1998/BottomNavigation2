package com.example.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Adapters.ScheduleStudentRecyclerViewAdapter;
import DataClass.ScheduleStudentListItemDataClass;

public class ScheduleFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ScheduleStudentListItemDataClass> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = (View) inflater.inflate( R.layout.fragment_schedule, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_schedule_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setClickable(false);

        list=new ArrayList<>();

        ScheduleStudentListItemDataClass x=new ScheduleStudentListItemDataClass("Operating System","BK SINGH",1,false);
        list.add(x);

        x=new ScheduleStudentListItemDataClass("Operating System","BK SINGH",2,true);
        list.add(x);



        adapter=new ScheduleStudentRecyclerViewAdapter(list,getContext());

        recyclerView.setAdapter(adapter);

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
