package io.openslice.domain.model.kubernetes;

import java.util.HashMap;
import java.util.Map;

import io.openslice.domain.model.DomainModelDefinition;
import io.openslice.domain.model.ITMFRCM634_ModelTransformer;
import io.openslice.domain.model.ITMFRI639_ModelTransformer;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceOperationalStateType;
import io.openslice.tmf.ri639.model.ResourceStatusType;
import io.openslice.tmf.ri639.model.ResourceUpdate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ctranoris
 */
@Getter
@Setter
public class KubernetesCRV1 extends DomainModelDefinition
		implements ITMFRCM634_ModelTransformer, ITMFRI639_ModelTransformer {

	public static final String OSL_KUBCRV1_RSPEC_NAME = "kubernetes-cr-v1.openslice.io";
	public static final String OSL_KUBCRV1_RSPEC_VERSION = "0.0.4";
	public static final String OSL_KUBCRV1_RSPEC_CATEGORY = "KubernetesCRV1-apiextensions.k8s.io/v1";
	public static final String OSL_KUBCRV1_RSPEC_TYPE = "LogicalResourceSpecification";
	public static final String OSL_KUBCRV1_RSPEC_DESCRIPTION = "This Specification is used to describe a generic KubernetesCRV1";

	private String osl_KUBCRV1_RSPEC_UUID = null; //this is assigned by the system through the DB for a specific instance
	
	private String clusterMasterURL;
	private String currentContextCluster;
	private String fullResourceName;
	private String kind;
	private String apiGroup;
	private String namespace;
	private String UID;
	private String metadata;
	private String yaml;
	private String json;
	private Map<String, String> properties;
	private Map<String, String> additionalProperties;

	@Builder
	public KubernetesCRV1(String osl_KUBCRV1_RSPEC_UUID, String uuid, String name, String version, String description, String category,
			String clusterMasterURL, String currentContextCluster, String fullResourceName, String namespace,
			String kind, String apiGroup, String uID, String metadata,
			String yaml,
			String json) {
		super(uuid, name, version, description, category);
		this.osl_KUBCRV1_RSPEC_UUID = osl_KUBCRV1_RSPEC_UUID;
		this.clusterMasterURL = clusterMasterURL;
		this.currentContextCluster = currentContextCluster;
		this.fullResourceName = fullResourceName;
		this.kind = kind;
		this.apiGroup = apiGroup;
		this.namespace = namespace;
		this.UID = uID;
		this.metadata = metadata;
		this.yaml = yaml;
		this.json = json;
		this.properties = new HashMap<>();
		this.additionalProperties = new HashMap<>();	
	}
	
	

	@Override
	public ResourceSpecificationCreate toRSpecCreate_InitRepo() {

		ResourceSpecificationCreate rsc = toRSpecCreate();
		rsc.setName( OSL_KUBCRV1_RSPEC_NAME );
		rsc.setCategory( OSL_KUBCRV1_RSPEC_CATEGORY );
		rsc.setVersion(OSL_KUBCRV1_RSPEC_VERSION);
		rsc.setDescription( OSL_KUBCRV1_RSPEC_DESCRIPTION );
		rsc.setType( OSL_KUBCRV1_RSPEC_TYPE );
		
		return rsc;
	}
	
	
	@Override
	public ResourceSpecificationCreate toRSpecCreate() {

		ResourceSpecificationCreate rsc = new ResourceSpecificationCreate();
		rsc.setName( this.name );
		rsc.setCategory( OSL_KUBCRV1_RSPEC_CATEGORY );
		rsc.setVersion(this.version);
		rsc.setDescription( this.description );
		rsc.setType( OSL_KUBCRV1_RSPEC_TYPE );
		
		rsc.setLifecycleStatus( ELifecycle.ACTIVE.getValue() );
		rsc.addResourceSpecificationCharacteristicItemShort( "clusterMasterURL", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "currentContextCluster", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "fullResourceName", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "Kind", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "apiGroup", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "UID", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "namespace", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "metadata", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "yaml", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "json", "", EValueType.TEXT.getValue(), false);
//		rsc.addResourceSpecificationCharacteristicItemShort( "properties", "", EValueType.SET.getValue());
//		rsc.addResourceSpecificationCharacteristicItemShort( "additionalProperties", "", EValueType.SET.getValue());


		return rsc;
	}
	
	@Override
	public ResourceSpecificationUpdate toRSpecUpdate() {
		return this.toRSpecCreate();
	}

	@Override
	public KubernetesCRV1 fromRSpec(ResourceSpecification rSpec) {
		osl_KUBCRV1_RSPEC_UUID = rSpec.getUuid();
		return this;
	}
	
	@Override
	public ResourceCreate toResourceCreate() {

		if (osl_KUBCRV1_RSPEC_UUID == null) {
			return null;
		}

		ResourceSpecificationRef rSpecRef = new ResourceSpecificationRef();
		rSpecRef.setId( osl_KUBCRV1_RSPEC_UUID  );
		rSpecRef.setName( OSL_KUBCRV1_RSPEC_NAME );
		rSpecRef.setVersion( OSL_KUBCRV1_RSPEC_VERSION );
		
		ResourceCreate rs = new ResourceCreate();
		rs.name( this.name )
		.category( this.category )
		.description( this.description )
		.resourceStatus( ResourceStatusType.AVAILABLE )
		.operationalState( ResourceOperationalStateType.ENABLE )
		.resourceSpecification( rSpecRef )
		.resourceVersion( this.version);
		
		rs.addResourceCharacteristicItemShort("clusterMasterURL", this.clusterMasterURL, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("currentContextCluster", this.currentContextCluster, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("fullResourceName", this.fullResourceName, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("Kind", this.kind, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("apiGroup", this.apiGroup, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("apiVersion", this.version , EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("UID", this.UID, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("namespace", this.namespace, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("metadata", this.metadata, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("yaml", this.yaml, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("json", this.json, EValueType.TEXT.getValue());

		if (this.properties != null)
			this.properties.forEach((kPropName, vProVal) -> {
						rs.addResourceCharacteristicItemShort(kPropName , vProVal, EValueType.TEXT.getValue());

			});

		if (this.additionalProperties != null ) {
			this.additionalProperties.forEach((kPropName, vProVal) -> {
						rs.addResourceCharacteristicItemShort(kPropName, vProVal, EValueType.TEXT.getValue());

					});
		}


		return rs;
	}
	
	@Override
	public ResourceUpdate toResourceUpdate() {
	
		return this.toResourceCreate();
	}

}
