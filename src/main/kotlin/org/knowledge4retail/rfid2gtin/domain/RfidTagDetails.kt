package org.knowledge4retail.rfid2gtin.domain

data class RfidTagDetails(
    val gtin: String = "0111111111111",
    val extensionDigit: String = "",
    val companyPrefix: String = "",
    val itemReference: String = "",
    val checkDigit: String = "",
    val serial: String = "",
    val applicationIdentifier: String = "",
    val filterValue: String = "",
    val prefixLength: String = "",
    val partitionValue: String = "",
    val epcPureIdentityURI: String = "",
    val epcTagURI: String = "",
    val epcRawURI: String = "",
    val binary: String = "",
    val rfidTag: String = "",
)
{
    init {
        require(gtin.matches(Regex("^(\\d{08,14})\$"))) { "GTIN must be 08-14 digits long" }
        }
}
