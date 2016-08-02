package pl.droidsonroids.hodor.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;

=======
import android.widget.EditText;
>>>>>>> origin/master
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.hodor.HodorApplication;
import pl.droidsonroids.hodor.R;
import pl.droidsonroids.hodor.model.User;
import pl.droidsonroids.hodor.util.DatabaseHelper;
<<<<<<< HEAD
import pl.droidsonroids.hodor.util.GooglePlayUtils;
=======
>>>>>>> origin/master

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edit_login) EditText mEditTextLogin;

    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mDatabaseHelper = HodorApplication.getInstance().getDatabaseHelper();
<<<<<<< HEAD
        if(GooglePlayUtils.isGooglePlayServicesAvailable(this)){
            //bit of error here, the method above does way too much and has wrong name for it
            //it shows as well the dialog once GgooglePlayServices is not available, which is very misleading
        }
=======
>>>>>>> origin/master
    }

    @OnClick(R.id.button_login)
    public void onLoginClick() {
        final ProgressDialog loginProgressDialog = showProgressDialog();
        final String username = mEditTextLogin.getText().toString();

<<<<<<< HEAD
        User user = new User(username, FirebaseInstanceId.getInstance().getToken());
=======
        User user = new User(username, null);
>>>>>>> origin/master
        mDatabaseHelper.saveUserInDatabase(user, () -> {
            goToMain();
            loginProgressDialog.cancel();
        });
    }

    private ProgressDialog showProgressDialog() {
        return ProgressDialog.show(this,
                getString(R.string.login_dialog_title),
                getString(R.string.login_dialog_msg),
                true);
    }

    private void goToMain() {
        finish();
        MainActivity.startActivity(this);
    }
}
