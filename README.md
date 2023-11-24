# Getting Started

Hi, This project is a SpringBoot application. You can start it using this class: FindClosestShopsApplication.java


## Example request and response

URL: http://localhost:8080/v1/find-store/lat-long/51.6158/9

Result:
```json
[
    {
        "city": "Glanerbrug",
        "postalCode": "7534 CC",
        "street": "Schoolstraat",
        "street2": "60",
        "addressName": "Jumbo Glanerbrug Lochan",
        "longitude": 6.970179,
        "latitude": 52.212865,
        "collectionPoint": true
    },
    {
        "city": "Losser",
        "postalCode": "7581 JB",
        "street": "De Brink",
        "street2": "46",
        "addressName": "Jumbo Losser De Brink",
        "longitude": 7.006359,
        "latitude": 52.261236,
        "collectionPoint": false
    },
    {
        "city": "Enschede",
        "postalCode": "7544 JB",
        "street": "Wesselernering",
        "street2": "21",
        "addressName": "Jumbo Enschede Wesselernering",
        "longitude": 6.880051,
        "latitude": 52.191539,
        "collectionPoint": true
    },
    {
        "city": "Enschede",
        "postalCode": "7511 EK",
        "street": "Noorderhagen",
        "street2": "75",
        "addressName": "Jumbo Enschede Irene Promenade",
        "longitude": 6.898243,
        "latitude": 52.22135,
        "collectionPoint": false
    },
    {
        "city": "Enschede",
        "postalCode": "7543 AB",
        "street": "Burgemeester van Veenlaan",
        "street2": "100",
        "addressName": "Jumbo Enschede Burgemeester van Veenlaan",
        "longitude": 6.878991,
        "latitude": 52.206207,
        "collectionPoint": true
    }
]
```