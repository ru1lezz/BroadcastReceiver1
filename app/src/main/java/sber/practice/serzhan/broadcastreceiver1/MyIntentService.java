package sber.practice.serzhan.broadcastreceiver1;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("MyIntentService", "Handling intent");
        Intent broadcaseIntent = new Intent("sber.practice.serzhan.broadcastreceiver1.SEND_MESSAGES_FILTER");
        ManagerState managerState = ManagerState.getInstance();
        managerState.changeState();
        broadcaseIntent.putExtra("STATE", String.valueOf(managerState.getState()));
        sendBroadcast(broadcaseIntent);
        Log.i("MyIntentService", "broadcast was sended");
    }

    public static final Intent newIntent(Context context) {
        return new Intent(context, MyIntentService.class);
    }
}
