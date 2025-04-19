package com.zzz.dialonative.feature_contact.platform.phone_account

import android.content.ComponentName
import android.content.Context
import android.telecom.PhoneAccount
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.zzz.dialonative.core.presentation.util.LogTags
import com.zzz.dialonative.feature_contact.domain.system.PhoneAccountHandler
import com.zzz.dialonative.feature_contact.platform.call_service.util.CallConstants
import com.zzz.dialonative.feature_contact.platform.default_services.DialoConnectionService

class TelecomPhoneAccountHandler(
    private val context: Context
) : PhoneAccountHandler {

    override fun registerPhoneAccount() {

        val manager = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
        val accHandle = PhoneAccountHandle(
            ComponentName(context , DialoConnectionService::class.java) ,
            CallConstants.ACCOUNT_HANDLE_ID
        )
        val isRegistered = manager.getPhoneAccount(accHandle) != null

        if (!isRegistered) {
            Log.d(LogTags.PH_ACC_HANDLER , "registerPhoneAccount: Registering phone account...")

            val phoneAccount = PhoneAccount
                .builder(
                    accHandle ,
                    CallConstants.PHONE_ACCOUNT_LABEL
                )
                .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER)
                .setHighlightColor(Color.Green.toArgb())
                .build()
            manager.registerPhoneAccount(phoneAccount)
        }else{
            Log.d(LogTags.PH_ACC_HANDLER, "registerPhoneAccount: Phone account already registered")
        }
    }
}