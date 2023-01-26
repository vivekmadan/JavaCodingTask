# Java Coding Task
To test the application, please run in the local first.

URL to test the application:
* [Application URL](http://localhost:8080/calculateReward)

Request Method
* POST

###Sample JSON Request:
```json
{
  "purchaseTransactions":[
    {
        "transactionId":1,
        "item":"Soap",
        "price": 10,
        "quantity": 70,
        "totalCost": 50,
        "customerName": "ABC",
        "purchaseDate": "01/26/2020"
    }
  ]
}
```

###Sample JSON Response
```json
{
    "rewards": "50",
    "status": "SUCCESS"
}
```