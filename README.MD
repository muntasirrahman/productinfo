<h1 align="center">Product Info</h1>

This is a trivial demo of microservice implementation using Spring Boot.

## Prerequisite Software

* Java SDK version 8 or above
* Gradle
* Spring Boot

## Download and Install This

*Clone this project*

`git clone https://github.com/muntasirrahman/productinfo.git`

To compile, type: 
`./gradlew build`

To Run, type: `./gradlew bootRun`

## Features

* Add new product data
* Find product detail

## Design

This app uses a typical 2020 microservice tiers:

* Controller
* Service
* Persistence

### Find one or more Product Details
Using curl, copy and paste this:

```shell script
curl -X POST 'http://localhost:8080/api/products' \
-H 'Content-Type: application/json' \
--data-raw '{
  "id": 123,
  "timestamp": "2020-03-01T08:59:59.000+0000",
  "products": [
    {
      "id": "7"
    },
    {
      "id": "6"
    }
  ]
}'
```

### Add New Product Details

```shell script
curl -X PUT 'http://localhost:8080/api/products' \
-H 'Content-Type: application/json' \
--data-raw '{
    "id": 123,
    "timestamp": "2020-03-01T16:51:00",
    "products": [
        {
            "id": "7",
            "name": "Lenovo Thinkpad",
            "quantity": "1",
            "sale_amount": "2300.00"
        },
        {
            "id": "8",
            "name": "Alienware Area-51m",
            "quantity": "2",
            "sale_amount": "3978.50"
        }
    ]
}'
```


## Test

#### Data Persistence Tier -- Unit Test

```shell script
./gradlew :cleanTest :test --tests "com.pensil.lab.productinfo.ProductRepositoryTest"
```

#### Service Tier -- Unit Test

```shell script
./gradlew :cleanTest :test --tests "com.pensil.lab.productinfo.ProductServiceTest"
```

#### Controller Tier -- Integration Test

```shell script
./gradlew :cleanTest :test --tests "com.pensil.lab.productinfo.ProductControllerTest"
```