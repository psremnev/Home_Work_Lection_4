package com.example.home_work_lection_4

import android.content.Intent
import android.media.MediaPlayer
import androidx.lifecycle.LifecycleService

class PlayFileService : LifecycleService() {
    private val player = MediaPlayer()
    private val defaultVolume by lazy { resources.getInteger(R.integer.defaultVolume) }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        player.setDataSource(resources.openRawResourceFd(R.raw.submotion_orchestra_fallen))
        player.prepare()
        player.setVolume(defaultVolume.toFloat(), defaultVolume.toFloat())
        player.start()

        Data.volumeObserve.observe(this) {
            player.setVolume(it, it)
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }
}