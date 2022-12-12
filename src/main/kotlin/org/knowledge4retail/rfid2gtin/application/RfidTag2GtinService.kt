package org.knowledge4retail.rfid2gtin.application

import org.knowledge4retail.rfid2gtin.domain.RfidTagDetails
import org.knowledge4retail.rfid2gtin.domain.RfidItem

interface RfidTag2GtinService {

    fun getRfidTagDetails(rfidItem: RfidItem): RfidTagDetails

}