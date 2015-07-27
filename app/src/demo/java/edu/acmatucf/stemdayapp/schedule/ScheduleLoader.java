package edu.acmatucf.stemdayapp.schedule;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import edu.acmatucf.stemdayapp.R;

/**
 * Created by Nathaniel on 7/20/2015.
 */
public class ScheduleLoader implements IScheduleLoader {
    private static ScheduleLoader instance;
    boolean hasLoadStarted;
    private Schedule schedule;

    private ScheduleLoader() {

    }

    public static synchronized ScheduleLoader getInstance() {
        if (instance == null) {
            instance = new ScheduleLoader();
        }
        return instance;
    }

    @Override
    public synchronized void load(@NonNull Context context) {
        if (hasLoadStarted) return;
        hasLoadStarted = true;

        final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);

        Ion.with(context)
                .load("http://jstav.site50.net/jsondemo.php")
                .as(Schedule.class)
                .withResponse()
                .setCallback(new FutureCallback<Response<Schedule>>() {
                    @Override
                    public void onCompleted(Exception e, Response<Schedule> result) {
                        if (e == null) {
                            schedule = result.getResult();
                            Intent intent = new Intent(ACTION_SCHEDULE_LOADED);
                            broadcastManager.sendBroadcast(intent);
                        } else {
                            throw new RuntimeException(e);
                        }
                    }
                });

    }

    @Nullable
    @Override
    public Schedule getSchedule() {
        return schedule;
    }
}
