package avtaha.stosiki.com.perimeter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

/**
 * Created by User on 12/08/2015.
 *
 * responsible for configuring and starting
 *
 * this class is going to be referenced from and be part of configuration
 */
public class ConfigActivity extends Activity {
    private static final String TAG = ConfigActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

    }

    public void onConfig(View controlView) {
        startChecker(getApplicationContext());
    }

    public void onCancel(View controlView) {
        Context context = getApplicationContext();
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ShomerChecker.class);
        intent.setAction("com.stosiki.avtaha.perimeter.CHECK");
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.cancel(alarmIntent);
    }

    public void startChecker(Context context) {
        Log.d(TAG, "Checker started");

        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ShomerChecker.class);
        intent.setAction("com.stosiki.avtaha.perimeter.CHECK");
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        for (int i : new int[]{22, 23, 0, 1, 2, 3, 4, 5, 6, 7}) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, i);
            calendar.set(Calendar.MINUTE, 10);
            alarmMgr.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY,
                    alarmIntent
            );
        }
    }
}
