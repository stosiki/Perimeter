package avtaha.stosiki.com.perimeter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by User on 12/08/2015.
 *
 * responsible for presenting test, verifying it's successful completion
 * and notifying manager if it wasn't
 */
public class TestActivity extends Activity {
    private static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d(TAG, "Hourly alarm, time=" + new Date().toString());

        // present dot pattern and listen to the input
    }

    private void notifyManger() {
        // send SMS here
    }

}
