# Hello World API

## Build

### Runnable jar

```console
mvn clean install
```

### Docker image

```console
mvn spring-boot:build-image
```

## To start a chain of 2 APIs

### Start API 1

```console
export HELLO_WORLD_MESSAGE="hello world 1"
export HELLO_WORLD_PORT=8081
java -jar target/hello-world-api-0.1.jar
```

### Start API 2 to call API 1

```console
export HELLO_WORLD_MESSAGE="hello world 2"
export HELLO_WORLD_PORT=8082
export HELLO_WORLD_DOWN_STREAM_URL="http://localhost:8081"
java -jar target/hello-world-api-0.1.jar
```

### Call API 2

```console
curl http://localhost:8082
hello world 2, downstream response from http://localhost:8081=hello world 1
```

## Docker Image

```console
docker pull gregclinker/hello-world-api:0.1
```


