package com.example.abuosama.revvieverex3;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        Toast.makeText(this, "print name ..."+name, Toast.LENGTH_SHORT).show();
        //MainActivity.textView.setText("service");
        //trigger or start broadcast receiver use intent and sendbroadcast
        Intent i=new Intent();
        i.setAction("work_done");
        sendBroadcast(i);
        return super.onStartCommand(intent, flags, startId);
    }
}
