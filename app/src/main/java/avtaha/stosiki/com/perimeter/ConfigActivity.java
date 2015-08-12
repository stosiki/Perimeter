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

    public void startChecker(Context context) {
        Log.d(TAG, "Checker started");

        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ShomerChecker.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        // Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 10);

        // setRepeating() lets you specify a precise custom interval--in this case,
        // 20 minutes.
//        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                1000 * 60 * 1, alarmIntent);

        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 10000,
                1000 * 60,
                alarmIntent
                );
    }
}
