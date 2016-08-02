package pl.droidsonroids.hodor.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import pl.droidsonroids.hodor.Constants;

/**
 * Created by Radek on 2016-08-02.
 */
public class SendHodorBackBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(Constants.SEND_BACK.equals(action)) {
            Log.d("shuffTest","Pressed SEND BACK");
            Intent sendBackIntent = new Intent(context, SendHodorBackIntentService.class);
            sendBackIntent.putExtra(Constants.USERNAME, intent.getStringExtra(Constants.USERNAME));
            Log.d("RECEIVER USER NAME", intent.getStringExtra(Constants.USERNAME));
            context.startService(sendBackIntent);
        } else if(Constants.IGNORE.equals(action)) {
            Log.d("shuffTest", "Pressed IGNORE");
        }
    }
}
