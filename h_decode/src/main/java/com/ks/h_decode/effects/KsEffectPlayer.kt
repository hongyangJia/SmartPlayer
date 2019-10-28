package com.ks.h_decode.effects

import android.content.Context
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
class KsEffectPlayer: KsBasePlayer {
    override fun seekTo(positionMs: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun seekTo(windowIndex: Int, positionMs: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isLoading(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPlaying(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBufferedPosition(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentPosition(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTotalBufferedDuration(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDuration(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init(baseType: BaseType, context: Context) {

    }

    override fun prepare(path: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun prepare(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addSurface(surface: Surface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addSurfaceHolder(surfaceHolder: SurfaceHolder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addSurfaceView(surfaceHolder: SurfaceView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addKsPlayerListener(ksPlayerListener: KsPlayerListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}