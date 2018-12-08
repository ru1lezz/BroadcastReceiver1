package sber.practice.serzhan.broadcastreceiver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private ViewCallback mViewCallback;

    public MyReceiver() {
    }

    public MyReceiver(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyReceiver", "starting onReceive");
        this.mViewCallback.onStatusChanged(String.valueOf(intent.getStringExtra("STATE")));
        Log.i("MyReceiver", "status changed");
    }
}
