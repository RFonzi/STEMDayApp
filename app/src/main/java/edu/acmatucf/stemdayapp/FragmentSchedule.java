package edu.acmatucf.stemdayapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.acmatucf.stemdayapp.schedule.IScheduleLoader;
import edu.acmatucf.stemdayapp.schedule.Schedule;
import edu.acmatucf.stemdayapp.schedule.ScheduleLoader;

public class FragmentSchedule extends Fragment {
    private LocalBroadcastManager broadcastManager;
    private ScheduleAdapter scheduleAdapter;
    private ScheduleLoadedListener scheduleLoadedListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);


        //Set up recyclerview
        scheduleAdapter = new ScheduleAdapter();
        broadcastManager = LocalBroadcastManager.getInstance(getActivity());
        scheduleLoadedListener = new ScheduleLoadedListener();

        RecyclerView.LayoutManager scheduleLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView scheduleRecyclerView = (RecyclerView) view.findViewById(R.id.schedule);
        scheduleRecyclerView.setLayoutManager(scheduleLayoutManager);
        scheduleRecyclerView.setAdapter(scheduleAdapter);
        return view;


    }

    private void setAdapter() {
        Schedule schedule = ScheduleLoader.getInstance().getSchedule();

        if(schedule != null) {
            scheduleAdapter.setSchedule(schedule);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        setAdapter();
    }

    @Override
    public void onStart() {
        super.onStart();

        broadcastManager.registerReceiver(scheduleLoadedListener, new IntentFilter(IScheduleLoader.ACTION_SCHEDULE_LOADED));
    }

    @Override
    public void onStop() {
        super.onStop();

        broadcastManager.unregisterReceiver(scheduleLoadedListener);
    }

    private final class ScheduleLoadedListener extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            setAdapter();
        }
    }
}


