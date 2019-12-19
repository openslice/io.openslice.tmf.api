package io.openslice.tmf.fi691.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.openslice.tmf.fi691.model.EntitlementType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserAssetType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

public class UserAssetType   {
  /**
   * Type of managed entity (e.g.: product, resource, service, customer, account)
   */
  public enum EntityTypeEnum {
    CUSTOMER("customer"),
    
    ACCOUNT("account"),
    
    PRODUCT("product"),
    
    SERVICE("service"),
    
    RESOURCE("resource");

    private String value;

    EntityTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EntityTypeEnum fromValue(String text) {
      for (EntityTypeEnum b : EntityTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("entityType")
  private EntityTypeEnum entityType = null;

  /**
   * Second level to define the type of managed element for product/service/resource managed entities (e.g.: mobile line subscription, video platform license, mobile equipment, etc). Allows identifying the specific asset within the server referenced. Supported values are implementation and application specific. Other values can be added if those listed are not enough
   */
  public enum AssetTypeEnum {
    MOBILE("mobile"),
    
    LANDLINE("landline"),
    
    IPTV("iptv"),
    
    BROADBAND("broadband"),
    
    EMAIL("email"),
    
    INVOICING("invoicing");

    private String value;

    AssetTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AssetTypeEnum fromValue(String text) {
      for (AssetTypeEnum b : AssetTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("assetType")
  private AssetTypeEnum assetType = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("entitlement")
  @Valid
  private List<EntitlementType> entitlement = null;

  public UserAssetType entityType(EntityTypeEnum entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * Type of managed entity (e.g.: product, resource, service, customer, account)
   * @return entityType
  **/
  @ApiModelProperty(required = true, value = "Type of managed entity (e.g.: product, resource, service, customer, account)")
  @NotNull


  public EntityTypeEnum getEntityType() {
    return entityType;
  }

  public void setEntityType(EntityTypeEnum entityType) {
    this.entityType = entityType;
  }

  public UserAssetType assetType(AssetTypeEnum assetType) {
    this.assetType = assetType;
    return this;
  }

  /**
   * Second level to define the type of managed element for product/service/resource managed entities (e.g.: mobile line subscription, video platform license, mobile equipment, etc). Allows identifying the specific asset within the server referenced. Supported values are implementation and application specific. Other values can be added if those listed are not enough
   * @return assetType
  **/
  @ApiModelProperty(value = "Second level to define the type of managed element for product/service/resource managed entities (e.g.: mobile line subscription, video platform license, mobile equipment, etc). Allows identifying the specific asset within the server referenced. Supported values are implementation and application specific. Other values can be added if those listed are not enough")


  public AssetTypeEnum getAssetType() {
    return assetType;
  }

  public void setAssetType(AssetTypeEnum assetType) {
    this.assetType = assetType;
  }

  public UserAssetType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of referenced entity within the entity/asset pair (customerId, accountId, mobile line number, ...)
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of referenced entity within the entity/asset pair (customerId, accountId, mobile line number, ...)")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserAssetType role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Represents the part played by an individual in relation to being granted a set of entitlements for manageable assets (e.g.: owner, user, viewer, ...)
   * @return role
  **/
  @ApiModelProperty(value = "Represents the part played by an individual in relation to being granted a set of entitlements for manageable assets (e.g.: owner, user, viewer, ...)")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public UserAssetType entitlement(List<EntitlementType> entitlement) {
    this.entitlement = entitlement;
    return this;
  }

  public UserAssetType addEntitlementItem(EntitlementType entitlementItem) {
    if (this.entitlement == null) {
      this.entitlement = new ArrayList<>();
    }
    this.entitlement.add(entitlementItem);
    return this;
  }

  /**
   * information about individual entitlements to define access levels to operate over different functions that can be defined in an asset
   * @return entitlement
  **/
  @ApiModelProperty(value = "information about individual entitlements to define access levels to operate over different functions that can be defined in an asset")

  @Valid

  public List<EntitlementType> getEntitlement() {
    return entitlement;
  }

  public void setEntitlement(List<EntitlementType> entitlement) {
    this.entitlement = entitlement;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAssetType userAssetType = (UserAssetType) o;
    return Objects.equals(this.entityType, userAssetType.entityType) &&
        Objects.equals(this.assetType, userAssetType.assetType) &&
        Objects.equals(this.id, userAssetType.id) &&
        Objects.equals(this.role, userAssetType.role) &&
        Objects.equals(this.entitlement, userAssetType.entitlement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, assetType, id, role, entitlement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAssetType {\n");
    
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    entitlement: ").append(toIndentedString(entitlement)).append("\n");
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

