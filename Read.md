This is an application that takes a user for a particullar contest.Maintains the user details and gives the output of the leaderboard. 

Postman Collection
{
"info": {
"_postman_id": "db38dd13-d1b4-4b5e-a839-1853388826b5",
"name": "CoderHack",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
"_exporter_id": "38841135"
},
"item": [
{
"name": "New Request",
"request": {
"method": "GET",
"header": []
},
"response": []
},
{
"name": "New Request",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\r\n   \r\n    \"username\": \"john_doe\",\r\n    \"score\": 0,\r\n    \"badges\": []\r\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8081/users/add",
"protocol": "http",
"host": [
"localhost"
],
"port": "8081",
"path": [
"users",
"add"
]
}
},
"response": []
},
{
"name": "New Request",
"request": {
"method": "GET",
"header": []
},
"response": []
},
{
"name": "New Request",
"request": {
"method": "GET",
"header": []
},
"response": []
},
{
"name": "New Request",
"request": {
"method": "GET",
"header": []
},
"response": []
}
]
}