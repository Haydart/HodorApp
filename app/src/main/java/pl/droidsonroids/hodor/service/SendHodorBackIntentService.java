package pl.droidsonroids.hodor.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.util.Log;

import pl.droidsonroids.hodor.Constants;
import pl.droidsonroids.hodor.HodorApplication;
import pl.droidsonroids.hodor.model.User;
import pl.droidsonroids.hodor.util.DatabaseHelper;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SendHodorBackIntentService extends IntentService {

    public SendHodorBackIntentService() {
        super("SendHodorBackIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("INTENT SERVICE", "ON HANDLE INTENT");
        String sendingUserName = intent.getStringExtra(Constants.USERNAME);
        HodorApplication.getInstance().getDatabaseHelper().getUserFromDatabase(sendingUserName, new DatabaseHelper.OnUserReceivedListener() {
            @Override
            public void onUserReceived(User user) {
                HodorApplication.getInstance().getRestAdapter().sendPush(user.getToken());

                NotificationManager mNotifyMgr =
                        (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr.cancel(Constants.NOTIFICATION_ID);
            }
        });
    }
}
