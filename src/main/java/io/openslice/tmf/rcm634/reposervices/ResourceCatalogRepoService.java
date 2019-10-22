package io.openslice.tmf.rcm634.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.rcm634.model.ResourceCandidateCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalog;
import io.openslice.tmf.rcm634.model.ResourceCatalogCreate;
import io.openslice.tmf.rcm634.model.ResourceCatalogUpdate;
import io.openslice.tmf.rcm634.model.ResourceCategory;
import io.openslice.tmf.rcm634.model.ResourceCategoryCreate;
import io.openslice.tmf.rcm634.model.ResourceCategoryRef;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.repo.ResourceCatalogRepository;

@Service
public class ResourceCatalogRepoService {

	@Autowired
	ResourceCatalogRepository catalogRepo;

	@Autowired
	ResourceCategoryRepoService categRepoService;

	@Autowired
	ResourceSpecificationRepoService resourceSpecRepoService;

	@Autowired
	ResourceCandidateRepoService candidateRepoService;

	public ResourceCatalog addCatalog(ResourceCatalog c) {

		return this.catalogRepo.save(c);
	}

	public ResourceCatalog addCatalog(@Valid ResourceCatalogCreate serviceCat) {

		ResourceCatalog sc = new ResourceCatalog();

		sc = updateCatalogDataFromAPICall(sc, serviceCat);
		return this.catalogRepo.save(sc);
	}

	public List<ResourceCatalog> findAll() {
		return (List<ResourceCatalog>) this.catalogRepo.findAll();
	}

	public ResourceCatalog findById(String id) {
		Optional<ResourceCatalog> optionalCat = this.catalogRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ResourceCatalog> optionalCat = this.catalogRepo.findByUuid(id);
		this.catalogRepo.delete(optionalCat.get());
		return null;

	}

	public ResourceCatalog updateCatalog(String id, ResourceCatalogUpdate serviceCatalog) {

		Optional<ResourceCatalog> optSC = catalogRepo.findByUuid(id);
		if (optSC == null) {
			return null;
		}
		ResourceCatalog sc = optSC.get();
		sc = updateCatalogDataFromAPICall(sc, serviceCatalog);
		return this.catalogRepo.save(sc);
	}

	public ResourceCatalog updateCatalogDataFromAPICall(ResourceCatalog rc, ResourceCatalogUpdate resCatalog) {
		rc.setName(resCatalog.getName());
		rc.setDescription(resCatalog.getDescription());
		if (resCatalog.getLifecycleStatus() == null) {
			rc.setLifecycleStatusEnum(ELifecycle.LAUNCHED);
		} else {
			rc.setLifecycleStatusEnum(ELifecycle.getEnum(resCatalog.getLifecycleStatus()));
		}
		if (resCatalog.getVersion() == null) {
			rc.setVersion("1.0.0");
		} else {
			rc.setVersion(resCatalog.getVersion());
		}
		rc.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		TimePeriod tp = new TimePeriod();
		if (resCatalog.getValidFor() != null) {
			tp.setStartDateTime(resCatalog.getValidFor().getStartDateTime());
			tp.setEndDateTime(resCatalog.getValidFor().getEndDateTime());
		}
		rc.setValidFor(tp);

		rc.getCategoryObj().clear();

		// add any new category
		if (resCatalog.getCategory() != null) {
			for (ResourceCategoryRef scref : resCatalog.getCategory()) {
				ResourceCategory servcat = this.categRepoService.findByUuid(scref.getId());
				rc.addCategory(servcat);
			}
		}

		return rc;

	}

	@PostConstruct
	public void initRepo() {
		if (this.findAll().size() == 0) {
			ResourceCatalogCreate sc = new ResourceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Resource Catalog");
			sc.setVersion("1.0");
			ResourceCatalog scatalog = this.addCatalog(sc);

			ResourceCategoryCreate scatCreate = new ResourceCategoryCreate();
			scatCreate.setName("Generic Resources");
			scatCreate.setDescription("Generic Resources of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ResourceCategory scategory = this.categRepoService.addCategory(scatCreate);

			scatalog.getCategoryObj().add(scategory);
			this.catalogRepo.save(scatalog);

			ResourceSpecification resSpecificationObj = this.resourceSpecRepoService.initRepo();
			
//			ResourceSpecificationCreate spec = new ResourceSpecificationCreate();
//			spec.setName("GST");
//			spec.setDescription("GST example");
//			ResourceSpecification serviceSpecificationObj = this.specRepoService.addResourceSpecification(spec);
//			serviceSpecificationObj = createGSTExample(serviceSpecificationObj);
//			serviceSpecificationObj = this.specRepoService.serviceSpecificationRepo.save(serviceSpecificationObj);

			ResourceCandidateCreate scand = new ResourceCandidateCreate();
			scand.setName( resSpecificationObj.getName());
			ResourceSpecificationRef resSpecificationRef = new ResourceSpecificationRef();
			resSpecificationRef.setId(resSpecificationObj.getId());
			resSpecificationRef.setName(resSpecificationObj.getName());
			scand.resourceSpecification(resSpecificationRef);

			ResourceCategoryRef categoryItem = new ResourceCategoryRef();
			categoryItem.setId(scategory.getId());
			scand.addCategoryItem(categoryItem);

			this.candidateRepoService.addResourceCandidate(scand);
		}
	}

	

}
