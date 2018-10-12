package com.example.administrator.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private NotificationManager notificationManager;
    private Notification notification1;
    private Notification notification2;
    Bitmap LargeBitmap1 = null;
    Bitmap LargeBitmap2 = null;
    private static final int NOTIFYID_1 = 1;
    private static final int NOTIFYID_2 = 2;

    private Button btn_show;
    private  Button btn_del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LargeBitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        LargeBitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        bindView();
    }

    private void bindView() {
       btn_show = (Button)findViewById(R.id.show);
       btn_del = (Button)findViewById(R.id.delete);
       btn_show.setOnClickListener(this);
       btn_del.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show:
                String id = "1";
                String name = "channel_1";

                Intent intent = new Intent(this, TestActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


                //添加第一个通知
                Notification.Builder mBuilder1 = new Notification.Builder(this);
                mBuilder1.setContentTitle("第一条通知标题")
                        .setContentText("这是第一条通知的内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(LargeBitmap1)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);

                //添加第二个通知
                Notification.Builder mBuilder2 = new Notification.Builder(this);
                mBuilder2.setContentTitle("第二条通知标题")
                        .setContentText("这是第二条通知的内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(LargeBitmap2)
                        .setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
                    notificationManager.createNotificationChannel(mChannel);
                    mBuilder1.setChannelId(id);
                    mBuilder2.setChannelId(id);
                }

                notification1 = mBuilder1.build();
                notificationManager.notify(NOTIFYID_1, notification1);
                notification2 = mBuilder2.build();
                notificationManager.notify(NOTIFYID_2,notification2);
                    break;
                case R.id.delete:
                        notificationManager.cancel(NOTIFYID_1);
                        notificationManager.cancel(NOTIFYID_2);
                        break;
                default:
                        break;

        }
    }
}
