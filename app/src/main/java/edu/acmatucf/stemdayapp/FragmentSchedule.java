package edu.acmatucf.stemdayapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.acmatucf.stemdayapp.schedule.Schedule;

public class FragmentSchedule extends Fragment {

    private ScheduleAdapter scheduleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);



        //Set up recyclerview
        scheduleAdapter = new ScheduleAdapter();
        RecyclerView.LayoutManager scheduleLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView scheduleRecyclerView = (RecyclerView) view.findViewById(R.id.schedule);
        scheduleRecyclerView.addItemDecoration(new ScheduleDividerItemDecoration(this.getActivity().getApplicationContext()));
        scheduleRecyclerView.setLayoutManager(scheduleLayoutManager);
        scheduleRecyclerView.setAdapter(scheduleAdapter);


        return view;


    }

    @Override
    public void onResume() {
        super.onResume();



        scheduleAdapter.setSchedule(new Schedule());

    }
}


