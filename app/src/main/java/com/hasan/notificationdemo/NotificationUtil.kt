package com.hasan.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class NotificationUtil {

    fun createInboxStyleNotificationChannel(context: Context): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //The id of the channel
            val channelId = InboxStyleMocData.channelId
            //The user-visible name of the channel.
            val channelName: CharSequence = InboxStyleMocData.channelName
            val channelDescription = InboxStyleMocData.channelDescription
            val channelImportance = InboxStyleMocData.channelImportance
            val channelEnableVibrate = InboxStyleMocData.channelEnableVibrate
            val channelLockScreenVisibility = InboxStyleMocData.channelLockScreenVisibility

            // Initializes NotificationChannel

            val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
            notificationChannel.description = channelDescription
            notificationChannel.enableVibration(channelEnableVibrate)
            notificationChannel.lockscreenVisibility = channelLockScreenVisibility

            /* Adds NotificationChannel to System. Attempting to create an existing notificationChannel
            with its original values performs no operation, so it's safe to perform the bellow sequence */
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(notificationChannel)

            return channelId
        }else{
            return ""
        }
    }
}