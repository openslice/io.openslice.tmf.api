package io.openslice.tmf.scm633.reposervices;

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
import io.openslice.tmf.scm633.model.ServiceCandidateCreate;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCatalogUpdate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationRef;
import io.openslice.tmf.scm633.repo.CatalogRepository;

@Service
public class CatalogRepoService {

	@Autowired
	CatalogRepository catalogRepo;

	@Autowired
	CategoryRepoService categRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepoService;

	@Autowired
	CandidateRepoService candidateRepoService;

	public ServiceCatalog addCatalog(ServiceCatalog c) {

		return this.catalogRepo.save(c);
	}

	public ServiceCatalog addCatalog(@Valid ServiceCatalogCreate serviceCat) {

		ServiceCatalog sc = new ServiceCatalog();

		sc = updateCatalogDataFromAPICall(sc, serviceCat);
		return this.catalogRepo.save(sc);
	}

	public List<ServiceCatalog> findAll() {
		return (List<ServiceCatalog>) this.catalogRepo.findAll();
	}

	public ServiceCatalog findById(String id) {
		Optional<ServiceCatalog> optionalCat = this.catalogRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceCatalog> optionalCat = this.catalogRepo.findByUuid(id);
		this.catalogRepo.delete(optionalCat.get());
		return null;

	}

	public ServiceCatalog updateCatalog(String id, ServiceCatalogUpdate serviceCatalog) {

		Optional<ServiceCatalog> optSC = catalogRepo.findByUuid(id);
		if (optSC == null) {
			return null;
		}
		ServiceCatalog sc = optSC.get();
		sc = updateCatalogDataFromAPICall(sc, serviceCatalog);
		return this.catalogRepo.save(sc);
	}

	public ServiceCatalog updateCatalogDataFromAPICall(ServiceCatalog sc, ServiceCatalogUpdate serviceCatalog) {
		sc.setName(serviceCatalog.getName());
		sc.setDescription(serviceCatalog.getDescription());
		if (serviceCatalog.getLifecycleStatus() == null) {
			sc.setLifecycleStatusEnum(ELifecycle.LAUNCHED);
		} else {
			sc.setLifecycleStatusEnum(ELifecycle.getEnum(serviceCatalog.getLifecycleStatus()));
		}
		if (serviceCatalog.getVersion() == null) {
			sc.setVersion("1.0.0");
		} else {
			sc.setVersion(serviceCatalog.getVersion());
		}
		sc.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		TimePeriod tp = new TimePeriod();
		if (serviceCatalog.getValidFor() != null) {
			tp.setStartDateTime(serviceCatalog.getValidFor().getStartDateTime());
			tp.setEndDateTime(serviceCatalog.getValidFor().getEndDateTime());
		}
		sc.setValidFor(tp);

		sc.getCategoryObj().clear();

		// add any new category
		if (serviceCatalog.getCategory() != null) {
			for (ServiceCategoryRef scref : serviceCatalog.getCategory()) {
				ServiceCategory servcat = this.categRepoService.findByUuid(scref.getId());
				sc.addCategory(servcat);
			}
		}

		return sc;

	}

	@PostConstruct
	public void initRepo() {
		if (this.findAll().size() == 0) {
			ServiceCatalogCreate sc = new ServiceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Catalog");
			sc.setVersion("1.0");
			ServiceCatalog scatalog = this.addCatalog(sc);

			ServiceCategoryCreate scatCreate = new ServiceCategoryCreate();
			scatCreate.setName("Generic Services");
			scatCreate.setDescription("Generic Services of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ServiceCategory scategory = this.categRepoService.addCategory(scatCreate);

			scatalog.getCategoryObj().add(scategory);
			this.catalogRepo.save(scatalog);

			ServiceSpecification serviceSpecificationObj = this.specRepoService.initRepo();
			
//			ServiceSpecificationCreate spec = new ServiceSpecificationCreate();
//			spec.setName("GST");
//			spec.setDescription("GST example");
//			ServiceSpecification serviceSpecificationObj = this.specRepoService.addServiceSpecification(spec);
//			serviceSpecificationObj = createGSTExample(serviceSpecificationObj);
//			serviceSpecificationObj = this.specRepoService.serviceSpecificationRepo.save(serviceSpecificationObj);

			ServiceCandidateCreate scand = new ServiceCandidateCreate();
			scand.setName( serviceSpecificationObj.getName());
			ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
			serviceSpecificationRef.setId(serviceSpecificationObj.getId());
			serviceSpecificationRef.setName(serviceSpecificationObj.getName());
			scand.serviceSpecification(serviceSpecificationRef);

			ServiceCategoryRef categoryItem = new ServiceCategoryRef();
			categoryItem.setId(scategory.getId());
			scand.addCategoryItem(categoryItem);

			this.candidateRepoService.addServiceCandidate(scand);
		}
	}

	

}
