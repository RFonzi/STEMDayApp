package edu.acmatucf.stemdayapp.schedule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Nathaniel on 7/20/2015.
 */

public interface IScheduleLoader {
    String ACTION_SCHEDULE_LOADED = "ACTION_SCHEDULE_LOADED";
    void load(@NonNull Context context);
    @Nullable
    Schedule getSchedule();
}
