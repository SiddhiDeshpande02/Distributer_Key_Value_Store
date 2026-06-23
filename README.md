# Distributed Key-Value Store with Consistent Hashing

A distributed key-value store built in Java that supports multi-node data storage and retrieval using consistent hashing. The project demonstrates core distributed systems concepts such as partitioning, request routing, concurrency, and scalability.

## Features

* PUT, GET, and DELETE operations
* Multi-node architecture
* Consistent hashing for key partitioning
* TCP socket-based client-server communication
* Thread-safe in-memory storage using `ConcurrentHashMap`
* Dynamic key routing to responsible nodes
* Concurrent request handling with multithreading
* Scalable design inspired by DynamoDB and Cassandra

## Project Structure

```
src
│
├── Main.java
├── Node1.java
├── Node2.java
├── Node3.java
├── InteractiveClient.java
│
├── client
│     └── KVClient.java
│
├── hash
│     ├── ConsistentHashRing.java
│     └── HashUtil.java
│
├── model
│     └── Node.java
│
├── network
│     ├── ClientHandler.java
│     └── ServerNode.java
│
└── storage
      └── KeyValueStore.java
```

## Architecture

```
                Client
                   |
                   ▼
        +---------------------+
        | Consistent Hash Ring |
        +---------------------+
             /      |      \
            ▼       ▼       ▼
        Node1    Node2    Node3
         5001     5002     5003
```

Keys are mapped to nodes using SHA-256-based consistent hashing, minimizing data movement when nodes are added or removed.

## Technologies Used

* Java
* TCP Sockets
* Multithreading
* ConcurrentHashMap
* SHA-256 Hashing
* Consistent Hashing
* Client-Server Architecture

## Supported Commands

### PUT

```
PUT name Sid
```

Response:

```
OK
```

### GET

```
GET name
```

Response:

```
Sid
```

### DELETE

```
DELETE name
```

Response:

```
Deleted
```

## Running the Project

### Compile

```bash
javac *.java client/*.java hash/*.java model/*.java network/*.java storage/*.java
```

### Start Server Nodes

Terminal 1:

```bash
java Node1
```

Terminal 2:

```bash
java Node2
```

Terminal 3:

```bash
java Node3
```

Output:

```
Node running at 5001
Node running at 5002
Node running at 5003
```

### Start Client

```bash
java InteractiveClient
```

Example:

```
> PUT name Sid
OK

> PUT city Pune
OK

> GET name
Sid

> GET city
Pune

> DELETE city
Deleted
```

## Example Data Distribution

| Key  | Responsible Node |
| ---- | ---------------- |
| name | Node 5002        |
| age  | Node 5001        |
| city | Node 5003        |

## Future Improvements

* Virtual Nodes
* Data Replication
* Heartbeat-based Failure Detection
* Node Join and Leave Operations
* Persistent Storage
* REST API with Spring Boot
* Load Balancing
* Fault Tolerance and Recovery

## Learning Outcomes

This project demonstrates:

* Distributed Systems fundamentals
* Consistent Hashing
* Network Programming
* Concurrent Programming
* Client-Server Architecture
* Scalable Data Partitioning

## Inspiration

Inspired by the architecture of distributed databases such as Amazon DynamoDB and Apache Cassandra.
