package com.ks.h_decode

import android.content.Context
import android.net.Uri
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.ks.base_player.BaseType
import com.ks.base_player.KsBasePlayer
import com.ks.base_player.KsPlayerListener
import com.ks.h_decode.effects.KsEffectPlayer
import com.ks.h_decode.exo.KsExoPlayer
import com.ks.h_decode.media.KsMediaPlayer

/**
 * created by hongyang on 19-10-25
 */
class KsGracePlayer : KsBasePlayer {

    private lateinit var ksBasePlayer: KsBasePlayer

    override fun init(baseType: BaseType, context: Context) {
        when (baseType) {
            BaseType.EXO,
            BaseType.LIVE ->
                ksBasePlayer = KsExoPlayer()
            BaseType.MEDIA ->
                ksBasePlayer = KsMediaPlayer()
            BaseType.EFFECTS ->
                ksBasePlayer = KsEffectPlayer()
        }
        ksBasePlayer.init(baseType, context)
    }

    override fun prepare(path: String) {
        ksBasePlayer.prepare(path)
    }

    override fun prepare(uri: Uri) {
        ksBasePlayer.prepare(uri)
    }

    override fun stop() {
        ksBasePlayer.stop()
    }

    override fun start() {
        ksBasePlayer.start()
    }


    override fun isLoading(): Boolean {
        return ksBasePlayer.isLoading()
    }

    override fun isPlaying(): Boolean {
        return ksBasePlayer.isPlaying()
    }

    override fun destroy() {
        ksBasePlayer.destroy()
    }

    override fun addSurface(surface: Surface) {
        ksBasePlayer.addSurface(surface)
    }

    override fun addSurfaceHolder(surfaceHolder: SurfaceHolder) {
        ksBasePlayer.addSurfaceHolder(surfaceHolder)
    }

    override fun addSurfaceView(surfaceHolder: SurfaceView) {
        ksBasePlayer.addSurfaceView(surfaceHolder)
    }

    override fun addKsPlayerListener(ksPlayerListener: KsPlayerListener) {
        ksBasePlayer.addKsPlayerListener(ksPlayerListener)
    }

    override fun seekTo(positionMs: Long) {
        ksBasePlayer.seekTo(positionMs)
    }

    override fun seekTo(windowIndex: Int, positionMs: Long) {
        ksBasePlayer.seekTo(windowIndex, positionMs)
    }

    override fun getBufferedPosition(): Long {
        return ksBasePlayer.getBufferedPosition()
    }

    override fun getCurrentPosition(): Long {
        return ksBasePlayer.getCurrentPosition()
    }

    override fun getTotalBufferedDuration(): Long {
        return ksBasePlayer.getTotalBufferedDuration()
    }

    override fun getDuration(): Long {
        return ksBasePlayer.getDuration()
    }

}