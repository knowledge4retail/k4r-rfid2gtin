package org.knowledge4retail.rfid2gtin.domain

//  ISO 18000-63-6 (EPC)
class RfidItem(rfidTag: String) {
    var rfidTag: String

    init {
        this.rfidTag = rfidTag.replace("-", "").uppercase()
    }

}
