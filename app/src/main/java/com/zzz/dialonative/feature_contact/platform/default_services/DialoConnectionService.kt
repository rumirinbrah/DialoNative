package com.zzz.dialonative.feature_contact.platform.default_services

import android.telecom.Connection
import android.telecom.ConnectionRequest
import android.telecom.ConnectionService
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager

class DialoConnectionService : ConnectionService() {

    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle? ,
        request: ConnectionRequest?
    ): Connection {
        val connection = DialoConnection()
        connection.setAddress(request?.address,TelecomManager.PRESENTATION_ALLOWED)
        connection.setInitializing()
        connection.setActive()


        return connection
    }

    override fun onCreateIncomingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle? ,
        request: ConnectionRequest?
    ): Connection {
        val connection = DialoConnection()
        connection.setAddress(request?.address , TelecomManager.PRESENTATION_ALLOWED)
        connection.setRinging()

        return connection
    }

}