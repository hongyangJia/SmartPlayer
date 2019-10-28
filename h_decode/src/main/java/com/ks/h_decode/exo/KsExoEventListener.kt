package com.ks.h_decode.exo

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.ks.base_player.KsPlayerListener

/**
 * created by hongyang on 19-10-25
 */
class KsExoEventListener : Player.EventListener {

    var ksPlayerListener: KsPlayerListener

    constructor(ksPlayerListener: KsPlayerListener) {
        this.ksPlayerListener = ksPlayerListener
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if (playWhenReady && playbackState == Player.STATE_READY) {
            // Active playback.
            ksPlayerListener.start()
        } else if (playWhenReady) {
            // Not playing because playback ended, the player is buffering, stopped or
            // failed. Check playbackState and player.getPlaybackError for details.
            if (playbackState == Player.STATE_ENDED) {
                ksPlayerListener.complete()
            }

            if (playbackState == Player.STATE_BUFFERING) {
                ksPlayerListener.buffering()
            }
        } else {
            // Paused by app.
            ksPlayerListener.stop()
        }
    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        ksPlayerListener.error(error!!.message!!)
    }

}