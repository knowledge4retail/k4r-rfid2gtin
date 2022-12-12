package org.knowledge4retail.rfid2gtin.infrastructure

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.knowledge4retail.rfid2gtin.application.RfidTag2GtinService
import org.knowledge4retail.rfid2gtin.domain.RfidItem
import org.knowledge4retail.rfid2gtin.domain.RfidTagDetails
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@Controller
class ConverterController(private val converter: RfidTag2GtinService) {

    @Operation(description = "Convert RFID Tags to GTIN")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation")
        ]
    )
    @PostMapping("/rfidTags", consumes = ["application/json"])
    fun rfidsToGtins(@Valid @RequestBody rfids: List<RfidItem>): ResponseEntity<List<RfidTagDetails>> {

        return ResponseEntity.ok(rfids.map { converter.getRfidTagDetails(it) })
    }

}