package my.example.androidexmaple;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final long SLLEEP_INTERVAL_MILLIS = 5 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlarmManager alarmManager =
                (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        findViewById(R.id.schedule).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                    intent, PendingIntent.FLAG_ONE_SHOT);

            long triggerAtMillis = SLLEEP_INTERVAL_MILLIS +
                    System.currentTimeMillis();

            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
        });
    }
}
