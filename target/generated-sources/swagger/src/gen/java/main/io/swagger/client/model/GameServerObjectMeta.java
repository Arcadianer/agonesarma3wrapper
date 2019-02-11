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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameServerObjectMeta
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-08T15:46:47.191+01:00")
public class GameServerObjectMeta {
  @SerializedName("name")
  private String name = null;

  @SerializedName("namespace")
  private String namespace = null;

  @SerializedName("uid")
  private String uid = null;

  @SerializedName("resource_version")
  private String resourceVersion = null;

  @SerializedName("generation")
  private String generation = null;

  @SerializedName("creation_timestamp")
  private String creationTimestamp = null;

  @SerializedName("deletion_timestamp")
  private String deletionTimestamp = null;

  @SerializedName("annotations")
  private Map<String, String> annotations = null;

  @SerializedName("labels")
  private Map<String, String> labels = null;

  public GameServerObjectMeta name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GameServerObjectMeta namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * Get namespace
   * @return namespace
  **/
  @ApiModelProperty(value = "")
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public GameServerObjectMeta uid(String uid) {
    this.uid = uid;
    return this;
  }

   /**
   * Get uid
   * @return uid
  **/
  @ApiModelProperty(value = "")
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public GameServerObjectMeta resourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
    return this;
  }

   /**
   * Get resourceVersion
   * @return resourceVersion
  **/
  @ApiModelProperty(value = "")
  public String getResourceVersion() {
    return resourceVersion;
  }

  public void setResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
  }

  public GameServerObjectMeta generation(String generation) {
    this.generation = generation;
    return this;
  }

   /**
   * Get generation
   * @return generation
  **/
  @ApiModelProperty(value = "")
  public String getGeneration() {
    return generation;
  }

  public void setGeneration(String generation) {
    this.generation = generation;
  }

  public GameServerObjectMeta creationTimestamp(String creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
    return this;
  }

   /**
   * Get creationTimestamp
   * @return creationTimestamp
  **/
  @ApiModelProperty(value = "")
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public void setCreationTimestamp(String creationTimestamp) {
    this.creationTimestamp = creationTimestamp;
  }

  public GameServerObjectMeta deletionTimestamp(String deletionTimestamp) {
    this.deletionTimestamp = deletionTimestamp;
    return this;
  }

   /**
   * Get deletionTimestamp
   * @return deletionTimestamp
  **/
  @ApiModelProperty(value = "")
  public String getDeletionTimestamp() {
    return deletionTimestamp;
  }

  public void setDeletionTimestamp(String deletionTimestamp) {
    this.deletionTimestamp = deletionTimestamp;
  }

  public GameServerObjectMeta annotations(Map<String, String> annotations) {
    this.annotations = annotations;
    return this;
  }

  public GameServerObjectMeta putAnnotationsItem(String key, String annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new HashMap<String, String>();
    }
    this.annotations.put(key, annotationsItem);
    return this;
  }

   /**
   * Get annotations
   * @return annotations
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getAnnotations() {
    return annotations;
  }

  public void setAnnotations(Map<String, String> annotations) {
    this.annotations = annotations;
  }

  public GameServerObjectMeta labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public GameServerObjectMeta putLabelsItem(String key, String labelsItem) {
    if (this.labels == null) {
      this.labels = new HashMap<String, String>();
    }
    this.labels.put(key, labelsItem);
    return this;
  }

   /**
   * Get labels
   * @return labels
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameServerObjectMeta gameServerObjectMeta = (GameServerObjectMeta) o;
    return Objects.equals(this.name, gameServerObjectMeta.name) &&
        Objects.equals(this.namespace, gameServerObjectMeta.namespace) &&
        Objects.equals(this.uid, gameServerObjectMeta.uid) &&
        Objects.equals(this.resourceVersion, gameServerObjectMeta.resourceVersion) &&
        Objects.equals(this.generation, gameServerObjectMeta.generation) &&
        Objects.equals(this.creationTimestamp, gameServerObjectMeta.creationTimestamp) &&
        Objects.equals(this.deletionTimestamp, gameServerObjectMeta.deletionTimestamp) &&
        Objects.equals(this.annotations, gameServerObjectMeta.annotations) &&
        Objects.equals(this.labels, gameServerObjectMeta.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, namespace, uid, resourceVersion, generation, creationTimestamp, deletionTimestamp, annotations, labels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameServerObjectMeta {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    resourceVersion: ").append(toIndentedString(resourceVersion)).append("\n");
    sb.append("    generation: ").append(toIndentedString(generation)).append("\n");
    sb.append("    creationTimestamp: ").append(toIndentedString(creationTimestamp)).append("\n");
    sb.append("    deletionTimestamp: ").append(toIndentedString(deletionTimestamp)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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
