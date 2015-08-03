package edu.acmatucf.stemdayapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.acmatucf.stemdayapp.schedule.ISchedule;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {

    private ISchedule schedule;


    public void setSchedule(ISchedule schedule){
        this.schedule = schedule;

        notifyDataSetChanged();

    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);

        ScheduleViewHolder vh = new ScheduleViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position){
        holder.setScheduleItem(schedule.get(position));
    }

    @Override
    public int getItemCount(){
        return schedule == null ? 0 : schedule.size();
    }


}
