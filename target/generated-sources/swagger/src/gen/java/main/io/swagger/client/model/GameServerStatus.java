/*
 * sdk.proto
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: version not set
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.StatusPort;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * GameServerStatus
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-11T20:55:17.626+01:00")
public class GameServerStatus {
  @SerializedName("state")
  private String state = null;

  @SerializedName("address")
  private String address = null;

  @SerializedName("ports")
  private List<StatusPort> ports = null;

  public GameServerStatus state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public GameServerStatus address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public GameServerStatus ports(List<StatusPort> ports) {
    this.ports = ports;
    return this;
  }

  public GameServerStatus addPortsItem(StatusPort portsItem) {
    if (this.ports == null) {
      this.ports = new ArrayList<StatusPort>();
    }
    this.ports.add(portsItem);
    return this;
  }

   /**
   * Get ports
   * @return ports
  **/
  @ApiModelProperty(value = "")
  public List<StatusPort> getPorts() {
    return ports;
  }

  public void setPorts(List<StatusPort> ports) {
    this.ports = ports;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameServerStatus gameServerStatus = (GameServerStatus) o;
    return Objects.equals(this.state, gameServerStatus.state) &&
        Objects.equals(this.address, gameServerStatus.address) &&
        Objects.equals(this.ports, gameServerStatus.ports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, address, ports);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameServerStatus {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    ports: ").append(toIndentedString(ports)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

