package pl.droidsonroids.hodor.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.hodor.HodorApplication;
import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.hodor.R;
import pl.droidsonroids.hodor.model.User;
import pl.droidsonroids.hodor.util.DatabaseHelper;

public class UsersListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_view_username) TextView mTextViewUsername;

    private DatabaseHelper mDatabaseHelper;

    public UsersListViewHolder(final View itemView, final DatabaseHelper databaseHelper) {
        super(itemView);
        mDatabaseHelper = databaseHelper;
        ButterKnife.bind(this, itemView);
    }

    public void bindData(final String username, final int backgroundColorRes) {
        mTextViewUsername.setText(username);
        mTextViewUsername.setBackgroundColor(ContextCompat.getColor(mTextViewUsername.getContext(),
                backgroundColorRes));

        mDatabaseHelper.getUserFromDatabase(username, new DatabaseHelper.OnUserReceivedListener() {
            @Override
            public void onUserReceived(User friend) {
                mTextViewUsername.setOnClickListener(v -> sendPushToUser(friend));
            }
        });
    }

    private void sendPushToUser(final User friend) {
        HodorApplication.getInstance().getRestAdapter().sendPush(friend.getToken());
    }

}
