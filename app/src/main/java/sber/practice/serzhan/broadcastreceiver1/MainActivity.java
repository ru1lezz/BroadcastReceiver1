package sber.practice.serzhan.broadcastreceiver1;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button changeStateButton;
    private TextView mTextView;
    private MyReceiver myReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    private void init() {
        myReceiver = new MyReceiver(new ViewCallbackImpl());
        intentFilter = new IntentFilter("sber.practice.serzhan.broadcastreceiver1.SEND_MESSAGES_FILTER");
    }

    private void initViews() {
        changeStateButton = findViewById(R.id.button_change);
        mTextView = findViewById(R.id.textView);
    }

    private void initListeners() {
        changeStateButton.setOnClickListener((View v) -> {
            startService(MyIntentService.newIntent(MainActivity.this));
        });
    }

    private class ViewCallbackImpl implements ViewCallback {
        @Override
        public void onStatusChanged(String newStatus) {
            mTextView.setText(newStatus);
        }
    }
}
