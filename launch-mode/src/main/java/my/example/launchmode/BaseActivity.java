package my.example.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String NUMBER_TAG = BaseActivity.class.getSimpleName() + ".NUMBER";

    private int number;
    private int initNumber;

    private TextView numberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNumber = number = getIntent().getIntExtra(NUMBER_TAG, 0);

        numberView = findViewById(R.id.number);
        numberView.setText(Integer.toString(number));

        ((TextView) findViewById(R.id.init_number)).setText(Integer.toString(initNumber));

        findViewById(R.id.standard).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, StandardActivity.class);
            intent.putExtra(NUMBER_TAG, number + 1);

            startActivity(intent);
        });

        findViewById(R.id.single_top).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SingleTopActivity.class);
            intent.putExtra(NUMBER_TAG, number + 1);

            startActivity(intent);
        });

        findViewById(R.id.single_task).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SingleTaskActivity.class);
            intent.putExtra(NUMBER_TAG, number + 1);

            startActivity(intent);
        });

        findViewById(R.id.single_task_clear_top).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SingleTaskActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra(NUMBER_TAG, number + 1);

            startActivity(intent);
        });

        findViewById(R.id.single_instance).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(this, SingleInstanceActivity.class);
            intent.putExtra(NUMBER_TAG, number + 1);

            startActivity(intent);
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        number = intent.getIntExtra(NUMBER_TAG, 0);
        numberView.setText(Integer.toString(number));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("BaseActivity", getTitle().toString() + " onStop()");
    }
}
