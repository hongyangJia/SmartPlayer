package com.ks.base_player

import android.content.Context
import android.net.Uri
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.ks.base_player.KsPlayerListener
import java.net.URI

/**
 * created by hongyang on 19-10-25
 */
interface KsBasePlayer {

    fun init(baseType: BaseType, context: Context)

    fun prepare(path: String)

    fun prepare(uri: Uri)

    fun stop()

    fun start()

    fun seekTo(positionMs: Long)

    fun seekTo(windowIndex: Int, positionMs: Long)

    fun destroy()

    fun isLoading(): Boolean

    fun isPlaying(): Boolean

    fun addSurface(surface: Surface)

    fun addSurfaceHolder(surfaceHolder: SurfaceHolder)

    fun addSurfaceView(surfaceHolder: SurfaceView)

    fun addKsPlayerListener(ksPlayerListener: KsPlayerListener)

    fun getBufferedPosition(): Long

    fun getCurrentPosition(): Long

    fun getTotalBufferedDuration(): Long

    fun getDuration(): Long

}