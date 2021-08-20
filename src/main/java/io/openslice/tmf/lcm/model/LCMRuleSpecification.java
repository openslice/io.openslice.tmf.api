package io.openslice.tmf.lcm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ctranoris
 * 
 * A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service
 *
 */
@ApiModel(description = "A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service.")
@Validated
@Entity(name = "LCMRuleSpec")
@EqualsAndHashCode(callSuper=true)
@Data
public class LCMRuleSpecification extends BaseEntity{	


	@JsonProperty("id")
	protected String id = null;
	
	
	@JsonProperty("lcmrulephase")
	protected String lcmrulephase = ELCMRulePhase.PRE_PROVISION.getValue();	

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,  CascadeType.DETACH, CascadeType.REFRESH })
	@JsonIgnore
	private Set<ServiceSpecificationRef > serviceSpecs = new HashSet<>();
		

	@Lob
	@Column(name = "LCONTENT", columnDefinition = "LONGTEXT")
	@JsonProperty("content")
	protected String content = null;
	

	@Lob
	@Column(name = "LCODE", columnDefinition = "LONGTEXT")
	@JsonProperty("code")
	protected String code = null;

	/**
	 * @return the id
	 */
	public String getId() {
		if ( uuid != null ) {
			id = uuid;
		} 
		return id;
	}
	
	public void setId(String id) {
		id = uuid;
	}
	

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("class Entity {\n");
//
//		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
//		sb.append("    href: ").append(toIndentedString(href)).append("\n");
//		sb.append("    description: ").append(toIndentedString(description)).append("\n");
//		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
//		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
//		sb.append("    name: ").append(toIndentedString(name)).append("\n");
//		sb.append("    version: ").append(toIndentedString(version)).append("\n");
//		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
//		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
//		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
//		sb.append("    type: ").append(toIndentedString(type)).append("\n");
//		sb.append("}");
//		return sb.toString();
//	}
	
	
	
	/**
	 * List of service categories associated with this catalog
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "List of service specs associated with this rule")
	@Transient
	@JsonProperty("serviceSpecs")
	@Valid
	public Set<ServiceSpecificationRef> getServiceSpecificationRefs() {

		return this.serviceSpecs;		
	}
	
	public void addServiceSpecificationRef(ServiceSpecificationRef s) {
		if (!this.serviceSpecs.contains(s) ) {
			this.serviceSpecs.add(s);
		}
		
	}
	
	

	public void copyFromObj(BaseEntity be) {
		super.copyFromObj(be);
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


	/**
	 * @return the lcmrulephase
	 */
	public String getLcmrulephase() {
		return lcmrulephase;
	}


	/**
	 * @param lcmrulephase the lcmrulephase to set
	 */
	public void setLcmrulephase(String lcmrulephase) {
		this.lcmrulephase = lcmrulephase;
	}
	
	public void setLcmrulephase(ELCMRulePhase lcmrulephase) {
		this.lcmrulephase = lcmrulephase.getValue();
	}
}
