package io.openslice.tmf.so641.reposervices;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.model.ServiceOrderCreate;
import io.openslice.tmf.so641.repo.ServiceOrderRepository;

@Service
public class ServiceOrderRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceOrderRepository serviceOrderRepo;

	public List<ServiceOrder> findAll() {

		return (List<ServiceOrder>) this.serviceOrderRepo.findAll();
	}

	public ServiceOrder addServiceOrder(@Valid ServiceOrderCreate serviceOrder) {
		ServiceOrder so = new ServiceOrder();
		so.getOrderItem().addAll( serviceOrder.getOrderItem());
		so = this.serviceOrderRepo.save( so );
		return so;
	}

}
