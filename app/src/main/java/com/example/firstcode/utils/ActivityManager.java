package com.example.firstcode.utils;

import android.app.Activity;
import android.view.PixelCopy;

import java.util.ArrayList;
import java.util.List;

public class ActivityManager {
    public static List<Activity> sActivities = new ArrayList<>();

    public static void addActivity(Activity activity){
        sActivities.add(activity);
    }

    public static void removeActivity(Activity activity){
        sActivities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : sActivities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        sActivities.clear();
    }
}
