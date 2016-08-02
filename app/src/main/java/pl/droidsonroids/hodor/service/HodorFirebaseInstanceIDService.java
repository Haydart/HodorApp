package pl.droidsonroids.hodor.service;

import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import pl.droidsonroids.hodor.HodorApplication;
import pl.droidsonroids.hodor.util.DatabaseHelper;

/**
 * Created by Radek on 2016-08-02.
 */
public class HodorFirebaseInstanceIDService extends FirebaseInstanceIdService{

    @Override
    public void onTokenRefresh() {
        HodorApplication.getInstance().getDatabaseHelper().updateUserToken(
                FirebaseInstanceId.getInstance().getToken());
    }
}
