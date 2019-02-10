# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.SdkApi;

import java.io.File;
import java.util.*;

public class SdkApiExample {

    public static void main(String[] args) {
        
        SdkApi apiInstance = new SdkApi();
        try {
            SdkGameServer result = apiInstance.getGameServer();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SdkApi#getGameServer");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*SdkApi* | [**getGameServer**](docs/SdkApi.md#getGameServer) | **GET** /gameserver | Retrieve the current GameServer data
*SdkApi* | [**health**](docs/SdkApi.md#health) | **POST** /health | Send a Empty every d Duration to declare that this GameSever is healthy
*SdkApi* | [**ready**](docs/SdkApi.md#ready) | **POST** /ready | Call when the GameServer is ready
*SdkApi* | [**setAnnotation**](docs/SdkApi.md#setAnnotation) | **PUT** /metadata/annotation | Apply a Annotation to the backing GameServer metadata
*SdkApi* | [**setLabel**](docs/SdkApi.md#setLabel) | **PUT** /metadata/label | Apply a Label to the backing GameServer metadata
*SdkApi* | [**shutdown**](docs/SdkApi.md#shutdown) | **POST** /shutdown | Call when the GameServer is shutting down
*SdkApi* | [**watchGameServer**](docs/SdkApi.md#watchGameServer) | **GET** /watch/gameserver | Send GameServer details whenever the GameServer is updated


## Documentation for Models

 - [GameServerObjectMeta](docs/GameServerObjectMeta.md)
 - [GameServerSpec](docs/GameServerSpec.md)
 - [GameServerStatus](docs/GameServerStatus.md)
 - [SdkEmpty](docs/SdkEmpty.md)
 - [SdkGameServer](docs/SdkGameServer.md)
 - [SdkKeyValue](docs/SdkKeyValue.md)
 - [SpecHealth](docs/SpecHealth.md)
 - [StatusPort](docs/StatusPort.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



