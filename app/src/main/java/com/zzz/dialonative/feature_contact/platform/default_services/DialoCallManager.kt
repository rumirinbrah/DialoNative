package com.zzz.dialonative.feature_contact.platform.default_services

import android.Manifest
import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager
import androidx.core.content.ContextCompat
import com.zzz.dialonative.feature_contact.domain.system.CallManager
import com.zzz.dialonative.feature_contact.platform.call_service.util.CallConstants

class DialoCallManager(
    private val context : Context
) : CallManager {

    private fun getAccountHandle() : PhoneAccountHandle{
        return PhoneAccountHandle(
            ComponentName(context, DialoConnectionService::class.java),
            CallConstants.ACCOUNT_HANDLE_ID
        )
    }

    @SuppressLint("MissingPermission")
    override fun placeCall(number: String) {
        val uri = Uri.parse("tel:$number")

        val extras = Bundle().apply {
            putParcelable(TelecomManager.EXTRA_PHONE_ACCOUNT_HANDLE,getAccountHandle())
        }
        val manager = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager

        if(!hasCallPermission()){
            return
        }else{
            manager.placeCall(uri,extras)
        }

    }

    private fun hasCallPermission() : Boolean{
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }
}