package com.ks.smart_player

import android.content.Context
import com.ks.base_player.BaseType
import com.ks.h_decode.KsGracePlayer

/**
 * created by hongyang on 19-10-25
 */
interface Player<out Product> {
    fun create(kkConfig: KKConfig, context: Context): Product
}

interface Builder<out T> {
    fun build(context: Context): T
}

class KKSmartPlayer : Player<KsGracePlayer> {

    override fun create(kkConfig: KKConfig, context: Context): KsGracePlayer {
        val ksGracePlayer = KsGracePlayer()
        ksGracePlayer.init(kkConfig.baseType!!, context)
        return ksGracePlayer
    }

}

object KKSmartBuilder : Builder<KsGracePlayer> {

    private var kkConfig = KKConfig()

    override fun build(context: Context): KsGracePlayer {
        return KKSmartPlayer().create(kkConfig, context)
    }

    fun type(baseType: BaseType): KKSmartBuilder {
        kkConfig.baseType = baseType
         return this
    }

}


