package pl.droidsonroids.hodor;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;

import static pl.droidsonroids.hodor.Constants.USERNAME;

public class HodorPreferences {
    private SharedPreferences sharedPreferences;

    public HodorPreferences(Context context){
        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_APPEND);
    }

    public void setUsername(String username) {
        sharedPreferences.edit().putString(USERNAME,username).apply();
    }

    public String getUsername() {
        return sharedPreferences.getString(USERNAME, "");
    }

    public String getOwnToken(){
        return FirebaseInstanceId.getInstance().getToken();
    }

}
