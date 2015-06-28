package es.raet.lourdesriestra.improvementtheme.reboot;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

import es.raet.lourdesriestra.improvementtheme.R;
import es.raet.lourdesriestra.improvementtheme.utils.LogC;
import es.raet.lourdesriestra.improvementtheme.view.StartActivity;

public class LoggerServiceManager extends BroadcastReceiver {
    public final static String GROUP_NOTIF_KEY = "GROUP_NOTIF_KEY_RAET";

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent notificationIntent = new Intent(context, StartActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context,
                    0, notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),
                    R.mipmap.ic_launcher);

            Notification summaryNotification = new NotificationCompat.Builder(context)
                    .setContentTitle(context.getString(R.string.notif_line_summary))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(largeIcon)
                    .setStyle(new NotificationCompat.InboxStyle()
                            .addLine((context.getString(R.string.notif_line_one)))
                            .addLine(context.getString(R.string.notif_line_two))
                            .setBigContentTitle(context.getString(R.string.notif_title))
                            .setSummaryText(context.getString(R.string.notif_line_summary)))
                    .setGroup(GROUP_NOTIF_KEY)
                    .setGroupSummary(true)
                    .setContentIntent(contentIntent)
                    .build();

            NotificationManagerCompat notificationManager =
                    NotificationManagerCompat.from(context);
            notificationManager.notify(0, summaryNotification);
        } else {
            LogC.e("Received unexpected intent " + intent.toString() + ", action: " + intent.getAction());
        }
    }

}