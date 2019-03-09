package mx.rincon.damian.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class Restarter extends BroadcastReceiver {
    private static final String TAG = "Broadcast";
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Servicio reiniciado", Toast.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, ExampleService.class));
            Log.d(TAG, "onReceive: Reinicia en android 8 >");
        } else {
            context.startService(new Intent(context, ExampleService.class));
            Log.d(TAG, "onReceive: Reinicia en android < 8");
        }
    }
}