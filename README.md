# transactions API
API REST Application to create and get transactions from a spring-boot backend 

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

## Usage

```bash
Create transaction:

[POST] http://localhost:8080/api/transactions/user/{userId}
Body:
{
    "amount": 3.14,
     "description": "Tacos El Marrano"
}
```

```bash

GetTransactionById:

[GET] http://localhost:8080/api/transactions/{transactionId}/user/{userId}

```

```bash

GetAllTransactionsById:

[GET] http://localhost:8080/api/transactions/user/{userId}

```
```bash

GetTransactionsSumById:

[GET] http://localhost:8080/api/transactions/user/{userId}/sum

```
```bash

GetRandomTransaction:

[GET] http://localhost:8080/api/transactions/random

```