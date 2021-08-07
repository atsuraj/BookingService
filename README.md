# BookingService

## Solution
 ---
 
### API's

```
Get All booking
Url: http://localhost:8080/v1/bfs/booking/
Method: GET
Response: [
    {
        "id": 1,
        "first_name": "Sherlock",
        "last_name": "Holmes",
        "date_of_birth": "20-07-1994",
        "address": {
            "line1": "221B",
            "line2": "Baker Street",
            "city": "London",
            "state": "London",
            "country": "England",
            "zipcode": "201301"
        }
    }
]
```

```
Create New Booking
Url:http://localhost:8080/v1/bfs/booking
Method: PUT
Request: {
	"first_name":"Sherlock",
	"last_name": "Holmes",
	"date_of_birth":"06-01-1854",
    "deposit":100.00,
    "checked_in":"05-09-2021",
    "random" :"",
	"address":{
		"line1":"line1",
		"line2":"line2",
		"city":"Bangalore",
		"state":"Karnataka",
		"country":"india",
		"zipcode":"560037"
		}
	}

```

### Idempotency
This logic is applied on basis of first and last name. If both are same then we get exception saying booking exist for that user.
