package com.example.kksmartplayer

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.core.app.ActivityCompat
import com.ks.base_player.BaseType
import com.ks.base_player.KsPlayerListener
import com.ks.h_decode.KsGracePlayer
import com.ks.smart_player.KKSmartBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Permission
import java.security.Permissions

class MainActivity : AppCompatActivity(), KsPlayerListener {

    val TAG = "MainActivity"
    var PATH = "https://www.apple.com/105/media/us/iphone-x/2017/01df5b43-28e4-4848-bf20-490c34a926a7/films/feature/iphone-x-feature-tpl-cc-us-20170912_1920x1080h.mp4"
    var kkSmartPlayer: KsGracePlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )

        kkSmartPlayer = KKSmartBuilder.type(BaseType.EXO).build(this)

        kkSmartPlayer!!.addKsPlayerListener(this)
        kkSmartPlayer!!.addSurfaceView(surfaceView)
        kkSmartPlayer!!.prepare(PATH)

        btnStart.setOnClickListener {
            kkSmartPlayer!!.start()
        }
        btnStop.setOnClickListener {
            kkSmartPlayer!!.stop()
        }

        progressBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    override fun complete() {
        Log.e(TAG, "complete")
    }

    override fun buffering() {
        Log.e(TAG, "buffering")
    }

    override fun error(message: String) {
        Log.e(TAG, "error")
    }

    override fun stop() {
        Log.e(TAG, "stop")
    }

    override fun start() {
        Log.e(TAG, "start")
    }

    override fun onResume() {
        kkSmartPlayer!!.start()
        super.onResume()
    }

    override fun onStop() {
        kkSmartPlayer!!.stop()
        super.onStop()
    }

    override fun onDestroy() {
        kkSmartPlayer!!.destroy()
        super.onDestroy()
    }

}
