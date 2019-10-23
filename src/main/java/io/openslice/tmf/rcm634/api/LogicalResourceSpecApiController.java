package io.openslice.tmf.rcm634.api;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecCreate;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecUpdate;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Controller
@RequestMapping("/resourceCatalogManagement/v2/")
public class LogicalResourceSpecApiController implements LogicalResourceSpecApi {

	private static final Logger log = LoggerFactory.getLogger(ResourceSpecificationApiController.class);

	@Autowired
	ResourceSpecificationRepoService resourceSpecificationRepoService;
	
	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	
	@org.springframework.beans.factory.annotation.Autowired
	public LogicalResourceSpecApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<LogicalResourceSpec> createLogicalResourceSpec(
			@ApiParam(value = "The Logical Resource Spec to be created", required = true) @Valid @RequestBody LogicalResourceSpecCreate logicalResourceSpec) {
		try {

			LogicalResourceSpec c = resourceSpecificationRepoService
					.addLogicalResourceSpecification(logicalResourceSpec);

			return new ResponseEntity<LogicalResourceSpec>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<LogicalResourceSpec>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<Void> deleteLogicalResourceSpec(@ApiParam(value = "Identifier of the Logical Resource Spec",required=true) @PathVariable("id") String id) {

		try {

			return new ResponseEntity<Void>(resourceSpecificationRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<LogicalResourceSpec>> listLogicalResourceSpec(
			@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,
			@ApiParam(value = "For filtering: Name given to this REST resource") @Valid @RequestParam(value = "name", required = false) String name,
			@ApiParam(value = "For filtering: Class type of this REST resource") @Valid @RequestParam(value = "@type", required = false) String type,
			@ApiParam(value = "For filtering: This field provides a link to the schema describing this REST resource") @Valid @RequestParam(value = "@schemaLocation", required = false) String schemaLocation,
			@ApiParam(value = "For filtering: The (immediate) base class type of this REST resource") @Valid @RequestParam(value = "@baseType", required = false) String baseType,
			@ApiParam(value = "For filtering: Resource Specification version") @Valid @RequestParam(value = "version", required = false) String version,
			@ApiParam(value = "For filtering: An instant of time, starting at the TimePeriod") @Valid @RequestParam(value = "validFor.startDateTime", required = false) OffsetDateTime validForStartDateTime,
			@ApiParam(value = "For filtering: An instant of time, ending at the TimePeriod.") @Valid @RequestParam(value = "validFor.endDateTime", required = false) OffsetDateTime validForEndDateTime,
			@ApiParam(value = "For filtering: Date and time of the last update of this REST resource") @Valid @RequestParam(value = "lastUpdate", required = false) OffsetDateTime lastUpdate,
			@ApiParam(value = "For filtering: Used to indicate the current lifecycle status of the resource specification") @Valid @RequestParam(value = "lifecycleStatus", required = false) String lifecycleStatus,
			@ApiParam(value = "For filtering: A flag indicates that if this resource specification is a bundled specification (true) or single (false).") @Valid @RequestParam(value = "isBundle", required = false) Boolean isBundle,
			@ApiParam(value = "For filtering: Category of the target resource like NetworkConnectivity, PhysicalLinks, Generic, L2Network and so on.") @Valid @RequestParam(value = "category", required = false) String category,
			@ApiParam(value = "For filtering: Class type of the target resource") @Valid @RequestParam(value = "targetResourceSchema.@type", required = false) String targetResourceSchemaType,
			@ApiParam(value = "For filtering: This field provides a link to the schema describing the target resource") @Valid @RequestParam(value = "targetResourceSchema.@schemaLocation", required = false) String targetResourceSchemaSchemaLocation,
			@ApiParam(value = "For filtering: feature version") @Valid @RequestParam(value = "feature.version", required = false) String featureVersion,
			@ApiParam(value = "For filtering: Unique name given to the feature. it is Required if the feature is not introduced as a separate REST resource") @Valid @RequestParam(value = "feature.name", required = false) String featureName,
			@ApiParam(value = "For filtering: The optional (class) type of the feature") @Valid @RequestParam(value = "feature.@type", required = false) String featureType,
			@ApiParam(value = "For filtering: A flag indicating if the feature is bundle (true) or not (false).") @Valid @RequestParam(value = "feature.isBundle", required = false) Boolean featureIsBundle,
			@ApiParam(value = "For filtering: A flag indicating if the feature is enabled (true) or not (false).") @Valid @RequestParam(value = "feature.isEnabled", required = false) Boolean featureIsEnabled,
			@ApiParam(value = "For filtering: name given to the attachment") @Valid @RequestParam(value = "attachment.name", required = false) String attachmentName,
			@ApiParam(value = "For filtering: Attachment class  type") @Valid @RequestParam(value = "attachment.@type", required = false) String attachmentType,
			@ApiParam(value = "For filtering: Uniform Resource Identifier (URI) of the attachment") @Valid @RequestParam(value = "attachment.uri", required = false) String attachmentUri,
			@ApiParam(value = "For filtering: Attachment mime type such as extension file for video, picture and document") @Valid @RequestParam(value = "attachment.mimeType", required = false) String attachmentMimeType,
			@ApiParam(value = "For filtering: Role of the related party.") @Valid @RequestParam(value = "relatedParty.role", required = false) String relatedPartyRole,
			@ApiParam(value = "For filtering: Name of the related party") @Valid @RequestParam(value = "relatedParty.name", required = false) String relatedPartyName,
			@ApiParam(value = "For filtering: A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.") @Valid @RequestParam(value = "resourceSpecCharacteristic.name", required = false) String resourceSpecCharacteristicName,
			@ApiParam(value = "For filtering: A kind of value that the characteristic can take on, such as numeric, text and so forth") @Valid @RequestParam(value = "resourceSpecCharacteristic.valueType", required = false) String resourceSpecCharacteristicValueType,
			@ApiParam(value = "For filtering: If true, the Boolean indicates that the ResourceSpecCharacteristic is configurable") @Valid @RequestParam(value = "resourceSpecCharacteristic.configurable", required = false) Boolean resourceSpecCharacteristicConfigurable,
			@ApiParam(value = "For filtering: (Class) type of the ResourceSpecCharacteristic") @Valid @RequestParam(value = "resourceSpecCharacteristic.@type", required = false) String resourceSpecCharacteristicType,
			@ApiParam(value = "For filtering: A link to the schema describing this characteristic specification") @Valid @RequestParam(value = "resourceSpecCharacteristic.@schemaLocation", required = false) String resourceSpecCharacteristicSchemaLocation,
			@ApiParam(value = "For filtering: This (optional) field provides a link to the schema describing the value type") @Valid @RequestParam(value = "resourceSpecCharacteristic.@valueSchemaLocation", required = false) String resourceSpecCharacteristicValueSchemaLocation,
			@ApiParam(value = "For filtering: The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.") @Valid @RequestParam(value = "resourceSpecCharacteristic.minCardinality", required = false) Integer resourceSpecCharacteristicMinCardinality,
			@ApiParam(value = "For filtering: The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.") @Valid @RequestParam(value = "resourceSpecCharacteristic.maxCardinality", required = false) Integer resourceSpecCharacteristicMaxCardinality,
			@ApiParam(value = "For filtering: An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"") @Valid @RequestParam(value = "resourceSpecCharacteristic.isUnique", required = false) Boolean resourceSpecCharacteristicIsUnique,
			@ApiParam(value = "For filtering: A rule or principle represented in regular expression used to derive the value of a characteristic value.") @Valid @RequestParam(value = "resourceSpecCharacteristic.regex", required = false) String resourceSpecCharacteristicRegex,
			@ApiParam(value = "For filtering: An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.") @Valid @RequestParam(value = "resourceSpecCharacteristic.extensible", required = false) Boolean resourceSpecCharacteristicExtensible,
			@ApiParam(value = "For filtering: Type of relationship such as migration, substitution, dependency, exclusivity") @Valid @RequestParam(value = "resourceSpecRelationship.type", required = false) String resourceSpecRelationshipType,
			@ApiParam(value = "For filtering: The association role for this resource specification") @Valid @RequestParam(value = "resourceSpecRelationship.role", required = false) String resourceSpecRelationshipRole,
			@ApiParam(value = "For filtering: The name given to the target resource specification instance") @Valid @RequestParam(value = "resourceSpecRelationship.name", required = false) String resourceSpecRelationshipName) {

		try {
			return new ResponseEntity<List<LogicalResourceSpec>>(resourceSpecificationRepoService.findAllLogical(),
					HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<LogicalResourceSpec>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<LogicalResourceSpec> patchLogicalResourceSpec(
			@ApiParam(value = "Identifier of the Logical Resource Spec", required = true) @PathVariable("id") String id,
			@ApiParam(value = "The Logical Resource Spec to be updated", required = true) @Valid @RequestBody LogicalResourceSpecUpdate logicalResourceSpec) {

		LogicalResourceSpec c = resourceSpecificationRepoService.updateLogicalResourceSpecSpecification(id, logicalResourceSpec);

		return new ResponseEntity<LogicalResourceSpec>(c, HttpStatus.OK);
	}

	public ResponseEntity<LogicalResourceSpec> retrieveLogicalResourceSpec(
			@ApiParam(value = "Identifier of the Logical Resource Spec", required = true) @PathVariable("id") String id) {

		try {
			LogicalResourceSpec res = (LogicalResourceSpec) resourceSpecificationRepoService.findByUuid(id);
			return new ResponseEntity<LogicalResourceSpec>( res, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<LogicalResourceSpec>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<LogicalResourceSpec>  addAttachmentToLogicalResourceSpec(
    		@ApiParam(value = "Identifier of the LogicalResourceSpec",required=true) @PathVariable("id") String id, 
    		@ApiParam(value = "The Attachment object to be added" ,required=false )  @Valid @ModelAttribute("attachment") String attachment, 
    		@ApiParam(value = "The Attachment file to be added" ,required=false, name = "afile" )  @Valid MultipartFile afile){

		try {

			log.info("addAttachmentToLogicalResourceSpec attachment=" + attachment);
			log.info("addAttachmentToLogicalResourceSpec file=" + afile);
			
			Attachment att = objectMapper.readValue(attachment, Attachment.class);
			log.info("addAttachmentToServiceSpecification att=" + att);
			
			LogicalResourceSpec c = (LogicalResourceSpec) resourceSpecificationRepoService.addAttachmentToResourceSpec( id, att, afile );

			return new ResponseEntity<LogicalResourceSpec>(c, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<LogicalResourceSpec>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }


}
