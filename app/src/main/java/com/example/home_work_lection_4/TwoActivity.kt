package com.example.home_work_lection_4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.home_work_lection_4.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityTwoBinding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceIntent = Intent(this, PlayFileService::class.java)
        startService(serviceIntent)

        binding.volume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Data.volumeObserve.value = p1.toFloat() / 100f
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                return
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                return
            }

        })
        binding.secondBtn.setOnClickListener {
            if (binding.secondBtn.isChecked) {
                startService(serviceIntent)
            } else {
                stopService(serviceIntent)
            }
        }
    }
}