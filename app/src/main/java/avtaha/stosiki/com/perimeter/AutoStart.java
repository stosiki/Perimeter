package avtaha.stosiki.com.perimeter;

/**
 * Created by User on 12/08/2015.
 *
 * Class responsible for autostarting the shomer checker even if device reboots
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoStart extends BroadcastReceiver
{
    ConfigActivity schedule = new ConfigActivity();
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            schedule.startChecker(context);
        }
    }
}