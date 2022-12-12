package org.knowledge4retail.rfid2gtin.application

import mu.KLogging
import org.epctagcoder.parse.SGTIN.ParseSGTIN
import org.knowledge4retail.rfid2gtin.domain.RfidTagDetails
import org.knowledge4retail.rfid2gtin.domain.RfidItem
import org.springframework.stereotype.Component

private val logger = KLogging().logger

@Component
class RfidTag2GtinServiceImpl : RfidTag2GtinService {

    override fun getRfidTagDetails(rfidItem: RfidItem): RfidTagDetails {

        try {

            val sgtin = ParseSGTIN.Builder()
                .withRFIDTag(rfidItem.rfidTag)
                .build().sgtin

            val gtin = sgtin!!.companyPrefix + sgtin.itemReference + sgtin.checkDigit

            return RfidTagDetails(
                gtin,
                sgtin.extensionDigit,
                sgtin.companyPrefix,
                sgtin.itemReference,
                sgtin.checkDigit,
                sgtin.serial,
                sgtin.applicationIdentifier,
                sgtin.filterValue,
                sgtin.prefixLength,
                sgtin.partitionValue,
                sgtin.epcPureIdentityURI,
                sgtin.epcTagURI,
                sgtin.epcRawURI,
                sgtin.binary,
                sgtin.rfidTag ?: rfidItem.rfidTag
            )
        } catch (e: Exception) {
            logger.info("RFID: ${rfidItem.rfidTag} is an invalid EPC. Parsing caused an Exception: $e")
            return RfidTagDetails(rfidTag = rfidItem.rfidTag)
        }

    }

}