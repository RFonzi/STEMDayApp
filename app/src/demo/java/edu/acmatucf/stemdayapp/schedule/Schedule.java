package edu.acmatucf.stemdayapp.schedule;

import java.util.ArrayList;
import java.util.List;

import edu.acmatucf.stemdayapp.ScheduleItem;

/**
 * Created by Ryan on 7/13/2015.
 */
public class Schedule implements ISchedule {

    private List<ScheduleItem> scheduleItemList;

    private Schedule() {

    }

    @Override
    public int size() {

        return scheduleItemList.size();
    }

    @Override
    public void add(ScheduleItem scheduleItem)   {
         scheduleItemList.add(scheduleItem);
    }

    @Override
    public ScheduleItem get(int index) {

        return scheduleItemList.get(index);
    }

}
