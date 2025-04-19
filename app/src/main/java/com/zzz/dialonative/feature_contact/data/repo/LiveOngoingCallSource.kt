package com.zzz.dialonative.feature_contact.data.repo

import android.telecom.Connection
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.feature_contact.domain.source.OngoingCallSource

class LiveOngoingCallSource : OngoingCallSource {

    private var contact : Contact? = null
    private var connection : Connection? = null

    override fun updateOngoingContact(contact: Contact) {
        this.contact = contact
    }

    override fun getCurrentContact(): Contact? {
        return contact
    }
}