package edu.acmatucf.stemdayapp;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

/*
    Custom base application, added parse to onCreate so it is initialized once on first run.
 */

public class BaseApplication extends Application{

    private static BaseApplication singleton;

    @Override
    public void onCreate(){
        super.onCreate();

        // Initialize parse and subscribe to the broadcast.
        Parse.initialize(this, "BbZ5esE5qeTKLI5P2a6aid862WtHvM590BKLfbMS", "fEzwzYSVs8RAhrB9gmaXjOIg2DKR6lV7yoD8MU4W");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });

        singleton = this;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public BaseApplication getInstance(){
        return singleton;
    }

}
