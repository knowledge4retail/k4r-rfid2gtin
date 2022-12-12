package org.knowledge4retail.rfid2gtin.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.knowledge4retail.rfid2gtin.domain.RfidItem
import org.knowledge4retail.rfid2gtin.domain.RfidTagDetails

internal class RfidTag2GtinServiceImplTests {

    // 0170614141123451
    @ParameterizedTest
    @ValueSource(
        strings = [
            "0578-8490-5051-0914-8916-9793", "0578-8490-5051",
            "100911891694897985874101", "8979-8587-41d1",
        ]
    )
    fun getRfidTagDetailsReturnsDefaultObjectIfTagCouldNotBeParsed(tag: String) {

        val rfidTagDetails = RfidTag2GtinServiceImpl().getRfidTagDetails(RfidItem(tag))
        assertEquals(
            RfidTagDetails(
                "0111111111111",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                tag.replace("-", "").uppercase(),
            ), rfidTagDetails
        )
    }


    @Test
    fun getRfidTagDetailsReturnsNotNullPropertiesIfParseSucceeds() {

        val rfidItem = RfidItem("3014-0bdf-1825-46c0-0006-1a8d")
        val rfidTagDetails = RfidTag2GtinServiceImpl().getRfidTagDetails(rfidItem)

        assertEquals("30140BDF182546C000061A8D", rfidTagDetails.rfidTag)
        assertEquals("AI 414 + AI 254", rfidTagDetails.applicationIdentifier)
        assertEquals(
            "001100000001010000001011110111110001100000100101010001101100000000000000000001100001101010001101",
            rfidTagDetails.binary
        )
        assertEquals("9", rfidTagDetails.checkDigit)
        assertEquals("38171", rfidTagDetails.itemReference)
        assertEquals("0194502", rfidTagDetails.companyPrefix)
        assertEquals("0", rfidTagDetails.extensionDigit)
        assertEquals("0", rfidTagDetails.filterValue)
        assertEquals("5", rfidTagDetails.partitionValue)
        assertEquals("7", rfidTagDetails.prefixLength)
        assertEquals("urn:epc:id:sgtin:0194502.038171.400013", rfidTagDetails.epcPureIdentityURI)
        assertEquals("urn:epc:tag:sgtin-96:0.0194502.038171.400013", rfidTagDetails.epcTagURI)
        assertEquals("urn:epc:raw:96.x30140BDF182546C000061A8D", rfidTagDetails.epcRawURI)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "3014-0BDF-1825-46C0-0006-1A8D", "3014-0BDF-1825-46C0-0006-1A8d",
            "3014-0bdf-1825-46c0-0006-1a8d", "30140BDF182546C000061A8D",
        ]
    )
    fun getRfidTagDetailsAcceptsDifferentRFIDTagsFormats(rfidTag: String) {

        RfidItem(rfidTag)
        val productItemDetails = RfidTag2GtinServiceImpl().getRfidTagDetails(rfidItem = RfidItem(rfidTag))

        assertEquals(productItemDetails.rfidTag, "30140BDF182546C000061A8D")

    }

    @ParameterizedTest
    @CsvSource
        (
        "3014-0BDF-1825-46C0-0006-1A8D, 0194502381719",
        "3014-0BDF-1825-46C0-0006-1A8E, 0194502381719",
        "3014-0BDF-1825-46C0-0006-1A8F, 0194502381719"
    )
    fun getRfidTagDetailsReturnsCorrectGtin(rfidTag: String, expectedGtin: String) {

        val rfidItem = RfidItem(rfidTag)

        val itemDetails = RfidTag2GtinServiceImpl().getRfidTagDetails(rfidItem)

        assertEquals(expectedGtin, itemDetails.gtin)
    }


}
