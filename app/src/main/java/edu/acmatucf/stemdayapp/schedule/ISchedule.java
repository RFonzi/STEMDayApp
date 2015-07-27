package edu.acmatucf.stemdayapp.schedule;

import edu.acmatucf.stemdayapp.ScheduleItem;

/**
 * Created by Ryan on 7/13/2015.
 */
public interface ISchedule {

    int size();
    void add(ScheduleItem scheduleItem);
    ScheduleItem get(int index);
}
