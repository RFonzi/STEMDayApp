package edu.acmatucf.stemdayapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ryan on 7/13/2015.
 */
public class ScheduleViewHolder extends RecyclerView.ViewHolder {
    private TextView myTextView;

    public ScheduleViewHolder(View v) {
        super(v);
        myTextView = (TextView) v.findViewById(R.id.scheduleTextView);


    }

    public void setScheduleItem(ScheduleItem item) {
        myTextView.setText(item.getTitle() + "\n" + item.getLocation() + "\n" + item.getStartDate() + " - " + item.getEndDate());
    }
}
