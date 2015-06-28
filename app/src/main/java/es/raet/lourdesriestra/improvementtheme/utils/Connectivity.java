package es.raet.lourdesriestra.improvementtheme.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import es.raet.lourdesriestra.improvementtheme.AppGeneral;


public class Connectivity {
    public static boolean weAreConnect() {
        ConnectivityManager conMan = (ConnectivityManager) AppGeneral.getContextApp().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMan.getActiveNetworkInfo();
        if (netInfo != null) {
            LogC.i("WifiReceiver", "Have Wifi Connection");
            return true;
        } else {
            LogC.i("WifiReceiver", "Don't have Wifi Connection");
            return false;
        }
    }
}
