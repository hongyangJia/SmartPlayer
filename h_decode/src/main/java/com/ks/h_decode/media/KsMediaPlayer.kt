package com.ks.h_decode.media

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.ks.base_player.BaseType
import com.ks.base_player.KsBasePlayer
import com.ks.base_player.KsPlayerListener


/**
 * created by hongyang on 19-10-25
 */
class KsMediaPlayer : KsBasePlayer, MediaPlayer.OnPreparedListener,
    MediaPlayer.OnCompletionListener,
    MediaPlayer.OnErrorListener,
    MediaPlayer.OnInfoListener, SurfaceHolder.Callback {

    private var mVideoPlayer: MediaPlayer? = null
    private var surfaceHolder: SurfaceHolder? = null
    var ksPlayerListener: KsPlayerListener? = null
    private var isPlayer = false

    override fun init(baseType: BaseType, context: Context) {

    }

    @Synchronized
    override fun prepare(path: String) {
        this.initPlayer()
        isPlayer = true
        mVideoPlayer!!.setDataSource(path)
        if (isPlayer) mVideoPlayer!!.prepareAsync()
    }

    @Synchronized
    override fun prepare(uri: Uri) {
        this.initPlayer()
        isPlayer = true
        mVideoPlayer!!.setDataSource(uri.path)
        if (isPlayer) mVideoPlayer!!.prepareAsync()
    }

    override fun stop() {
        if (mVideoPlayer != null) {
            if (mVideoPlayer!!.isPlaying()) {
                mVideoPlayer!!.pause()
            }
        }
    }

    override fun start() {
        if (mVideoPlayer != null) {
            mVideoPlayer!!.setDisplay(surfaceHolder)
            mVideoPlayer!!.start()
        }
    }

    override fun destroy() {
        if (mVideoPlayer != null) {
            if (mVideoPlayer!!.isPlaying()) {
                mVideoPlayer!!.stop()
            }
            mVideoPlayer!!.release()
            mVideoPlayer = null
        }
    }

    override fun addSurface(surface: Surface) {
        if (mVideoPlayer != null) {
            mVideoPlayer!!.setSurface(surface)
        }
    }

    override fun addSurfaceHolder(surfaceHolder: SurfaceHolder) {
        this.surfaceHolder = surfaceHolder
        this.surfaceHolder!!.addCallback(this)
    }

    override fun addSurfaceView(surfaceHolder: SurfaceView) {
        this.surfaceHolder = surfaceHolder.holder
        this.surfaceHolder!!.addCallback(this)
    }

    override fun addKsPlayerListener(ksPlayerListener: KsPlayerListener) {
        this.ksPlayerListener = ksPlayerListener
    }

    override fun isLoading(): Boolean {
        return false
    }

    override fun isPlaying(): Boolean {
        return mVideoPlayer!!.isPlaying
    }

    override fun seekTo(positionMs: Long) {
        mVideoPlayer!!.seekTo(positionMs.toInt())
    }

    override fun seekTo(windowIndex: Int, positionMs: Long) {

    }

    override fun getBufferedPosition(): Long {
        return 0
    }

    override fun getCurrentPosition(): Long {
        return mVideoPlayer!!.currentPosition.toLong()
    }

    override fun getTotalBufferedDuration(): Long {
        return 0
    }

    override fun getDuration(): Long {
        return mVideoPlayer!!.duration.toLong()
    }


    private fun initPlayer() {
        if (mVideoPlayer != null) {
            if (mVideoPlayer!!.isPlaying()) {
                mVideoPlayer!!.stop()
            }
            mVideoPlayer!!.reset()
            isPlayer = false
            return
        }
        this.privatePlayer()
    }

    private fun privatePlayer() {
        mVideoPlayer = MediaPlayer()
        mVideoPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mVideoPlayer!!.setVolume(1f, 1f)
        mVideoPlayer!!.setOnPreparedListener(this)
        mVideoPlayer!!.setOnCompletionListener(this)
        mVideoPlayer!!.setOnErrorListener(this)
        mVideoPlayer!!.setOnInfoListener(this)
    }

    override fun onPrepared(mp: MediaPlayer?) {
        mp!!.start()
        ksPlayerListener!!.start()

    }

    override fun onCompletion(mp: MediaPlayer?) {
        if (ksPlayerListener != null) {
            ksPlayerListener!!.complete()
        }

    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        ksPlayerListener!!.error("MediaPlayer" + " what : " + what + " extra " + extra)
        return false
    }

    override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        ksPlayerListener!!.error("MediaPlayer" + " what : " + what + " extra " + extra)
        return false
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        if (mVideoPlayer != null) {
            mVideoPlayer!!.setDisplay(null)
        }

        if (ksPlayerListener != null) {
            ksPlayerListener!!.stop()
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        this.surfaceHolder = holder
        if (mVideoPlayer != null) {
            if (holder != null) {
                mVideoPlayer!!.setDisplay(holder)
                if (ksPlayerListener != null) {
                    ksPlayerListener!!.buffering()
                }
            }
        }
    }

}