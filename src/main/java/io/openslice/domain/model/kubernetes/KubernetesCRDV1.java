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
public class KubernetesCRDV1 extends DomainModelDefinition
		implements ITMFRCM634_ModelTransformer, ITMFRI639_ModelTransformer {

	public static final String OSL_KUBCRD_RSPEC_NAME = "kubernetes-crd.openslice.io";
	public static final String OSL_KUBCRD_RSPEC_VERSION = "0.0.3";
	public static final String OSL_KUBCRD_RSPEC_CATEGORY = "KubernetesCRD-apiextensions.k8s.io/v1";
	public static final String OSL_KUBCRD_RESOURCE_CATEGORY = "KubernetesCRD-apiextensions.k8s.io/v1";
	public static final String OSL_KUBCRD_RSPEC_TYPE = "LogicalResourceSpecification";
	public static final String OSL_KUBCRD_RSPEC_DESCRIPTION = "This Specification is used to describe a generic KubernetesCRD";

	private String osl_KUBCRD_RSPEC_UUID = null; //this is assigned by the system through the DB for a specific instance
	
	private String clusterMasterURL;
	private String currentContextCluster;
	private String fullResourceName;
	private String kind;
	private String apiGroup;
	private String UID;
	private String metadata;
	private String yaml;
	private String json;
	private Map<String, KubernetesCRDProperty> properties;
	private Map<String, KubernetesCRDProperty> additionalProperties;
    private String cr_spec;
    private String statusCheckFieldName;
    private String statusCheckValueStandby;
    private String statusCheckValueAlarm;
    private String statusCheckValueAvailable;
    private String statusCheckValueReserved;
    private String statusCheckValueUnknown;
    private String statusCheckValueSuspended;


	@Builder
	public KubernetesCRDV1(String osl_KUBCRD_RSPEC_UUID, String uuid, String name, String version, String description, String category,
			String clusterMasterURL, String currentContextCluster, String fullResourceName,
			String kind, String apiGroup, String uID,
			String metadata,
			String yaml,
			String json) {
		super(uuid, name, version, description, category);
		this.osl_KUBCRD_RSPEC_UUID = osl_KUBCRD_RSPEC_UUID;
		this.clusterMasterURL = clusterMasterURL;
		this.currentContextCluster = currentContextCluster;
		this.fullResourceName = fullResourceName;
		this.kind = kind;
		this.apiGroup = apiGroup;
		this.UID = uID;
		this.metadata = metadata;
		this.yaml = yaml;
		this.json = json;
		this.properties = new HashMap<>();
		this.additionalProperties = new HashMap<>();	
	}
	
	

	@Override
	public ResourceSpecificationCreate toRSpecCreate_InitRepo() {

		ResourceSpecificationCreate rsc = this.toRSpecCreate();
		rsc.setName( OSL_KUBCRD_RSPEC_NAME );
		rsc.setCategory( OSL_KUBCRD_RSPEC_CATEGORY );
		rsc.setVersion(OSL_KUBCRD_RSPEC_VERSION);
		rsc.setDescription( OSL_KUBCRD_RSPEC_DESCRIPTION );
		rsc.setType( OSL_KUBCRD_RSPEC_TYPE );
		
		

		return rsc;
	}
	
	@Override
	public ResourceSpecificationCreate toRSpecCreate() {

		ResourceSpecificationCreate rsc = new ResourceSpecificationCreate();
		rsc.setName( this.name );
		rsc.setCategory( OSL_KUBCRD_RSPEC_CATEGORY );
		rsc.setVersion( this.version );
		rsc.setDescription( this.version );
		rsc.setType( OSL_KUBCRD_RSPEC_TYPE );
		
		rsc.setLifecycleStatus( ELifecycle.ACTIVE.getValue() );
		rsc.addResourceSpecificationCharacteristicItemShort("clusterMasterURL", this.clusterMasterURL, EValueType.TEXT.getValue(), "URL of cluster",  false);
		rsc.addResourceSpecificationCharacteristicItemShort("currentContextCluster", this.currentContextCluster, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("fullResourceName", this.fullResourceName, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("Kind", this.kind, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("apiGroup", this.apiGroup, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("UID", this.UID, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("metadata", this.metadata, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("yaml", this.yaml, EValueType.TEXT.getValue(), "", false);
		rsc.addResourceSpecificationCharacteristicItemShort("json", this.json, EValueType.TEXT.getValue(), "", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_SPEC", "", EValueType.TEXT.getValue(), "Used for providing the json Custom Resource description to apply", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECK_FIELD", "", EValueType.TEXT.getValue(), "Used for providing the field that need to be checked for the resource status", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECKVAL_STANDBY", "", EValueType.TEXT.getValue(), "Used for providing the equivalent value from resource to signal the standby status", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECKVAL_ALARM", "", EValueType.TEXT.getValue(), "Used for providing the equivalent value from resource to signal the alarm status", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECKVAL_AVAILABLE", "", EValueType.TEXT.getValue(), "Used for providing the equivalent value from resource to signal the available status", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECKVAL_RESERVED", "", EValueType.TEXT.getValue(), "Used for providing the equivalent value from resource to signal the reserved status", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECKVAL_UNKNOWN", "", EValueType.TEXT.getValue(), "Used for providing the equivalent value from resource to signal the unknown status", false);
        rsc.addResourceSpecificationCharacteristicItemShort( "_CR_CHECKVAL_SUSPENDED", "", EValueType.TEXT.getValue(), "Used for providing the equivalent value from resource to signal the suspended status", false);
        
//		rsc.addResourceSpecificationCharacteristicItemShort( "properties", "", EValueType.SET.getValue());
//		rsc.addResourceSpecificationCharacteristicItemShort( "additionalProperties", "", EValueType.SET.getValue());
		if (this.properties != null)
			this.properties.forEach((kPropName, vProVal) -> {

						EValueType etype;
						if ( vProVal.getValueType().equalsIgnoreCase("boolean")) {
							etype = EValueType.BOOLEAN;
						} else if ( vProVal.getValueType().equalsIgnoreCase("integer")) {
							etype = EValueType.INTEGER;
						} else if ( vProVal.getValueType().equalsIgnoreCase("object")) {
							etype = EValueType.OBJECT;
						} else
							etype = EValueType.TEXT;

						rsc.addResourceSpecificationCharacteristicItemShort(kPropName , vProVal.getDefaultValue(), etype.getValue(), vProVal.getDescription(), false);

			});

		if (this.additionalProperties != null ) {
			this.additionalProperties.forEach((kPropName, vProVal) -> {
						rsc.addResourceSpecificationCharacteristicItemShort("additionalProperty." + kPropName, vProVal.getDefaultValue(), EValueType.TEXT.getValue(), vProVal.getDescription(), false);

					});
		}

		return rsc;
	}
	
	@Override
	public ResourceSpecificationUpdate toRSpecUpdate() {
		return this.toRSpecCreate();
	}

	@Override
	public KubernetesCRDV1 fromRSpec(ResourceSpecification rSpec) {
		this.osl_KUBCRD_RSPEC_UUID = rSpec.getUuid();
		return this;
	}
	
	@Override
	public ResourceCreate toResourceCreate() {

		if (osl_KUBCRD_RSPEC_UUID == null) {
			return null;
		}

		ResourceSpecificationRef rSpecRef = new ResourceSpecificationRef();
		rSpecRef.setId( osl_KUBCRD_RSPEC_UUID  );
		rSpecRef.setName( OSL_KUBCRD_RSPEC_NAME );
		rSpecRef.setVersion( OSL_KUBCRD_RSPEC_VERSION );
		
		ResourceCreate rs = new ResourceCreate();
		rs.name( this.name )
		.category( OSL_KUBCRD_RESOURCE_CATEGORY )
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
		rs.addResourceCharacteristicItemShort("UID", this.UID, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("metadata", this.metadata, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("yaml", this.yaml, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("json", this.json, EValueType.TEXT.getValue());
		
        rs.addResourceCharacteristicItemShort("_CR_SPEC", this.cr_spec, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECK_FIELD", this.statusCheckFieldName, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECKVAL_STANDBY", this.statusCheckValueStandby, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECKVAL_ALARM", this.statusCheckValueAlarm, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECKVAL_AVAILABLE", this.statusCheckValueAvailable, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECKVAL_RESERVED", this.statusCheckValueReserved, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECKVAL_UNKNOWN", this.statusCheckValueUnknown, EValueType.TEXT.getValue());
        rs.addResourceCharacteristicItemShort("_CR_CHECKVAL_SUSPENDED", this.statusCheckValueSuspended, EValueType.TEXT.getValue());


        
		if (this.properties != null)
			this.properties.forEach((kPropName, vProVal) -> {

						EValueType etype;
						if ( vProVal.getValueType().equalsIgnoreCase("boolean")) {
							etype = EValueType.BOOLEAN;
						} else if ( vProVal.getValueType().equalsIgnoreCase("integer")) {
							etype = EValueType.INTEGER;
						} else if ( vProVal.getValueType().equalsIgnoreCase("object")) {
							etype = EValueType.OBJECT;
						} else
							etype = EValueType.TEXT;

						rs.addResourceCharacteristicItemShort(kPropName , "", etype.getValue());

			});

		if (this.additionalProperties != null ) {
			this.additionalProperties.forEach((kPropName, vProVal) -> {
						rs.addResourceCharacteristicItemShort("additionalProperty." + kPropName, "", EValueType.TEXT.getValue());

					});
		}


		return rs;
	}
	
	@Override
	public ResourceUpdate toResourceUpdate() {
	
		return this.toResourceCreate();
	}

}
