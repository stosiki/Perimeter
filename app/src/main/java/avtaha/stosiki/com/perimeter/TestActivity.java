package avtaha.stosiki.com.perimeter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by User on 12/08/2015.
 *
 * responsible for presenting test, verifying it's successful completion
 * and notifying manager if it wasn't
 */
public class TestActivity extends Activity {
    private static final String TAG = TestActivity.class.getSimpleName();
    private static final int REQ_CREATE_PATTERN = 1;
    private static final int REQ_CAPTCHA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Creating TestActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        showPattern();
        Log.d(TAG, "Hourly alarm, time=" + new Date().toString());

        // present dot pattern and listen to the input
    }

    private void notifyManger() {
        // send SMS here
        //TODO: real phone number to test
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                // can put port number here for testing too
                Uri.parse( "sms:" + "0522978952")
        );
        intent.putExtra("sms_body", "Shomer is not answering");
        startActivity(intent);
    }

    private void showPattern() {
/*
        Intent intent = new Intent(LockPatternActivity.ACTION_CREATE_PATTERN, null,
                getApplicationContext(), LockPatternActivity.class);
        startActivityForResult(intent, REQ_CREATE_PATTERN);
*/
        Context context = getApplicationContext();
        AlpSettings.Display.setCaptchaWiredDots(context, 5);
        //TODO: play some sound before pattern is shown
        //TODO: start the timer, activity should expire on timeout and restarted again given number
        // of retries. Because
        //
        Intent intent = new Intent(LockPatternActivity.ACTION_VERIFY_CAPTCHA, null,
                context, LockPatternActivity.class);

        startActivityForResult(intent, REQ_CAPTCHA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQ_CREATE_PATTERN:
                if (resultCode == RESULT_OK) {
                    char[] pattern = data.getCharArrayExtra(LockPatternActivity.EXTRA_PATTERN);
                }

                break;
            case REQ_CAPTCHA:
                if(resultCode == RESULT_OK) {
                    // do nothing
                } else {
                    notifyManger();
                }
                break;
        }
    }

}
