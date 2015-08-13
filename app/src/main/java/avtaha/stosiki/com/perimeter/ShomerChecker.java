package avtaha.stosiki.com.perimeter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by User on 11/08/2015.
 *
 * Responsible for listening to broadcasts, and once the appropriate one is received,
 * to create WakeTestActivity
 *
 * It warrants a separate class only because it has to extend BroadcastReceiver,
 * while Test is an activity
 */
public class ShomerChecker extends WakefulBroadcastReceiver {
    private static final String TAG = ShomerChecker.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Intent received");
        Intent startIntent = new Intent(context, TestActivity.class);
        startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startIntent);
    }
}
