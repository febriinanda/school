# User API Specs
## User Registration
Endpoint : POST /api/users

Request Body :
```json
{
  "username": "febriinanda",
  "password": "encrypted_must",
  "name": "Febrinanda Endriz Pratama"
}
```

Response Body (Success) :
```json
{
  "data": "OK"
}
```

Response Body (Failed) :
```json
{
  "data": "Not OK",
  "messages": "Username already used, ..."
}
```