package es.raet.lourdesriestra.improvementtheme;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import es.raet.lourdesriestra.improvementtheme.utils.ExceptionUncaughtHandler;
import es.raet.lourdesriestra.improvementtheme.utils.LogC;
import es.raet.lourdesriestra.improvementtheme.view.MainActivity;

public class Aplicacion extends Application {

	private static Context contextApp = null;


	public static Context getContextApp() {
		return contextApp;
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
			if (activity instanceof MainActivity) {

			}
			Thread.setDefaultUncaughtExceptionHandler(new ExceptionUncaughtHandler(activity, MainActivity.class));
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
			LogC.i("Aqui " + activity.getLocalClassName());
		}

		@Override
		public void onActivityDestroyed(final Activity activity) {
		}
	}
}
