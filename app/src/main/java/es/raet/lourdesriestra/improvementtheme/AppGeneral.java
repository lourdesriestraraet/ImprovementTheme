package es.raet.lourdesriestra.improvementtheme;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import es.raet.lourdesriestra.improvementtheme.structure.InfoImprovement;
import es.raet.lourdesriestra.improvementtheme.utils.ExceptionUncaughtHandler;
import es.raet.lourdesriestra.improvementtheme.utils.LogC;
import es.raet.lourdesriestra.improvementtheme.view.StartActivity;

public class AppGeneral extends Application {

    private static Context contextApp = null;
    private static InfoImprovement infoImprovement = null;

    public static Context getContextApp() {
        return contextApp;
    }

    public static InfoImprovement getInfoImprovement() {
        if (infoImprovement == null) {
            infoImprovement = new InfoImprovement();
        }
        return infoImprovement;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        contextApp = getApplicationContext();
        registerActivityLifecycleCallbacks(new HandleLifeCicleActivitys());
    }

    private class HandleLifeCicleActivitys implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (activity instanceof StartActivity) {
                LogC.d("Activity Splash created");
            }
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionUncaughtHandler(activity, StartActivity.class));
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
        }

        @Override
        public void onActivityPaused(Activity activity) {
        }

        @Override
        public void onActivityStopped(final Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override
        public void onActivityDestroyed(final Activity activity) {
        }
    }
}
