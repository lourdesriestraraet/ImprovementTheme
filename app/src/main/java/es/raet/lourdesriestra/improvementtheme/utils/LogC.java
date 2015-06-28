package es.raet.lourdesriestra.improvementtheme.utils;

import android.util.Log;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;
import es.raet.lourdesriestra.improvementtheme.BuildConfig;
import es.raet.lourdesriestra.improvementtheme.R;


public class LogC {
    private static final String CONSTRUCTOR_NOMBRE = "<init>";

    public static int d(final String msg) {
        return BuildConfig.IS_DEBUG ? Log.d(getFileName(), getMethodName() + msg) : 0;
    }

    private static String getMethodName() {
        String name_method = Thread.currentThread().getStackTrace()[4].getMethodName();
        if (CONSTRUCTOR_NOMBRE.equalsIgnoreCase(name_method)) {
            return Thread.currentThread().getStackTrace()[4].getFileName()
                    .substring(0, (Thread.currentThread().getStackTrace()[4].getFileName()).indexOf('.')) + " Constructor:: ";
        }
        return name_method + ":: ";
    }

    private static String getFileName() {
        return AppGeneral.getContextApp().getString(R.string.app_name) + "-" + Thread.currentThread().getStackTrace()[4].getFileName()
                .substring(0, (Thread.currentThread().getStackTrace()[4].getFileName()).indexOf('.'));
    }

    public static int d(final String TAG, final String msg) {
        return BuildConfig.IS_DEBUG ? Log.d(TAG, getMethodName() + msg) : 0;
    }

    public static int e(final String TAG, final String msg) {
        return Log.e(TAG, getMethodName() + msg);
    }

    public static int e(final String msg) {
        return Log.e(getFileName(), getMethodName() + msg);
    }

    public static int e(final String msg, final Exception e) {
        return Log.e(getFileName(), getMethodName() + msg, e);
    }

    public static int i(final String msg) {
        return Log.i(getFileName(), getMethodName() + msg);
    }

    public static int i(final String TAG, final String msg) {
        return Log.i(TAG, getMethodName() + msg);
    }

    public static int w(final String msg) {
        return Log.w(getFileName(), getMethodName() + msg);
    }

    public static int w(final String TAG, final String msg) {
        return Log.w(TAG, getMethodName() + msg);
    }


}
