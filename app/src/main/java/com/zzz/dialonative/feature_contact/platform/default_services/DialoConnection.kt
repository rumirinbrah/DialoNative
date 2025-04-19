package com.zzz.dialonative.feature_contact.platform.default_services

import android.telecom.Connection
import android.telecom.DisconnectCause

class DialoConnection : Connection() {

    //can handle answer , disconnect , hold , etc here

    override fun onAnswer() {
        setActive()
        //super.onAnswer()
    }

    override fun onReject() {
        setDisconnected(DisconnectCause(DisconnectCause.REJECTED))
        destroy()
    }

    override fun onDisconnect() {
        setDisconnected(DisconnectCause(DisconnectCause.LOCAL))
        destroy()
    }

    override fun onAbort() {
        setDisconnected(DisconnectCause(DisconnectCause.CANCELED))
        destroy()
    }

    override fun onHold() {
        setOnHold()
    }

    override fun onUnhold() {
        setActive()
    }

    override fun onMuteStateChanged(isMuted: Boolean) {
        super.onMuteStateChanged(isMuted)
        //update repo
    }




}