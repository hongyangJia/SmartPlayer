package com.ks.h_decode.exo

import android.content.Context
import android.net.Uri
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.ks.base_player.BaseType
import com.ks.base_player.KsBasePlayer
import com.ks.base_player.KsPlayerListener

/**
 * created by hongyang on 19-10-25
 */
class KsExoPlayer : KsBasePlayer {

    var dataSourceFactory: DataSource.Factory? = null
    var player: SimpleExoPlayer? = null

    override fun init(baseType: BaseType, context: Context) {
        this.defaultExoPlayerFactory(context)
        this.defaultDataSourceFactory(context)
    }

    override fun prepare(uri: Uri) {
        player!!.prepare(createMediaSource(uri))
        start()
    }

    override fun prepare(path: String) {
        player!!.prepare(createMediaSource(Uri.parse(path)))
        start()
    }

    override fun start() {
        player!!.playWhenReady = true
    }

    override fun stop() {
        player!!.playWhenReady = false
    }

    override fun isLoading(): Boolean {
        return player!!.isLoading
    }

    override fun isPlaying(): Boolean {
        return player!!.isPlaying
    }

    override fun destroy() {
        player!!.stop()
        player!!.release()
    }

    override fun addSurface(surface: Surface) {
        player!!.setVideoSurface(surface)
    }

    override fun addSurfaceHolder(surfaceHolder: SurfaceHolder) {
        player!!.setVideoSurfaceHolder(surfaceHolder)
    }

    override fun addSurfaceView(surfaceView: SurfaceView) {
        player!!.setVideoSurfaceView(surfaceView)
    }

    override fun addKsPlayerListener(ksPlayerListener: KsPlayerListener) {
        player!!.addListener(KsExoEventListener(ksPlayerListener))
    }

    override fun getBufferedPosition(): Long {
        return player!!.getBufferedPosition()
    }

    override fun getCurrentPosition(): Long {
        return player!!.getCurrentPosition()
    }

    override fun getTotalBufferedDuration(): Long {
        return player!!.getTotalBufferedDuration()
    }

    override fun getDuration(): Long {
        return player!!.getDuration()
    }

    override fun seekTo(positionMs: Long) {
        player!!.seekTo(positionMs)
    }

    override fun seekTo(windowIndex: Int, positionMs: Long) {
        player!!.seekTo(windowIndex, positionMs)
    }

    fun createMediaSource(uri: Uri): MediaSource {
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
    }

    fun defaultExoPlayerFactory(context: Context) {
        player = ExoPlayerFactory.newSimpleInstance(context)
    }

    fun defaultDataSourceFactory(context: Context) {
        dataSourceFactory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "KsMediaPlayer")
        )
    }
}