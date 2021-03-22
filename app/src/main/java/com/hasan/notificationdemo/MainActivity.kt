package com.hasan.notificationdemo

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.hasan.notificationdemo.objects.BigPictureStyleMocData
import com.hasan.notificationdemo.objects.InboxStyleMocData

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val NOTIFICATION_ID = 888
    private lateinit var notificationManagerCompat : NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManagerCompat = NotificationManagerCompat.from(this)

        val btnInboxStyleNotification = findViewById<Button>(R.id.btn_inbox_style)
        btnInboxStyleNotification.setOnClickListener(this)

        // Big Image Style Notification
        val btnBigImageStyleNotification = findViewById<Button>(R.id.btn_big_image_style)
        btnBigImageStyleNotification.setOnClickListener(this)
    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.btn_inbox_style ->{
               generateInboxStyleNotification()
               return
           }
           R.id.btn_big_image_style -> {
               generateBigPictureStyleNotification()
               return
           }
       }
    }

    private fun generateInboxStyleNotification() {
        val notificationChannelId: String = NotificationUtil().createInboxStyleNotificationChannel(this)

        val inboxStyle = NotificationCompat.InboxStyle() // This title is slightly different than regular title
                .setBigContentTitle(InboxStyleMocData.mBigContentTitle)
                .setSummaryText(InboxStyleMocData.mSummaryText)

        for (summary in InboxStyleMocData.individualEmailSummary()) {
            inboxStyle.addLine(summary)
        }

        val mainIntent = Intent(this, MainActivity::class.java)

        val mainPendingIntent = PendingIntent.getActivity(
                this,
                0,
                mainIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationCompatBuilder = NotificationCompat.Builder(
                applicationContext,
                notificationChannelId
        )

        notificationCompatBuilder.setStyle(inboxStyle)
                .setContentTitle(InboxStyleMocData.contentTitle)
                .setContentText(InboxStyleMocData.contentText)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_person_24))
                .setContentIntent(mainPendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setColor(ContextCompat.getColor(applicationContext, R.color.purple_500))
                .setSubText(InboxStyleMocData.numberOfNewEmails.toString())
                .setCategory(Notification.CATEGORY_EMAIL)
                .setPriority(InboxStyleMocData.priority)
                .setVisibility(InboxStyleMocData.channelLockScreenVisibility)

        for (name in InboxStyleMocData.participants()) {
            notificationCompatBuilder.addPerson(name)
        }

        val notification = notificationCompatBuilder.build()

        notificationManagerCompat.notify(NOTIFICATION_ID, notification)


    }

    private fun generateBigPictureStyleNotification() {
        val notificationChannelId: String = NotificationUtil().createInboxStyleNotificationChannel(this)

        val bigPictureStyle = NotificationCompat.BigPictureStyle() // This title is slightly different than regular title
                .bigPicture(BitmapFactory.decodeResource(resources, BigPictureStyleMocData.bigImage))
                .setBigContentTitle(BigPictureStyleMocData.bigContentTitle)
                .setSummaryText(BigPictureStyleMocData.summaryText)


        val mainIntent = Intent(this, MainActivity::class.java)

        val mainPendingIntent = PendingIntent.getActivity(
                this,
                0,
                mainIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationCompatBuilder = NotificationCompat.Builder(
                applicationContext,
                notificationChannelId
        )

        notificationCompatBuilder.setStyle(bigPictureStyle)
                .setContentTitle(BigPictureStyleMocData.contentTitle)
                .setContentText(BigPictureStyleMocData.contentText)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_person_24))
                .setContentIntent(mainPendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setColor(ContextCompat.getColor(applicationContext, R.color.purple_500))
                .setSubText(1.toString())
                .setCategory(Notification.CATEGORY_SOCIAL)
                .setPriority(BigPictureStyleMocData.priority)
                .setVisibility(BigPictureStyleMocData.channelLockScreenVisibility)

        for (name in BigPictureStyleMocData.participants()) {
            notificationCompatBuilder.addPerson(name)
        }

        val notification = notificationCompatBuilder.build()

        notificationManagerCompat.notify(NOTIFICATION_ID, notification)


    }
}