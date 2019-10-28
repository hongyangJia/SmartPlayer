package com.ks.base_player

/**
 * created by hongyang on 19-10-25
 */
interface KsPlayerListener {

    fun complete()

    fun buffering()

    fun error(message: String)

    fun stop()

    fun start()
}