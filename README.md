# article-manager
Article manager, that add article, update article, find article, and delete article

![sequence diagram for article-manager](https://raw.githubusercontent.com/mariobgsp/article-manager/main/article-manager.png)

## Endpoint API
### GET /articles/all?page={page}&size={size} 
Sample Request
```
curl --location 'http://127.0.0.1:8080/articles/all?page=2&size=3' \
--header 'Authorization: {authorization}' \
--header 'Content-Type: application/json' \
```

Sample Response
```
{
    "message": "Request Success",
    "code": "00",
    "status": "Success",
    "data": [
        {
            "id": 4,
            "title": "The Impact of Augmented Reality in Healthcare",
            "body": "Augmented Reality (AR) applications revolutionize healthcare, offering innovative solutions for medical training and patient care.",
            "author": "Diana Miller"
        },
        {
            "id": 5,
            "title": "Renewable Energy: Harnessing the Power of the Sun",
            "body": "Solar energy gains prominence as a clean and renewable source of power, driving the transition to sustainable energy solutions.",
            "author": "Eric Turner"
        },
        {
            "id": 6,
            "title": "The Role of Blockchain in Financial Services",
            "body": "Blockchain technology transforms the financial services industry, offering secure and decentralized solutions for transactions.",
            "author": "Fiona White"
        }
    ]
}
```

### GET /articles/{id}

Sample Request
```
curl --location 'http://127.0.0.1:8080/articles/3' \
--header 'Authorization: {authorization}' \
--header 'Content-Type: application/json' \
```

Sample Response
HTTP 200 OK
```
{
    "message": "Request Success",
    "code": "00",
    "status": "Success",
    "data": [
        {
            "id": 3,
            "title": "Digital Transformation in Education",
            "body": "Education undergoes a digital transformation, with the integration of technology enhancing learning experiences.",
            "author": "Charlie Davis"
        }
    ]
}
```

### POST /articles/add
Sample Request
```
curl --location 'http://127.0.0.1:8080/articles/add' \
--header 'Authorization: {authorization}' \
--header 'Content-Type: application/json' \
--data '{
      "title": "Advancements in Quantum Computing",
      "body": "Scientists achieve breakthroughs in quantum computing. The new technology promises to revolutionize the field of computation.",
      "author": "Alex Rodriguez"
    }'
```
Sample Response
HTTP 200 OK
```
{
    "message": "Request Success",
    "code": "00",
    "status": "Success",
    "data": {
        "id": 23,
        "title": "Advancements in Quantum Computing",
        "body": "Scientists achieve breakthroughs in quantum computing. The new technology promises to revolutionize the field of computation.",
        "author": "Alex Rodriguez"
    },
    "error": null
}
```

### POST /articles/update/{id}
Sample Request
```
curl --location 'http://127.0.0.1:8080/articles/update/3' \
--header 'Authorization: {authorization}' \
--header 'Content-Type: application/json' \
--data '{
      "title": "Advancements in Quantum Computing",
      "body": "Scientists achieve breakthroughs in quantum computing. The new technology promises to revolutionize the field of computation.",
      "author": "Alex Rodriguez"
    }'
```
Sample Response
HTTP 200 OK
```
{
    "message": "Article Updated Successfully",
    "code": "00",
    "status": "Success"
}
```

### POST /articles/delete
Sample Request
```
curl --location --request DELETE 'http://127.0.0.1:8080/articles/delete/3' \
--header 'Authorization: {authorization}' \
--header 'Content-Type: application/json' \
```
Sample Response
HTTP 200 OK
```
{
    "message": "Article Deleted Successfully",
    "code": "00",
    "status": "Success"
}
```

#### Error Response
HTTP 404 NOT FOUND
```
{
    "message": "Request Failed",
    "code": "01",
    "status": "Business Error",
    "error": "Article not found"
}
```
HTTP 401 UNAUTHORIZED
```
{
    "message": "Request Failed",
    "code": "01",
    "status": "Business Error",
    "error": "Unauthorized"
}
```
HTTP 409 Duplicate
```
{
    "message": "Request Failed",
    "code": "01",
    "status": "Business Error",
    "error": "Title already exist"
}
```

