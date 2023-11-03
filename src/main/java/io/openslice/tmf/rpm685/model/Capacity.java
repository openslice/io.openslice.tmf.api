package io.openslice.tmf.rpm685.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.pcm620.model.PlaceRef;
import io.openslice.tmf.prm669.model.RelatedParty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Capacity")
public class Capacity extends BaseRootEntity {

	@JsonProperty("capacityAmount")
	private Integer capacityAmount;
	
	@JsonProperty("relatedParty")	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capacity_relParuuid", referencedColumnName = "uuid")
	private RelatedParty relatedParty;
	
	
	@JsonProperty("place")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capacity_placeuuid", referencedColumnName = "uuid")
	private PlaceRef place;
	
//	@JsonProperty("applicableTimePeriod")
//	private ApplicableTimePeriod applicableTimePeriod;
	
	@JsonProperty("resources")
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceRef> resources = new HashSet<>();
	
	@JsonProperty("appliedCapacityAmount")
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<AppliedCapacityAmount> appliedCapacityAmount = new HashSet<>();
	

	public Capacity addResourceRefItem(ResourceRef aResourceRef) {
		this.resources.add(aResourceRef);
		return this;
	}

	public Capacity addAppliedCapacityAmountItem(AppliedCapacityAmount anAppliedCapacityAmount) {
		this.appliedCapacityAmount.add(anAppliedCapacityAmount);
		return this;
	}
}
