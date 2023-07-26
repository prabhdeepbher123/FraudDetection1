package com.example.myapplication;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import static com.example.myapplication.MainActivity.fu;

import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MyReceiver extends BroadcastReceiver {
    private static final String SMS_RECEIVED ="android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG ="SmsBroadcastReceived";
    String msg,phoneNo ="";
    String name;
    ArrayList<String> mlist = new ArrayList<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Intent Received: " + intent.getAction());
        if (intent.getAction() == SMS_RECEIVED) {
            Bundle dataBundle = intent.getExtras();
            if (dataBundle != null) {
                Object[] mypdu = (Object[]) dataBundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[mypdu.length];
                for (int i = 0; i < mypdu.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = dataBundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) mypdu[i], format);

                    } else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) mypdu[i]);
                    }
                    msg = messages[i].getMessageBody();
                    phoneNo = messages[i].getOriginatingAddress();
                }
                mlist.add("http://");
                mlist.add("Lottery");
                for (int i = 0; i < mlist.toArray().length; i++) {
                    name = mlist.get(i);
                }



                if (msg.contains(name)){
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(fu,null,msg,null,null);
                    Toast.makeText(context, "Danger detected", Toast.LENGTH_SHORT).show();

                }
            }
        }


















    }}


