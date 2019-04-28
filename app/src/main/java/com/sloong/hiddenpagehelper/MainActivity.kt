package com.sloong.hiddenpagehelper

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onActionUsageAccess(view: View){
        gotoAccessView(Settings.ACTION_USAGE_ACCESS_SETTINGS)
    }

    fun onActionNotificationAccess(view: View) {
        gotoAccessView(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
    }

    private fun gotoAccessView(targetAction:String ):Boolean{
        val packageManager = applicationContext
            .packageManager
        val intent = Intent(targetAction)
        val list = packageManager.queryIntentActivities(
            intent,
            PackageManager.MATCH_DEFAULT_ONLY
        )
        return if( list.size > 0) {
            startActivity(Intent(targetAction))
            true
        } else
            false
    }


    /**private fun isNoSwitch(): Boolean {
        val ts = System.currentTimeMillis()
        val usageStatsManager = applicationContext
            .getSystemService("usagestats") as UsageStatsManager
        val queryUsageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_BEST, 0, ts
        )
        return if (queryUsageStats == null || queryUsageStats.isEmpty()) {
            false
        } else true
    }*/
}
