package com.hasan.notificationdemo.objects

import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import com.hasan.notificationdemo.R

object BigPictureStyleMocData {

    const val contentTitle = "Bob's Post"
    const val contentText = "[Picture] Like my shot on Bike?"
    const val priority = NotificationCompat.PRIORITY_HIGH

    const val bigImage = R.drawable.bike
    const val bigContentTitle = "Bob's Post"
    const val summaryText = "Like my shot of Bike?"





    fun participants(): ArrayList<String> {
        // If the user in "Do not disturb mode, the user will still be notified
        // if the user(s) is starred as a favorite"

        val list  = ArrayList<String>()

        list.add("Hasan")


        return list
    }

    //Notification channel values (for device targeting 26 or above
    const val channelId = "channel_social_1"

    // The user-visible name of the channel
    const val channelName = "Sample Social"

    // The user-visible description of the channel.
    const val channelDescription = "Sample social notification"
    const val channelImportance = NotificationManager.IMPORTANCE_HIGH
    const val channelEnableVibrate = true
    const val channelLockScreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

}