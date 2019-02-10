# SdkApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getGameServer**](SdkApi.md#getGameServer) | **GET** /gameserver | Retrieve the current GameServer data
[**health**](SdkApi.md#health) | **POST** /health | Send a Empty every d Duration to declare that this GameSever is healthy
[**ready**](SdkApi.md#ready) | **POST** /ready | Call when the GameServer is ready
[**setAnnotation**](SdkApi.md#setAnnotation) | **PUT** /metadata/annotation | Apply a Annotation to the backing GameServer metadata
[**setLabel**](SdkApi.md#setLabel) | **PUT** /metadata/label | Apply a Label to the backing GameServer metadata
[**shutdown**](SdkApi.md#shutdown) | **POST** /shutdown | Call when the GameServer is shutting down
[**watchGameServer**](SdkApi.md#watchGameServer) | **GET** /watch/gameserver | Send GameServer details whenever the GameServer is updated


<a name="getGameServer"></a>
# **getGameServer**
> SdkGameServer getGameServer()

Retrieve the current GameServer data

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
try {
    SdkGameServer result = apiInstance.getGameServer();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#getGameServer");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SdkGameServer**](SdkGameServer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="health"></a>
# **health**
> SdkEmpty health(body)

Send a Empty every d Duration to declare that this GameSever is healthy

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
SdkEmpty body = new SdkEmpty(); // SdkEmpty | (streaming inputs)
try {
    SdkEmpty result = apiInstance.health(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#health");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SdkEmpty**](SdkEmpty.md)| (streaming inputs) |

### Return type

[**SdkEmpty**](SdkEmpty.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="ready"></a>
# **ready**
> SdkEmpty ready(body)

Call when the GameServer is ready

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
SdkEmpty body = new SdkEmpty(); // SdkEmpty | 
try {
    SdkEmpty result = apiInstance.ready(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#ready");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SdkEmpty**](SdkEmpty.md)|  |

### Return type

[**SdkEmpty**](SdkEmpty.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setAnnotation"></a>
# **setAnnotation**
> SdkEmpty setAnnotation(body)

Apply a Annotation to the backing GameServer metadata

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
SdkKeyValue body = new SdkKeyValue(); // SdkKeyValue | 
try {
    SdkEmpty result = apiInstance.setAnnotation(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#setAnnotation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SdkKeyValue**](SdkKeyValue.md)|  |

### Return type

[**SdkEmpty**](SdkEmpty.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setLabel"></a>
# **setLabel**
> SdkEmpty setLabel(body)

Apply a Label to the backing GameServer metadata

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
SdkKeyValue body = new SdkKeyValue(); // SdkKeyValue | 
try {
    SdkEmpty result = apiInstance.setLabel(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#setLabel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SdkKeyValue**](SdkKeyValue.md)|  |

### Return type

[**SdkEmpty**](SdkEmpty.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="shutdown"></a>
# **shutdown**
> SdkEmpty shutdown(body)

Call when the GameServer is shutting down

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
SdkEmpty body = new SdkEmpty(); // SdkEmpty | 
try {
    SdkEmpty result = apiInstance.shutdown(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#shutdown");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SdkEmpty**](SdkEmpty.md)|  |

### Return type

[**SdkEmpty**](SdkEmpty.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="watchGameServer"></a>
# **watchGameServer**
> SdkGameServer watchGameServer()

Send GameServer details whenever the GameServer is updated

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SdkApi;


SdkApi apiInstance = new SdkApi();
try {
    SdkGameServer result = apiInstance.watchGameServer();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SdkApi#watchGameServer");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SdkGameServer**](SdkGameServer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

