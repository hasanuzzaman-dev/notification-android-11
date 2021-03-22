package com.hasan.notificationdemo.objects

import android.app.NotificationManager
import androidx.core.app.NotificationCompat

object InboxStyleMocData {

    // api level below 16
    const val contentTitle = "5 new emails"
    const val contentText = "from Jane, Jay, Alex +2 more.."
    const val numberOfNewEmails = 5
    const val priority = NotificationCompat.PRIORITY_DEFAULT

    const val mBigContentTitle = "5 new emails from Jane, Jay, Alex +2 more.."
    const val mSummaryText = "New Emails"

    fun individualEmailSummary(): ArrayList<String> {

        // Add each summary line of the new emails, you can add up to 5

        val list = ArrayList<String>()

        list.add("Hasan   -  Launch party is here...")
        list.add("Hasib  -  There's a turtle in the server.")
        list.add("Maruf  -   Check this out...")
        list.add("Saiful  -  Check in Code?")
        list.add("Asif  -  Moves later...")

        return list
    }

    fun participants(): ArrayList<String> {
        // If the user in "Do not disturb mode, the user will still be notified
        // if the user(s) is starred as a favorite"

        val list  = ArrayList<String>()

        list.add("Hasan")
        list.add("Hasib")
        list.add("Maruf")
        list.add("Saiful")
        list.add("Asif")

        return list
    }

    //Notification channel values (for device targeting 26 or above
    const val channelId = "channel_email_1"

    // The user-visible name of the channel
    const val channelName = "Sample Email"

    // The user-visible description of the channel.
    const val channelDescription = "Sample email notification"
    const val channelImportance = NotificationManager.IMPORTANCE_DEFAULT
    const val channelEnableVibrate = true
    const val channelLockScreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

}