package es.raet.lourdesriestra.improvementtheme.structure;

import android.os.StrictMode;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import es.raet.lourdesriestra.improvementtheme.utils.LogC;

class CollectDataServer {
    private static final int timeoutConnect = 2 * 1000;

    public static String start(final String conexionURL) {
        String result = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        try {
            URL obj = new URL(conexionURL);
            URLConnection connection = obj.openConnection();
            connection.setConnectTimeout(timeoutConnect);
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            int responseHttp = httpConnection.getResponseCode();
            if (responseHttp == HttpURLConnection.HTTP_OK) {
                result = readInputStream(httpConnection.getInputStream());
                return result;
            } else {
                LogC.e("Error, could not connect to the server.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String readInputStream(InputStream in) throws IOException {
        String response = "";
        int read = 0;
        byte buffer[] = new byte[1024 * 10];
        while ((read = in.read(buffer)) != -1) {
            response += (new String(buffer, 0, read));
        }
        System.gc();
        return response;
    }
}