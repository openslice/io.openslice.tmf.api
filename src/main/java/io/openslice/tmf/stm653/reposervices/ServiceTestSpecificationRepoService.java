package io.openslice.tmf.stm653.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.stm653.repo.ServiceTestSpecificationRepository;

@Service
public class ServiceTestSpecificationRepoService {

	@Autowired
	ServiceTestSpecificationRepository aServiceTestSpecificationRepo;
}
