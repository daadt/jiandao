package com.example.jdd.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.mmkv.MMKV;


public class MyApplication extends Application {

    public static Context myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);
        myApplication=this;
        initLeakCanary();

        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
     ActivityLifecycleCallbacks activityLifecycleCallbacks =new ActivityLifecycleCallbacks() {
         @Override
         public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
            AppManager.getInstance().addActivity(activity);
         }

         @Override
         public void onActivityStarted(@NonNull Activity activity) {

         }

         @Override
         public void onActivityResumed(@NonNull Activity activity) {

         }

         @Override
         public void onActivityPaused(@NonNull Activity activity) {

         }

         @Override
         public void onActivityStopped(@NonNull Activity activity) {

         }

         @Override
         public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

         }

         @Override
         public void onActivityDestroyed(@NonNull Activity activity) {
            AppManager.getInstance().removeActivity(activity);
         }
     };

    private void initLeakCanary(){
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }
}
