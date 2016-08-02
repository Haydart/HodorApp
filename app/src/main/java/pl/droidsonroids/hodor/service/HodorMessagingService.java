package pl.droidsonroids.hodor.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import pl.droidsonroids.hodor.Constants;
import pl.droidsonroids.hodor.R;
import pl.droidsonroids.hodor.ui.MainActivity;

/**
 * Created by Radek on 2016-08-02.
 */
public class HodorMessagingService extends FirebaseMessagingService {

    Vibrator vibrator;
    Uri sound;
    PendingIntent appOpenPendingIntent;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String username = remoteMessage.getData().get("username");

        sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hodor);
        Intent broadCastIntent = new Intent(this, SendHodorBackBroadcastReceiver.class);
        broadCastIntent.putExtra(Constants.USERNAME, username);
        broadCastIntent.setAction(Constants.SEND_BACK);

        Intent appOpenIntent = new Intent(this, MainActivity.class);

        appOpenPendingIntent = PendingIntent.getActivity(this, Constants.APP_OPEN_REQUEST_CODE, appOpenIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.common_full_open_on_phone)
                        .setContentTitle(username)
                        .setSound(sound)
                        .addAction(0,
                                getString(R.string.action_send),
                                PendingIntent.getBroadcast(this,
                                        Constants.SEND_REQUEST_CODE,
                                        broadCastIntent,
                                        PendingIntent.FLAG_UPDATE_CURRENT))
        .setContentIntent(appOpenPendingIntent)
                .setContentText("Hold the door!");

        NotificationManager mNotifyMgr =
                (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(Constants.NOTIFICATION_ID, mBuilder.build());
    }
}
