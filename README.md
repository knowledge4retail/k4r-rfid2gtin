# Rfid Tags to GTIN Converter

A simple webservice to convert RFID tags to GTINs.

## Description

A simple webservice built with [Kotlin](https://kotlinlang.org/) and [Spring Boot](https://spring.io/projects/spring-boot) to extract metadata from RFID tags. 

## Getting Started

### Dependencies

The project uses the external library [epctagcoder-0.0.9-SNAPSHOT.jar](https://github.com/jlcout/epctagcoder)

When building with Docker, the jar needs to be manually added to maven repository using the following command:

`RUN mvn install:install-file -Dfile="src/main/resources/epctagcoder-0.0.9-SNAPSHOT.jar"`


### Usage

#### Service Name

the service is reachable inside the cluster using the service name `k4r-rfid2gtin` and the port `8080`

####Sample input:

```bash
curl -X 'POST' \
  'http://k4r-rfid2gtin:8080/rfidTags' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '[
{"rfidTag":"3005-FB63-AC1F-3841-EC88-0467"},
{"rfidTag":"300E-D89F-3350-007F-C46C-C4CC"},
{"rfidTag":"3014-0BD1-D820-6A00-0006-1A8B"},
{"rfidTag":"3014-0BD1-D820-6A40-0006-1A94"},
{"rfidTag":"3014-0BD1-D820-6A40-0006-1A95"}
]'
```

####Sample output:
```json
[
  {
    "gtin": "6810064511377",
    "extensionDigit": "9",
    "companyPrefix": "68100645113",
    "itemReference": "7",
    "checkDigit": "7",
    "serial": "8263304295",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "11",
    "partitionValue": "1",
    "epcPureIdentityURI": "urn:epc:id:sgtin:68100645113.97.8263304295",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.68100645113.97.8263304295",
    "epcRawURI": "urn:epc:raw:96.x3005FB63AC1F3841EC880467",
    "binary": "001100000000010111111011011000111010110000011111001110000100000111101100100010000000010001100111",
    "rfidTag": "3005FB63AC1F3841EC880467"
  },
  {
    "gtin": "7640154130012",
    "extensionDigit": "0",
    "companyPrefix": "764015413",
    "itemReference": "001",
    "checkDigit": "2",
    "serial": "273878402252",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "9",
    "partitionValue": "3",
    "epcPureIdentityURI": "urn:epc:id:sgtin:764015413.0001.273878402252",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.764015413.0001.273878402252",
    "epcRawURI": "urn:epc:raw:96.x300ED89F3350007FC46CC4CC",
    "binary": "001100000000111011011000100111110011001101010000000000000111111111000100011011001100010011001100",
    "rfidTag": "300ED89F3350007FC46CC4CC"
  },
  {
    "gtin": "0193654331924",
    "extensionDigit": "0",
    "companyPrefix": "0193654",
    "itemReference": "33192",
    "checkDigit": "4",
    "serial": "400011",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "7",
    "partitionValue": "5",
    "epcPureIdentityURI": "urn:epc:id:sgtin:0193654.033192.400011",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.0193654.033192.400011",
    "epcRawURI": "urn:epc:raw:96.x30140BD1D8206A0000061A8B",
    "binary": "001100000001010000001011110100011101100000100000011010100000000000000000000001100001101010001011",
    "rfidTag": "30140BD1D8206A0000061A8B"
  },
  {
    "gtin": "0193654331931",
    "extensionDigit": "0",
    "companyPrefix": "0193654",
    "itemReference": "33193",
    "checkDigit": "1",
    "serial": "400020",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "7",
    "partitionValue": "5",
    "epcPureIdentityURI": "urn:epc:id:sgtin:0193654.033193.400020",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.0193654.033193.400020",
    "epcRawURI": "urn:epc:raw:96.x30140BD1D8206A4000061A94",
    "binary": "001100000001010000001011110100011101100000100000011010100100000000000000000001100001101010010100",
    "rfidTag": "30140BD1D8206A4000061A94"
  },
  {
    "gtin": "0193654331931",
    "extensionDigit": "0",
    "companyPrefix": "0193654",
    "itemReference": "33193",
    "checkDigit": "1",
    "serial": "400021",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "7",
    "partitionValue": "5",
    "epcPureIdentityURI": "urn:epc:id:sgtin:0193654.033193.400021",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.0193654.033193.400021",
    "epcRawURI": "urn:epc:raw:96.x30140BD1D8206A4000061A95",
    "binary": "001100000001010000001011110100011101100000100000011010100100000000000000000001100001101010010101",
    "rfidTag": "30140BD1D8206A4000061A95"
  },
  {
    "gtin": "0193654331948",
    "extensionDigit": "0",
    "companyPrefix": "0193654",
    "itemReference": "33194",
    "checkDigit": "8",
    "serial": "400020",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "7",
    "partitionValue": "5",
    "epcPureIdentityURI": "urn:epc:id:sgtin:0193654.033194.400020",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.0193654.033194.400020",
    "epcRawURI": "urn:epc:raw:96.x30140BD1D8206A8000061A94",
    "binary": "001100000001010000001011110100011101100000100000011010101000000000000000000001100001101010010100",
    "rfidTag": "30140BD1D8206A8000061A94"
  },
  {
    "gtin": "0193654331948",
    "extensionDigit": "0",
    "companyPrefix": "0193654",
    "itemReference": "33194",
    "checkDigit": "8",
    "serial": "400021",
    "applicationIdentifier": "AI 414 + AI 254",
    "filterValue": "0",
    "prefixLength": "7",
    "partitionValue": "5",
    "epcPureIdentityURI": "urn:epc:id:sgtin:0193654.033194.400021",
    "epcTagURI": "urn:epc:tag:sgtin-96:0.0193654.033194.400021",
    "epcRawURI": "urn:epc:raw:96.x30140BD1D8206A8000061A95",
    "binary": "001100000001010000001011110100011101100000100000011010101000000000000000000001100001101010010101",
    "rfidTag": "30140BD1D8206A8000061A95"
  }
]
```

#### Important note

When the input (rfidTag) cannot be parsed, the response will contain a default gtin value of  `0111111111111`. 




## Version History

`0.0.1` initial pre-release
`0.1.0` removed unnecessary maven dependencies

## License

